package connectionhibernate;

//import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="details_client")
public class DetailsClient {
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getTfno() {
		return tfno;
	}

	public void setTfno(String tfno) {
		this.tfno = tfno;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public DetailsClient(String web, String tfno, String comments) {
		this.web = web;
		this.tfno = tfno;
		this.comments = comments;
	}
	
	public DetailsClient() {
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	@Override
	public String toString() {
		return "DetailsClient [id=" + id + ", web=" + web + ", tfno=" + tfno + ", comments=" + comments + "]";
	}

	@OneToOne(mappedBy="detailsClient", cascade=CascadeType.ALL)
	private Client client;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="web")
	private String web;
	
	@Column(name="tfno")
	private String tfno;
	
	@Column(name="comments")
	private String comments;
	
}












