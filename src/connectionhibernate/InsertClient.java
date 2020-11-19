package connectionhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertClient {

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
			
			// create a client object
//			Client client1 = new Client("Draco", "Strange", "Av. Shimpaku Trees K48, Somewhere City");
//			Client client1 = new Client("Harry", "Strange", "Av. Kaede Trees K48, Somewhere City");
			Client client1 = new Client("Helen", "Teals", "Av. Kuromatsu Trees K48, Somewhere City");
			
			DetailsClient detailsClient1= new DetailsClient("www.SmallBlueTrees.com", "943789523", "Shoganai Concept");
			
			// link to detailsClient1
			client1.setDetailsClient(detailsClient1);
			
			// start a transaction
			mySession.beginTransaction();
			
			// save the object
			mySession.save(client1);
			
			// commit transaction
			mySession.getTransaction().commit();
			
			System.out.println(" <> ---- Registration correctly inserted in the DB");
			
			mySession.close();
			
		} finally {
			
			myFactory.close();
			
		}
		
	}

}
