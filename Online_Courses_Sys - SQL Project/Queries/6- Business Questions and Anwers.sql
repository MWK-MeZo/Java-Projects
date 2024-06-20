--==================== Bussniess Question & answers -====================

--========== Admin QUestions & answers ===================

--1= all the student that don't has courses yet
--=> View StudentsNotEnrolledInCourses()

CREATE VIEW StudentsNotEnrolledInCourses AS
SELECT u.user_id, u.username, u.email, u.role
FROM [User] u LEFT JOIN Enrollment e ON u.user_id = e.student_id
WHERE u.role = 'student' AND e.course_id IS NULL;

--2= all the ins that don't uploaded Courses yet
--=> View InstructorsWithoutCourses()

CREATE VIEW InstructorsWithoutCourses AS
SELECT u.user_id, u.username, u.email, u.role
FROM [User] u LEFT JOIN Course c 
ON u.user_id = c.user_id
WHERE u.role = 'instructor' AND c.course_id IS NULL;


--3= all the courses with no students
--=> View NonEnrolledCoursesOnly()

CREATE VIEW NonEnrolledCoursesOnly AS
SELECT c.course_id, c.title, c.description
FROM Course c LEFT JOIN Enrollment e 
ON c.course_id = e.course_id
WHERE e.course_id IS NULL;

--4= the top n courses with the highest number of student enrolled in
--=> Function GetTopNCoursesWithHieghestSold() 

CREATE FUNCTION GetTopNCoursesWithHighestSold (@TopN INT)
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

--5= all the student
--=> View StudentOnly()

CREATE VIEW StudentsOnly AS
SELECT user_id, username, email, role
FROM [User]
WHERE role = 'student';


--6= all the ins
--=> View InstructorOnly

CREATE VIEW InstructorsOnly AS
SELECT user_id, username, email, role
FROM [User]
WHERE role = 'instructor';

--================ student QUestions & answers =========

--7= show a specific course with it's grade
--=> FUNCTION show_course_with_grade(student_id INT, course_id INT)

CREATE FUNCTION show_course_with_grade(@student_id INT, @course_id INT)
RETURNS TABLE
AS
RETURN
    SELECT c.title AS course_title, g.grade
    FROM Course c
    JOIN Grade g ON c.course_id = g.course_id
    WHERE g.student_id = @student_id AND c.course_id = @course_id;


--8= show his all courses and his grades
--=> FUNCTION show_student_courses_and_grades(student_id INT)

CREATE FUNCTION show_student_courses_and_grades(@student_id INT)
RETURNS TABLE
AS
RETURN
    SELECT c.title AS course_title, g.grade
    FROM Course c
    JOIN Grade g ON c.course_id = g.course_id
    WHERE g.student_id = @student_id;


--===============  instructor Questions & answers ==========

--9= show all his courses and the count of student enrolled in 
--=> FUNCTION show_instructor_courses_and_enrollment_count(instructor_id INT)

CREATE FUNCTION show_instructor_courses_and_enrollment_count(@instructor_id INT)
RETURNS TABLE
AS
RETURN
    SELECT c.title AS course_title, COUNT(e.student_id) AS student_count
    FROM Course c
    LEFT JOIN Enrollment e ON c.course_id = e.course_id
    WHERE c.user_id = @instructor_id
    GROUP BY c.course_id, c.title;



--10= show all his courses with the highest enrolled
--=> FUNCTION show_instructor_courses_with_highest_enrollment(instructor_id INT)

CREATE FUNCTION show_instructor_courses_with_highest_enrollment(@instructor_id INT)
RETURNS TABLE
AS
RETURN
    WITH CourseEnrollments AS (
        SELECT c.course_id, c.title, COUNT(e.student_id) AS student_count
        FROM Course c
        LEFT JOIN Enrollment e ON c.course_id = e.course_id
        WHERE c.user_id = @instructor_id
        GROUP BY c.course_id, c.title
    )
    SELECT ce.title, ce.student_count
    FROM CourseEnrollments ce
    WHERE ce.student_count = (
        SELECT MAX(student_count)
        FROM CourseEnrollments
    );


--11= show all his courses with no enrollments
--=> FUNCTION show_instructor_courses_with_no_enrollments(instructor_id INT)

CREATE FUNCTION show_instructor_courses_with_no_enrollments(@instructor_id INT)
RETURNS TABLE
AS
RETURN
    SELECT c.title AS course_title
    FROM Course c
    LEFT JOIN Enrollment e ON c.course_id = e.course_id
    WHERE c.user_id = @instructor_id
    GROUP BY c.course_id, c.title
    HAVING COUNT(e.student_id) = 0;


--========== mix 
--12= show all the instrucors name with he searches for
--=>  FUNCTION search_instructors_by_name(search_term VARCHAR)

alter FUNCTION sys_admin.search_instructors_by_name(@search_term VARCHAR)
RETURNS TABLE
AS
RETURN
    SELECT u.username AS instructor_name
    FROM [Online_Courses_Sys].ins.instructorsOnly u
    WHERE u.role = 'instructor' AND u.username LIKE '%' + @search_term + '%';

--13= show all the courses to a spesific instructor
--=> FUNCTION show_instructor_courses_and_student_count(instructor_id INT)

CREATE FUNCTION show_instructor_courses_and_student_count(@instructor_id INT)
RETURNS TABLE
AS
RETURN
    SELECT c.title AS course_title, COUNT(e.student_id) AS student_count
    FROM Course c
    LEFT JOIN Enrollment e ON c.course_id = e.course_id
    WHERE c.user_id = @instructor_id
    GROUP BY c.course_id, c.title;



--14= Show all courses name with he searches for
--=> FUNCTION search_courses_by_name(search_term VARCHAR)

CREATE FUNCTION search_courses_by_name(@search_term VARCHAR)
RETURNS TABLE
AS
RETURN
    SELECT c.title AS course_title
    FROM Course c
    WHERE c.title LIKE '%' + @search_term + '%';

--15= show The Course data , course's modules , course's lessons and course's contents to a specific course
--=> get_course_details(@course_id INT)

CREATE FUNCTION get_course_details(@course_id INT)
RETURNS TABLE
AS
RETURN
    WITH CourseDetails AS (
        SELECT c.course_id, c.title AS course_title,c.description AS course_description, m.module_id,
            m.title AS module_title, m.description AS module_description, l.lesson_id,
            l.title AS lesson_title, co.content_id, co.title AS content_title,
            co.content_type, co.file_path
        FROM Course c
        LEFT JOIN Module m ON c.course_id = m.course_id
        LEFT JOIN Lesson l ON m.module_id = l.module_id
        LEFT JOIN Content co ON l.lesson_id = co.lesson_id
        WHERE c.course_id = @course_id
    )
    SELECT *
    FROM CourseDetails;

--========================

