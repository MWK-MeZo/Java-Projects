

--======== Insert Students

-- Assuming user roles 'student' and 'instructor'
EXEC InsertUser 'student1', 'student1@example.com', 'student', 'password1';
EXEC InsertUser 'student2', 'student2@example.com', 'student', 'password2';
EXEC InsertUser 'student3', 'student3@example.com', 'student', 'password3';
-- Additional students
EXEC InsertUser 'student4', 'student4@example.com', 'student', 'password4';
EXEC InsertUser 'student5', 'student5@example.com', 'student', 'password5';



--======= Insert Instructors

EXEC InsertUser 'instructor1', 'instructor1@example.com', 'instructor', 'password1';
EXEC InsertUser 'instructor2', 'instructor2@example.com', 'instructor', 'password2';
EXEC InsertUser 'instructor3', 'instructor3@example.com', 'instructor', 'password3';
-- Additional instructors
EXEC InsertUser 'instructor4', 'instructor4@example.com', 'instructor', 'password4';
EXEC InsertUser 'instructor5', 'instructor5@example.com', 'instructor', 'password5';


--======== Insert Courses


-- Assuming course cost is stored in the description for simplicity
EXEC InsertCourse 1, 'Free Course 1', 'This course is free.';
EXEC InsertCourse 2, 'Paid Course 1', 'This course costs 100 pounds.';
EXEC InsertCourse 3, 'Paid Course 2', 'This course costs 200 pounds.';
-- Additional courses
EXEC InsertCourse 4, 'Free Course 2', 'This course is free.';
EXEC InsertCourse 5, 'Paid Course 3', 'This course costs 300 pounds.';

--======  Enroll Students

EXEC InsertEnrollment 1, 1, '2024-01-01'; -- Student 1 in Course 1
EXEC InsertEnrollment 1, 2, '2024-01-01'; -- Student 1 in Course 2
EXEC InsertEnrollment 2, 2, '2024-01-01'; -- Student 2 in Course 2
EXEC InsertEnrollment 3, 3, '2024-01-01'; -- Student 3 in Course 3
-- Additional enrollments
EXEC InsertEnrollment 4, 4, '2024-01-01'; -- Student 4 in Course 4


--=======  Assign Instructors


EXEC UpdateCourse 1, 1, 'Free Course 1', 'This course is free.'; -- Instructor 1 teaches Course 1
EXEC UpdateCourse 2, 1, 'Paid Course 1', 'This course costs 100 pounds.'; -- Instructor 1 teaches Course 2
EXEC UpdateCourse 3, 2, 'Paid Course 2', 'This course costs 200 pounds.'; -- Instructor 2 teaches Course 3
-- Additional assignments
EXEC UpdateCourse 4, 3, 'Free Course 2', 'This course is free.'; -- Instructor 3 teaches Course 4



--=========== Insert Grades
EXEC InsertGrade 1, 1, 'A'; -- Student 1 in Course 1
EXEC InsertGrade 2, 1, 'B'; -- Student 1 in Course 2
EXEC InsertGrade 2, 2, 'C'; -- Student 2 in Course 2
EXEC InsertGrade 3, 3, 'F'; -- Student 3 in Course 3 (failed)
-- Additional grades
EXEC InsertGrade 4, 4, 'A'; -- Student 4 in Course 4


--======  Insert Modules


EXEC InsertModule 1, 'Module 1', 'Description for Module 1';
EXEC InsertModule 2, 'Module 2', 'Description for Module 2';
-- Additional modules
EXEC InsertModule 3, 'Module 3', 'Description for Module 3';


--=========  Insert Lessons

EXEC InsertLesson 1, 'Lesson 1', 'Content for Lesson 1';
EXEC InsertLesson 1, 'Lesson 2', 'Content for Lesson 2';
-- Additional lessons
EXEC InsertLesson 2, 'Lesson 3', 'Content for Lesson 3';

--=========== Insert Content


EXEC InsertContent 1, 'Content 1', 'video', 'path/to/video1';
EXEC InsertContent 1, 'Content 2', 'document', 'path/to/document1';
-- Additional content
EXEC InsertContent 2, 'Content 3', 'video', 'path/to/video2';





