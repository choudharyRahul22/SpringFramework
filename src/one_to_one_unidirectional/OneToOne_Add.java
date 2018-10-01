package one_to_one_unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class OneToOne_Add {

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
					/*// create instructor object
					Instructor instructor = 
							new Instructor("Madhu", "Patel", "madhu@luv2code.com");
					
					// create instructor detail object
					InstructorDetail instructorDetail =
							new InstructorDetail(
									"http://www.youtube.com",
									"Guitar");
					
					// set instructor detail in instructor class or associate the objects
					instructor.setInstructorDetailId(instructorDetail);*/
					
					// create instructor object
					Instructor instructor = 
							new Instructor("Rahul", "Choudhary", "rahul@123.com");
					
					// create InstructorDetail object
					InstructorDetail instructorDetail =
							new InstructorDetail(
									"http://www.youtube.com",
									"Badminton");
					
					// set InstructorDetail in instructor class or associate the objects
					instructor.setInstructorDetailId(instructorDetail);
					
					// start a transaction
					session.beginTransaction();
					
					// save the instructor
					// Note: this will ALSO save the details object because of CascadeType.ALL
					System.out.println("Saving Instructor - " + instructor);
					session.save(instructor);
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
					
				} finally {
					factory.close();
				}
	}
}
