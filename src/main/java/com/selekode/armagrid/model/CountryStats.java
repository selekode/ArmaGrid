package com.selekode.armagrid.model;

public class CountryStats {
	private int countryId;
	private String section;
	private String stat_name;
	private String stat_value;
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getStat_name() {
		return stat_name;
	}
	public void setStat_name(String stat_name) {
		this.stat_name = stat_name;
	}
	public String getStat_value() {
		return stat_value;
	}
	public void setStat_value(String stat_value) {
		this.stat_value = stat_value;
	}
	
	public CountryStats(int countryId, String section, String stat_name, String stat_value) {
		super();
		this.countryId = countryId;
		this.section = section;
		this.stat_name = stat_name;
		this.stat_value = stat_value;
	}
}
