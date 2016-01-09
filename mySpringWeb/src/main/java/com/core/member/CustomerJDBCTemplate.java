package com.core.member;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerJDBCTemplate implements CustomerDAO{

	private DataSource datasource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		this.datasource = ds;
		this.jdbcTemplate = new JdbcTemplate(datasource);
		
	}
	public Customer create(Customer customer) {
		 Integer customer_id = customer.getCustomer_id();
		String name = customer.getName();
		String address1 = customer.getAddress1();
		String address2 = customer.getAddress2();
		String zip_code = customer.getZip_code();
		String city = customer.getCity(); 
		String country = customer.getCountry();
		String SQL = "insert into customer(CUSTOMER_ID,NAME,ADDRESS1,ADDRESS2,ZIP_CODE,CITY,COUNTRY)  values (?,?, ?, ?, ?, ?, ?)";
	      
		 jdbcTemplate.update( SQL, customer_id, name, address1,address2,zip_code,city,country);
		 
	      System.out.println("Created Record Name = " + name + " Address1 = " + address1);
	      return  getCustomer(customer_id);
		
	}
	public Customer getCustomer(Integer customer_id) {
		
		String SQL = "select * from Customer where customer_id="+customer_id;
	      Customer customer = jdbcTemplate.queryForObject(SQL, new CustomerMapper());
	      return customer;
		
	}
	
	public void delete(Integer customer_id) {
		
		String SQL = "delete from Customer where customer_id="+customer_id;
	      jdbcTemplate.update(SQL);
		
	}
	public void update(Customer customer) {
		 Integer customer_id = customer.getCustomer_id();
		String name = customer.getName();
		String address1 = customer.getAddress1();
		String address2 = customer.getAddress2();
		String zip_code = customer.getZip_code();
		String city = customer.getCity(); 
		String country = customer.getCountry();
		String SQL = "update customer set CUSTOMER_ID = ?, NAME = ?, ADDRESS1 = ?,"
				+ "ADDRESS2 = ?, ZIP_CODE = ?, CITY = ?, COUNTRY = ? where customer_id="+customer_id;
				
	      
		 jdbcTemplate.update( SQL, customer_id, name, address1,address2,zip_code,city,country);
		 
	      System.out.println("Updated Record Name = " + name + " Address1 = " + address1);
	     
		
	}
		
	
	public List<Customer> listCustomers() {
		// TODO Auto-generated method stub
		String SQL = "select * from Customer";
	      List<Customer> customers = jdbcTemplate.query(SQL, new CustomerMapper());
	      return customers;
	}
	
	

}
