package one_to_one_bi_delete_only_one;

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
					System.out.println("Getting Instructor and Instructor Detail using Instructor Detail");
					
					// start a transaction
					session.beginTransaction();
					
					int id = 2;
					InstructorDetail detail = session.get(InstructorDetail.class, id);
					
					if (detail != null) {
						// instructor detail
						System.out.println(detail);
						
						// remove the associated object reference, break bi-direction link
						detail.getInstructor().setInstructorDetailId(null);
						
						// delete instructor detail this will delete related instructor
						session.delete(detail);
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
