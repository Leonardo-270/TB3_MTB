package pe.edu.upc.trabajofinal.model.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name ="Bike",
		indexes = {@Index(columnList = "name",name="bikes_index_name"),
				@Index(columnList = "model",name ="bikes_index_model")
				})
@SequenceGenerator(name="genBike", initialValue = 1)

public class Bike {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genBike")
	@Column (name = "idBike",columnDefinition = "NUMERIC(4)")	
	private Integer id;
	@Column(name="name", length = 45, nullable = false)
	private String name;
	@Column(name="model", length = 45,nullable = false)
	private String model;
	@Column(name="size", length = 10, nullable = false)
	private String size;
	@Column(name="ring", length = 10, nullable = false)
	private String ring;
	@Column(name="quantity", length = 4, nullable = false)
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name="idType", nullable = false)
	private Type type;
	
	@ManyToOne
	@JoinColumn(name="ruc", nullable = false)
	private Company company;
	
	@ManyToOne
	@JoinColumn(name="id", nullable = false)
	private Brand brand;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="bikes_customers",
	joinColumns = {@JoinColumn(referencedColumnName = "idBike",name = "idBike")},
	inverseJoinColumns = {@JoinColumn(referencedColumnName = "idCustomer",name = "idCustomer")})
	private List<Customer> customers;
	
	@OneToMany(mappedBy = "bike", fetch = FetchType.LAZY)
	private List<Reservation> reservations;
	
	public Bike() {
		 customers = new ArrayList<Customer>();
		 reservations = new ArrayList<Reservation>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getRing() {
		return ring;
	}

	public void setRing(String ring) {
		this.ring = ring;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	
	
	
}
