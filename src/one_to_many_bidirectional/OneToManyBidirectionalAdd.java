package one_to_many_bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyBidirectionalAdd {
	
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
			
			InstructorDetail detail = new InstructorDetail("My Channel", "New Technologies");
			
			Instructor instructor = new Instructor("Rahul","Choudhary","thecrazzyrahul@gmail.com");
			
			instructor.setInstructorDetailId(detail);
			
			// save instructor
			session.save(instructor);
			
			System.out.println("Instructor saved to db");
			
			// get instructor
			int id = 1;
			Instructor instructor2 = session.get(Instructor.class, id);
			
			System.out.println("Getting instructor from db " + instructor2);
			// create courses
			Course course1 = new Course("Spring Framework");
			Course course2 = new Course("Hibernate Framework");
			
			// use convenience method for bi directional relationship
			instructor2.addCourse(course1);
			instructor2.addCourse(course2);
			
			System.out.println("Saving couses " + instructor2);
			
			// save course
			session.save(course1);
			session.save(course2);
			
			
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
