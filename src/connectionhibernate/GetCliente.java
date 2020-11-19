package connectionhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCliente {
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
			
			// create a DetailsClient object
			DetailsClient detClients = mySession.get(DetailsClient.class, 25);
			
			System.out.println(" <> ---- Show Details Client");
			System.out.println(detClients); // Show Details P
			
			System.out.println(" <> ---- Show Client");
			System.out.println(detClients.getClient()); // Show Client P <- Details P
			
			System.out.println(" <> ---- Client deleted in cascade");
			mySession.delete(detClients); // ...
			
			// commit transaction
			mySession.getTransaction().commit();
			
		} catch (Exception ex1) {
			
			ex1.printStackTrace(); // Also..
		}
		
		finally {
			
			mySession.close(); // Here!
			myFactory.close();
			
		}
	}
}




/*
	Leaks: Errores de fuga de memoria
	
	El error se presenta en este caso, cuando no halla el registro.
	Y mySession.close(); no se llega a ejecutar
	
	* El error no se presenta en algunos casos, quizás se le puede atribuir a la versión de java...
	
	Se soluciona si creamos y catch con un .printStackTrace y movemos mySession.close();.
	
/*

	El objetivo es obtener en consola datos de un Cliente a partir de los Detalles del Cliente.
	Datos de una tabla solicitándola a otra! :)

*/