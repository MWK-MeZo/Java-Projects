

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

CREATE VIEW EnrolledCoursesOnly AS
SELECT c.course_id, c.title, c.description,
e.student_id, e.enrollment_date
FROM Course c INNER JOIN Enrollment e 
ON c.course_id = e.course_id;

--=== 4. View to Show Non-Enrolled Courses Only

CREATE VIEW NonEnrolledCoursesOnly AS
SELECT c.course_id, c.title, c.description
FROM Course c LEFT JOIN Enrollment e 
ON c.course_id = e.course_id
WHERE e.course_id IS NULL;


--=== 5. View to Show Instructors Without Courses

CREATE VIEW InstructorsWithoutCourses AS
SELECT u.user_id, u.username, u.email, u.role
FROM [User] u LEFT JOIN Course c 
ON u.user_id = c.user_id
WHERE u.role = 'instructor' AND c.course_id IS NULL;

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


--============= CONSTRAINTS & Rules ===================

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


--=== Create Schema for all the student data
create schema [user]
alter schema [user] transfer dbo.StudentsOnly
alter schema [user] transfer dbo.StudentsNotEnrolledInCourses

--=== Create Schema for all the Courses data
create schema courses
alter schema courses transfer dbo.EnrolledCoursesOnly
alter schema courses transfer dbo.NonEnrolledCoursesOnly



--==============  Functions  =========================

--=== get the top n courses with the highest number of enrolled
CREATE FUNCTION dbo.GetTopNCoursesWithHighestSold (@TopN INT)
RETURNS TABLE
AS
RETURN
(
    SELECT TOP (@TopN) c.course_id, c.title, COUNT(e.course_id) AS enrollment_count
    FROM Course c JOIN Enrollment e 
	ON c.course_id = e.course_id
    GROUP BY c.course_id, c.title
    ORDER BY enrollment_count DESC
);


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




