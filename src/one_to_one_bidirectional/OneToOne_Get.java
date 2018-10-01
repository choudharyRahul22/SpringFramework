package one_to_one_bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class OneToOne_Get {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();
				
				try {
					System.out.println("Getting Instructor and Instructor Detail using Instructor Detail");
					
					// start a transaction
					session.beginTransaction();
					
					int id = 111;
					InstructorDetail detail = session.get(InstructorDetail.class, id);
					
					if (detail != null) {
						// instructor detail
						System.out.println(detail);
						
						// instructor
						System.out.println(detail.getInstructor());
					}
					
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
