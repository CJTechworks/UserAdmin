package com.core.member;

public class Customer {

	private int customer_id;
	private String name;
	private String address1;
	private String address2;
	private String zip_code;
	private String city;
	
	public Customer(){
		
	}
	
	public Customer(int customer_id, String name, String address1,
			String address2, String zip_code, String city, String country) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.zip_code = zip_code;
		this.city = city;
		this.country = country;
	}
	private String country;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
