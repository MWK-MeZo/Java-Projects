

--============ stored proc for every table to =============
--============= Insert , Delete , Update ==================

---============= User Table =>

--=== insert

CREATE PROCEDURE InsertUser
    @Username NVARCHAR(255),
    @Email NVARCHAR(255),
    @Role NVARCHAR(50),
    @Password NVARCHAR(255)
AS
BEGIN
    INSERT INTO [User] (username, email, role, password)
    VALUES (@Username, @Email, @Role, @Password);
END;

--====  Delete  

CREATE PROCEDURE DeleteUser
    @UserID INT
AS
BEGIN
    DELETE FROM [User]
    WHERE user_id = @UserID;
END;


--====  Update

CREATE PROCEDURE UpdateUser
    @UserID INT,
    @Username NVARCHAR(255),
    @Email NVARCHAR(255),
    @Role NVARCHAR(50),
    @Password NVARCHAR(255)
AS
BEGIN
    UPDATE [User]
    SET username = @Username, email = @Email, role = @Role, password = @Password
    WHERE user_id = @UserID;
END;

--===============================================

--=====  Course Table  =>

--==== Insert

CREATE PROCEDURE InsertCourse
    @UserID INT,
    @Title NVARCHAR(255),
    @Description NVARCHAR(MAX)
AS
BEGIN
    INSERT INTO Course (user_id, title, description)
    VALUES (@UserID, @Title, @Description);
END;


--==== Delete 

CREATE PROCEDURE DeleteCourse
    @CourseID INT
AS
BEGIN
    DELETE FROM Course
    WHERE course_id = @CourseID;
END;

--===== Update  

CREATE PROCEDURE UpdateCourse
    @CourseID INT,
    @UserID INT,
    @Title NVARCHAR(255),
    @Description NVARCHAR(MAX)
AS
BEGIN
    UPDATE Course
    SET user_id = @UserID, title = @Title, description = @Description
    WHERE course_id = @CourseID;
END;


--======================================  Module Table =>

--==== Insert

CREATE PROCEDURE InsertModule
    @CourseID INT,
    @Title NVARCHAR(255),
    @Description NVARCHAR(MAX)
AS
BEGIN
    INSERT INTO Module (course_id, title, description)
    VALUES (@CourseID, @Title, @Description);
END;


--===== Update 

CREATE PROCEDURE DeleteModule
    @ModuleID INT
AS
BEGIN
    DELETE FROM Module
    WHERE module_id = @ModuleID;
END;



--====== Update

CREATE PROCEDURE UpdateModule
    @ModuleID INT,
    @CourseID INT,
    @Title NVARCHAR(255),
    @Description NVARCHAR(MAX)
AS
BEGIN
    UPDATE Module
    SET course_id = @CourseID, title = @Title, description = @Description
    WHERE module_id = @ModuleID;
END;


--=======================================  Lesson Table =>


--============insert 

CREATE PROCEDURE InsertLesson
    @ModuleID INT,
    @Title NVARCHAR(255),
    @Content NVARCHAR(MAX)
AS
BEGIN
    INSERT INTO Lesson (module_id, title, content)
    VALUES (@ModuleID, @Title, @Content);
END;


--===== Delete

CREATE PROCEDURE DeleteLesson
    @LessonID INT
AS
BEGIN
    DELETE FROM Lesson
    WHERE lesson_id = @LessonID;
END;


---===========  Update

CREATE PROCEDURE UpdateLesson
    @LessonID INT,
    @ModuleID INT,
    @Title NVARCHAR(255),
    @Content NVARCHAR(MAX)
AS
BEGIN
    UPDATE Lesson
    SET module_id = @ModuleID, title = @Title, content = @Content
    WHERE lesson_id = @LessonID;
END;


---================  Content Table =>

--====  Insert

CREATE PROCEDURE InsertContent
    @LessonID INT,
    @Title NVARCHAR(255),
    @ContentType NVARCHAR(50),
    @FilePath NVARCHAR(255)
AS
BEGIN
    INSERT INTO Content (lesson_id, title, content_type, file_path)
    VALUES (@LessonID, @Title, @ContentType, @FilePath);
END;

--============ Delete

CREATE PROCEDURE DeleteContent
    @ContentID INT
AS
BEGIN
    DELETE FROM Content
    WHERE content_id = @ContentID;
END;


--========== Update

CREATE PROCEDURE UpdateContent
    @ContentID INT,
    @LessonID INT,
    @Title NVARCHAR(255),
    @ContentType NVARCHAR(50),
    @FilePath NVARCHAR(255)
AS
BEGIN
    UPDATE Content
    SET lesson_id = @LessonID, title = @Title, content_type = @ContentType, file_path = @FilePath
    WHERE content_id = @ContentID;
END;


--===============  Enrollment Table=>

--== insert 

CREATE PROCEDURE InsertEnrollment
    @StudentID INT,
    @CourseID INT,
    @EnrollmentDate DATE
AS
BEGIN
    INSERT INTO Enrollment (student_id, course_id, enrollment_date)
    VALUES (@StudentID, @CourseID, @EnrollmentDate);
END;



---========== Delete

CREATE PROCEDURE DeleteEnrollment
    @EnrollmentID INT
AS
BEGIN
    DELETE FROM Enrollment
    WHERE enrollment_id = @EnrollmentID;
END;


--====== Update

CREATE PROCEDURE UpdateEnrollment
    @EnrollmentID INT,
    @StudentID INT,
    @CourseID INT,
    @EnrollmentDate DATE
AS
BEGIN
    UPDATE Enrollment
    SET student_id = @StudentID, course_id = @CourseID, enrollment_date = @EnrollmentDate
    WHERE enrollment_id = @EnrollmentID;
END;


--===================  Grade Table =>

--== insert

CREATE PROCEDURE InsertGrade
    @CourseID INT,
    @StudentID INT,
    @Grade NVARCHAR(2)
AS
BEGIN
    INSERT INTO Grade (course_id, student_id, grade)
    VALUES (@CourseID, @StudentID, @Grade);
END;


--=== delete

CREATE PROCEDURE DeleteGrade
    @GradeID INT
AS
BEGIN
    DELETE FROM Grade
    WHERE grade_id = @GradeID;
END;


--=== update

CREATE PROCEDURE UpdateGrade
    @GradeID INT,
    @CourseID INT,
    @StudentID INT,
    @Grade NVARCHAR(2)
AS
BEGIN
    UPDATE Grade
    SET course_id = @CourseID, student_id = @StudentID, grade = @Grade
    WHERE grade_id = @GradeID;
END;


--=================== Message Table =>

--=== insert-----------------------

CREATE PROCEDURE InsertMessage
    @SenderID INT,
    @ReceiverID INT,
    @Subject NVARCHAR(255),
    @Content NVARCHAR(MAX)
AS
BEGIN
    INSERT INTO Message (sender_id, receiver_id, subject, content, Timestamp )
    VALUES (@SenderID, @ReceiverID, @Subject, @Content, getdate());
END;


--=== delete

CREATE PROCEDURE DeleteMessage
    @MessageID INT
AS
BEGIN
    DELETE FROM Message
    WHERE message_id = @MessageID;
END;

--================== 



