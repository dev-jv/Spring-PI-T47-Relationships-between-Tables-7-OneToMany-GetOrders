package connectionhibernate;

import java.util.ArrayList;
import java.util.List;

//import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="client")
public class Client {
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Request> getOrders() {
		return orders;
	}

	public Client(String nombre, String apellidos, String direccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}

	public Client() {
	}
	
	public DetailsClient getDetailsClient() {
		return detailsClient;
	}

	public void setDetailsClient(DetailsClient detailsClient) {
		this.detailsClient = detailsClient;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ "]";
	}
	
	public void addRequests(Request order) {
		if(orders==null) orders = new ArrayList<>();
		orders.add(order);
		order.setClientId(this);
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private DetailsClient detailsClient;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="direccion")
	private String direccion;
	
	@OneToMany(mappedBy="clientId", cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Request> orders; 
	
	
}











/*

	>> Mapeo ORM

	@OneToOne(cascade=CascadeType.ALL)
	
	Especifica el tipo de relacion, y la operacion (cascade).
	
	@JoinColumn(name="id")

	Especifica a través de qué campo se relacionan ambas tablas, en este caso id.

*/

/*

	@GeneratedValue(strategy = GenerationType.IDENTITY)

Como parámetro tiene 4 formas de crear un campo clave.
	
Permite crear un campo clave en Hibernate, ya que configuramos un auto-increment utilizaremos IDENTITY .

Ahora habrá sincronización entre el nro asignado de Id en Hibernate y MySQL.
*/

/*
	@Id
	
Is necessary!
	
Since each row in a sql database should have a unique identifier, hibernate forces you to define one.

*/

/*
	@Entity

Hibernate transforma las clases en entidades, para poder realizar el mapeo.

*/