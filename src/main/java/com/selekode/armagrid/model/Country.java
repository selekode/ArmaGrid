package com.selekode.armagrid.model;

public class Country {
	private int id;
	private String shortName;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Country(int id, String shortName, String name) {
		super();
		this.id = id;
		this.shortName = shortName;
		this.name = name;
	}
}
