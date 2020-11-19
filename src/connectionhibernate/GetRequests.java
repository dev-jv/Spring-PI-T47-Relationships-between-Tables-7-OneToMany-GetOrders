package connectionhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetRequests {
	
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
			Client clientE = mySession.get(Client.class, 9);
			
			System.out.println("Client: " + clientE);
			
			System.out.println("Orders: " + clientE.getOrders());
			
			// commit transaction
			mySession.getTransaction().commit();
			
			System.out.println(" <> ---- Orders successfully obtained! ");
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			mySession.close();
			myFactory.close();
			
		}
		
	}
}
