

--========== View ================

--=== 1. View to Show Students Only

CREATE VIEW StudentsOnly AS
SELECT user_id, username, email, role
FROM [User]
WHERE role = 'student';


--===2. View to Show Instructors Only

CREATE VIEW InstructorsOnly AS
SELECT user_id, username, email, role
FROM [User]
WHERE role = 'instructor';


--=== 3. View to Show Enrolled Courses Only

alter VIEW courses.EnrolledCoursesOnly AS
select * from (
SELECT c.course_id, c.title, c.description,
e.student_id, e.enrollment_date , row_number() over (partition by c.course_id order by c.title) as RN
FROM Course c INNER JOIN Enrollment e 
ON c.course_id = e.course_id) as tab
where RN = 1
--select * from courses.EnrolledCoursesOnly


--=== 4. View to Show Non-Enrolled Courses Only

CREATE VIEW NonEnrolledCoursesOnly AS
SELECT c.course_id, c.title, c.description
FROM Course c LEFT JOIN Enrollment e 
ON c.course_id = e.course_id
WHERE e.course_id IS NULL;


--=== 5. View to Show Instructors Without Courses

alter VIEW ins.InstructorsWithoutCourses AS
SELECT u.user_id, u.username, u.email
FROM [User] u
WHERE u.role = 'instructor'
AND u.user_id NOT IN (SELECT c.user_id FROM Course c);
select * from ins.InstructorsWithoutCourses

--=== 6. View to Show Students Not Enrolled in Any Courses

CREATE VIEW StudentsNotEnrolledInCourses AS
SELECT u.user_id, u.username, u.email, u.role
FROM [User] u LEFT JOIN Enrollment e ON u.user_id = e.student_id
WHERE u.role = 'student' AND e.course_id IS NULL;

--=========== Create Index ====================


--=== Index on username in the User table

CREATE INDEX IDX_User_Username ON [User] (username);

--=== Index on title in the Course table

CREATE INDEX IDX_Course_Title ON Course (title);


--============= CONSTRAINTS & RULES ===================

---=== puting a constrain to make sure that we will have just a Students and instructor
--==== in the User Table
ALTER TABLE [user] ADD CONSTRAINT check_role CHECK (role IN ('student', 'instructor'));

--=== Buting a Rule to the Grade to make sure  
--=== that what we will insert will be a real grade
CREATE RULE Grade_Values AS @vales IN ('A', 'B', 'C' , 'D' , 'F')
sp_bindrule 'Grade_Values', 'dbo.[grade].[grade]'


--============= Triggers ====================

--=== stop all the delete process from enrollment table
create TRIGGER stop_deleting
on  Enrollment   
INSTEAD OF delete 
as 
SELECT 'can’t delete any  record in that table'


--=== Store all the log info for the insertion on enrollment table
-- create a log table (Audit)
create  table Audit_log(
st_id int,
cu_id int,
name varchar(50),
cnew_Id int,
oldhours date,
date2 date
)
--=== create Trigger to insert the log data to the Audit Table
create trigger Log_data 
on Enrollment
after update
as
declare @st_ID int,@cu_ID int,@oldhours date ,@date2 date,@cnew_Id int
select @st_id=student_id from deleted
select @cu_id=course_id from deleted
select @oldhours= enrollment_date from deleted
select @cnew_Id=course_id from inserted
select @date2=  enrollment_date from inserted
INSERT INTO Audit_log (st_id,cu_id,oldhours,cnew_Id,date2,name)  
VALUES(@st_id,@cu_id , @oldhours , @cnew_Id , getdate(),SUSER_NAME())


--============== Schema ===================

--=== Create Schema for all the student data & Process
create schema Student
alter schema student transfer dbo.StudentsOnly
alter schema student transfer dbo.StudentsNotEnrolledInCourses
alter schema student transfer dbo.show_course_with_grade
alter schema student transfer dbo.show_student_courses_and_grades

--=== Create Schema for all the Instructors data & process
create schema ins
alter schema ins transfer dbo.InstructorsWithoutCourses 
alter schema ins transfer dbo.InstructorsOnly
alter schema ins transfer dbo.show_instructor_courses_and_enrollment_count
alter schema ins transfer dbo.show_instructor_courses_with_highest_enrollment
alter schema ins transfer dbo.show_instructor_courses_with_no_enrollments

--=== Create Schema for all the Courses data
create schema courses
alter schema courses transfer dbo.EnrolledCoursesOnly
alter schema courses transfer dbo.NonEnrolledCoursesOnly
alter schema courses transfer dbo.GetTopNCoursesWithHighestSold
alter schema courses transfer dbo.get_course_details

--=== create schema sys_admin for all admin process
create schema sys_admin
alter schema sys_admin transfer dbo.search_courses_by_name
alter schema sys_admin transfer dbo.search_instructors_by_name

--==============  Functions  =========================

--=== Note that all the Functions are aready create in the Bussiness Q&A Query file!
--=== we will not write them here
--=== but we can test them here ^_^

select * from student.show_course_with_grade(1,1)
--====
select * from student.show_student_courses_and_grades(1)
--====
select * from ins.show_instructor_courses_and_enrollment_count(61)
--select * from ins.InstructorsOnly
--select * from courses.EnrolledCoursesOnly
--====
select * from ins.show_instructor_courses_with_highest_enrollment(61)
--====
select * from ins.show_instructor_courses_with_no_enrollments(87)
--select * from courses.NonEnrolledCoursesOnly
--====
select * from courses.GetTopNCoursesWithHighestSold(5)
--====
select * from courses.get_course_details(12)
--====
select * from sys_admin.search_courses_by_name('law')
--====
select * from sys_admin.search_instructors_by_name('ins')

--============== Cursor ================================
--=== Useing the Cursor, we will return all the students names and grades 
--=== that Enrolled in this course
CREATE FUNCTION GetUsersAndGradesInCourse (@user_id INT, @course_name NVARCHAR(100))
RETURNS @result TABLE (
    username NVARCHAR(100),
    grade CHAR(1)
)
AS
BEGIN
    DECLARE @course_id INT
    DECLARE @student_id INT
    DECLARE @username NVARCHAR(100)
    DECLARE @grade CHAR(1)
    -- Find the course_id from the course_name
    SELECT @course_id = course_id
    FROM Course
    WHERE title = @course_name;
    -- Cursor to iterate through students enrolled in the course
    DECLARE student_cursor CURSOR FOR
    SELECT e.student_id, u.username, g.grade
    FROM Enrollment e
    JOIN [User] u ON e.student_id = u.user_id
    JOIN Grade g ON e.course_id = g.course_id AND e.student_id = g.student_id
    WHERE e.course_id = @course_id;
    OPEN student_cursor;

    FETCH NEXT FROM student_cursor INTO @student_id, @username, @grade;
    WHILE @@FETCH_STATUS = 0
    BEGIN
        -- Insert each student's name and grade into the result table
        INSERT INTO @result (username, grade)
        VALUES (@username, @grade);

        FETCH NEXT FROM student_cursor INTO @student_id, @username, @grade;
    END;

    CLOSE student_cursor;
    DEALLOCATE student_cursor;

    RETURN;
END;

-- Example usage
SELECT * FROM GetUsersAndGradesInCourse(54, 'Introduction to Biology');




