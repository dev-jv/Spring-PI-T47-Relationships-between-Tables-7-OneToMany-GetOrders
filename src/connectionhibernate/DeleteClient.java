package connectionhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteClient {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Client.class)
									.addAnnotatedClass(DetailsClient.class)
									.buildSessionFactory();
		
		// create session
		Session mySession = myFactory.openSession();
		
		try {
			
			// start a transaction
			mySession.beginTransaction();
			
			// create a client object to delete
			Client clientX = mySession.get(Client.class, 4);
			
			if(clientX!=null) {
				
				System.out.println(" <> ---- Removing from DB");
				//Delete
				mySession.delete(clientX);
			}
			
			// commit transaction
			mySession.getTransaction().commit();
			
			if(clientX!=null) System.out.println(" <> ---- Registration correctly deleted in the DB");
			else System.out.println(" <> ---- There is nothing to remove");
			mySession.close();
			
		} finally {
			
			myFactory.close();
			
		}
		
	}

}
