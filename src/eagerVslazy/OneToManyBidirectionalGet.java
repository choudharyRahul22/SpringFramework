package eagerVslazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class OneToManyBidirectionalGet {
	
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
            System.out.println("Starting One To Many Birectional Example");
			
			// start a transaction
			session.beginTransaction();
			
			// get instructor
			/*int id = 1;
			Instructor getInstructor = session.get(Instructor.class, id);*/
			
			// get courses
			//System.out.println("Instructor Eager Loaded : " + getInstructor);
			
			// solution 1 : call the getter method while the session is open
			//System.out.println("All Courses : " + getInstructor.getCourses());
			
			
			// solution 2 : use HQL 
			int id = 1;
			Query<Instructor> query = session.createQuery("select i from Instructor i " +
														  "JOIN FETCH i.courses " +
														  "WHERE i.id=:theInstructorId", Instructor.class);
			query.setParameter("theInstructorId", id);
			
			Instructor getInstructor = query.getSingleResult();
			
			// commit transaction
			session.getTransaction().commit();
			
			session.close();
			System.out.println("Session closed");
			
			// loading courses
			// solution 1 : call the getter method while the session is open
			// solution 2 : use HQL 
			System.out.println("All Courses : " + getInstructor.getCourses());
			
			System.out.println("Done!");
			
		} finally {
			// handle connection leak
			session.close();
			
			factory.close();
		}
	}
}
