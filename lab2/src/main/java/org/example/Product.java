package org.example;

public class Product {
	private long id;
	private String name;
	private Double price;
	public Product(){
		this.id = 0;
		this.name = null;
		this.price = 0.0;
	}
	public Product(int id,String name,Double price){
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", price=" + price +
				'}';
	}
}
