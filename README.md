# SpringFramework

Hibernate Advance Mapping:
--------------------------

1. One To One Mapping
2. One To Many Mapping & Many To One Mapping
3. Many To Many Mapping

1. One To One Mapping:

Instructor & Instructor Detail (One To One) : instructor have its own details

2. One To Many Mapping

Instructor & Course (One To Many) and Course & Instructor (Many To One) : instructor can have many courses

3. Many To Many

Student & Course (Many To Many) : student can enroll to many courses & course can be enroll by many students

Primary Key Foreign Key & Cascade:
----------------------------------

Primary key : unique identity of a table
Foreign Key : make link between 2 table
Cascade : Apply same to operation to related entities, for ex One To One Mapping (if we save instructor it will save instructor detail also)
cascade type: PERSIST, REMOVE, REFRESH, DETACH, MERGE, ALL, by default no cascade type is defined

Fetch type: Eager Vs Lazy:
--------------------------

Eager : Instructor & Course , if we load instructor it will load all courses for that instructor.
Lazy : Instructor & Course , if we load instructor it will load only instructor and when we load instructor detail than only it will load.

Unidirectional and Bidirectional :
----------------------------------

Unidirectional : Instructor to Instructor Detail
Bidirectional : Instructor to Instructor Detail & Instructor Detail to Instructor

Entity State:
-------------

1.New (transient): an entity is new if it has just been instantiated using the new operator, and it is not associated with a persistence context. 
It has no persistent representation in the database and no identifier value has been assigned.

2.Managed (persistent): a managed entity instance is an instance with a persistent identity that is currently associated with a persistence context.
next flush/commit will save in db

3.Detached: the entity instance is an instance with a persistent identity that is no longer associated with a persistence context, usually 
because the persistence context was closed or the instance was evicted from the context.

4.Removed: a removed entity instance is an instance with a persistent identity, associated with a persistence context, but scheduled for removal 
from the database, next flush/commit will delete from db.

5.Refresh: reload or sync object with data from db. prevents stale data

6.Detach: if entity is detached, it is not associated with a hibernate session.

7.Merge: if instance is detached from session, then merge will reattach with session.


Handle connection leak in finally block : session.close();

