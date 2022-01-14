package io.javabrains.moviecatalogservice.model;

public class CatalogItem {

	private String name;
	private String description;
	private int raiting;
	
	
	
	public CatalogItem(String name, String description, int raiting) {
		super();
		this.name = name;
		this.description = description;
		this.raiting = raiting;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRaiting() {
		return raiting;
	}
	public void setRaiting(int raiting) {
		this.raiting = raiting;
	}
	
	
}
