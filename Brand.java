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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="brand",
		indexes = {	@Index(columnList = "name",name = "brands_index_name")})
@SequenceGenerator(name="genBrand", initialValue = 1)

public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genBrand")
	@Column (name = "idBrand",columnDefinition = "NUMERIC(4)")	
	private Integer id;
	@Column(name="name",length = 20, nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
	private List<Bike> bikes; //relacion de regreso
	
	public Brand(){ 
		bikes = new ArrayList<Bike>();
		
		
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

	public List<Bike> getBikes() {
		return bikes;
	}

	public void setBikes(List<Bike> bikes) {
		this.bikes = bikes;
	}

	
	

}
