package one_to_many_bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyBidirectionalDeleteCourse {
	
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
			int id = 10;
			Course course = session.get(Course.class, id);
			
			System.out.println("Instructor from db " + course);
			
			// delete course
			session.delete(course);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			// handle connection leak
			session.close();
			
			factory.close();
		}
	}
}
