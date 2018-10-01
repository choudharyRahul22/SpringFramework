package one_to_one_unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class OneToOne_Delete {

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
					
					// start a transaction
					session.beginTransaction();
					
					int id = 2;
					
					// get the instructor with id 1
					Instructor instructor = session.get(Instructor.class,id);
					
					// if we get instructor object than delete
					if (instructor != null) {
						System.out.println("about to delete instructor: " + instructor);
						
						// Note : This will also delete InstructorDetail
						session.delete(instructor);
					} else {
						System.out.println("instructor not found");
					}
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
					
				} finally {
					factory.close();
				}
	}
}
