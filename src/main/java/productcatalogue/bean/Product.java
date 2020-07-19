package productcatalogue.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	public String id;
	public String name;
	public double size;
	public double weight;
	public String color;
	public String description;

	public Product() {

	}

	public Product(String id, String name, double size, double weight, String color, String description) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.weight = weight;
		this.color = color;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

}
