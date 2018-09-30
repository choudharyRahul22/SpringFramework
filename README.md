# SpringFramework

Hibernate Advance Mapping:

1. One To One Mapping
2. One To Many Mapping & Many To One Mapping
3. Many To Many Mapping

1. One To One Mapping:

Instructor & Instructor Detail (One To One) : instructor have its own details

2. One To Many Mapping

Instructor & Course (One To Many) and Course & Instructor (Many To One) : instructor can have many courses

3. Many To Many

Student & Course (Many To Many) : student can enroll to many courses & course can be enroll by many students

Primary Key Foreign Key & Cascade

Primary key : unique identity of a table
Foreign Key : make link between 2 table
Cascade : Apply same to operation to related entities, for ex One To One Mapping (if we save instructor it will save instructor detail also)

Fetch type: Eager Vs Lazy
Eager : Instructor & Course , if we load instructor it will load all courses for that instructor.
Lazy : Instructor & Course , if we load instructor it will load only instructor and when we load instructor detail than only it will load.

Unidirectional and Bidirectional :

Unidirectional : Instructor to Instructor Detail
Bidirectional : Instructor to Instructor Detail & Instructor Detail to Instructor

