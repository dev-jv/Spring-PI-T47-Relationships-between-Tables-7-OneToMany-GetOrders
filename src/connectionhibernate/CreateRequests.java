package connectionhibernate;

import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateRequests {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Client.class)
									.addAnnotatedClass(DetailsClient.class)
									.addAnnotatedClass(Request.class)
									.buildSessionFactory();
		
		// create session
		Session mySession = myFactory.openSession();
		
		try {
			
			
			// start a transaction
			mySession.beginTransaction();
			
			// get client from DB
			Client clientQ = mySession.get(Client.class, 9);
			
			// Create orders
			Request order1 = new Request(new GregorianCalendar(2020,8,4));
			Request order2 = new Request(new GregorianCalendar(2020,6,15));
			Request order3 = new Request(new GregorianCalendar(2020,4,25));
			
			// Link to client
			clientQ.addRequests(order1);
			clientQ.addRequests(order2);
			clientQ.addRequests(order3);
			
			// Save orders
			mySession.save(order1);
			mySession.save(order2);
			mySession.save(order3);
			
			// commit transaction
			mySession.getTransaction().commit();
			
			System.out.println(" <> ---- Orders successfully added to DB ");
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			mySession.close();
			myFactory.close();
			
		}
		
	}
}
