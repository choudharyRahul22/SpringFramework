package one_to_one_bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class OneToOne_Update {

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
					
					int id = 1;
					InstructorDetail detail = session.get(InstructorDetail.class, id);
					
					if (detail != null) {
						// instructor detail
						System.out.println(detail);
						
						// instructor
						System.out.println(detail.getInstructor());
						
						// updating instructor email
						detail.getInstructor().setEmail("thecrazzyrahul@gmail.com");
						
						// update email
						session.update(detail);
					}
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
					
				} finally {
					factory.close();
				}
	}
}
