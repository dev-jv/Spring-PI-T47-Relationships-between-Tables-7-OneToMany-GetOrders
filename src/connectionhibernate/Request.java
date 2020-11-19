package connectionhibernate;

import java.util.GregorianCalendar;

import javax.persistence.*;

@Entity
@Table(name="request")
public class Request {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Client getClientId() {
		return clientId;
	}

	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}

	public Request(GregorianCalendar aDate) {
		this.aDate = aDate;
	}

	public Request() {
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", aDate=" + aDate + ", payment=" + payment + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="A_DATE")
	private GregorianCalendar aDate;
	
	@Column(name="PAYMENT")
	private String payment;

	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="CLIENT_ID")
	private Client clientId;
	
}
