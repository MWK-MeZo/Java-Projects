
Create Database Online_Courses_Sys

use Online_Courses_Sys

CREATE TABLE [User] (
  [user_id] int PRIMARY KEY,
  [username] nvarchar(255),
  [email] nvarchar(255),
  [role] nvarchar(255),
  [password] nvarchar(255)
)
GO

CREATE TABLE [Message] (
  [message_id] int PRIMARY KEY,
  [sender_id] int,
  [receiver_id] int,
  [subject] nvarchar(255),
  [content] text,
  [timestamp] datetime
)
GO

CREATE TABLE [Course] (
  [course_id] int PRIMARY KEY,
  [user_id] int,
  [title] nvarchar(255),
  [description] text
)
GO

CREATE TABLE [Enrollment] (
  [enrollment_id] int PRIMARY KEY,
  [student_id] int,
  [course_id] int,
  [enrollment_date] date
)
GO

CREATE TABLE [Grade] (
  [grade_id] int PRIMARY KEY,
  [course_id] int,
  [student_id] int,
  [grade] nvarchar(255)
)
GO

CREATE TABLE [Module] (
  [module_id] int PRIMARY KEY,
  [course_id] int,
  [title] nvarchar(255),
  [description] text
)
GO

CREATE TABLE [Lesson] (
  [lesson_id] int PRIMARY KEY,
  [module_id] int,
  [title] nvarchar(255),
  [content] text
)
GO

CREATE TABLE [Content] (
  [content_id] int PRIMARY KEY,
  [lesson_id] int,
  [title] nvarchar(255),
  [content_type] nvarchar(255),
  [file_path] nvarchar(255)
)
GO

ALTER TABLE [Message] ADD FOREIGN KEY ([sender_id]) REFERENCES [User] ([user_id])
GO

ALTER TABLE [Message] ADD FOREIGN KEY ([receiver_id]) REFERENCES [User] ([user_id])
GO

ALTER TABLE [Course] ADD FOREIGN KEY ([user_id]) REFERENCES [User] ([user_id])
GO

ALTER TABLE [Enrollment] ADD FOREIGN KEY ([student_id]) REFERENCES [User] ([user_id])
GO

ALTER TABLE [Enrollment] ADD FOREIGN KEY ([course_id]) REFERENCES [Course] ([course_id])
GO

ALTER TABLE [Grade] ADD FOREIGN KEY ([course_id]) REFERENCES [Course] ([course_id])
GO

ALTER TABLE [Grade] ADD FOREIGN KEY ([student_id]) REFERENCES [User] ([user_id])
GO

ALTER TABLE [Module] ADD FOREIGN KEY ([course_id]) REFERENCES [Course] ([course_id])
GO

ALTER TABLE [Lesson] ADD FOREIGN KEY ([module_id]) REFERENCES [Module] ([module_id])
GO

ALTER TABLE [Content] ADD FOREIGN KEY ([lesson_id]) REFERENCES [Lesson] ([lesson_id])
GO
