
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
SELECT c.course_id, c.title, c.description, e.student_id, e.enrollment_date
FROM Course c INNER JOIN Enrollment e ON c.course_id = e.course_id;

--=== 4. View to Show Non-Enrolled Courses Only

CREATE VIEW NonEnrolledCoursesOnly AS
SELECT c.course_id, c.title, c.description
FROM Course c LEFT JOIN Enrollment e ON c.course_id = e.course_id
WHERE e.course_id IS NULL;


--=== 5. View to Show Instructors Without Courses

CREATE VIEW InstructorsWithoutCourses AS
SELECT u.user_id, u.username, u.email, u.role
FROM [User] u LEFT JOIN Course c ON u.user_id = c.user_id
WHERE u.role = 'instructor' AND c.course_id IS NULL;

--=== 6. View to Show Students Not Enrolled in Any Courses

CREATE VIEW StudentsNotEnrolledInCourses AS
SELECT u.user_id, u.username, u.email, u.role
FROM [User] u LEFT JOIN Enrollment e ON u.user_id = e.student_id
WHERE u.role = 'student' AND e.course_id IS NULL;

--================================= Create Index


--=== Index on username in the User table

CREATE INDEX IDX_User_Username ON [User] (username);

--=== Index on title in the Course table

CREATE INDEX IDX_Course_Title ON Course (title);

--===  Functions

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



