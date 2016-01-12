package com.core.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer> {
   public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
      Customer customer = new Customer();
      customer.setCustomer_id(rs.getInt("customer_id"));
      customer.setName(rs.getString("name"));
      customer.setAddress1(rs.getString("address1"));
      customer.setAddress2(rs.getString("address2"));
      customer.setZip_code(rs.getString("zip_code"));
      customer.setCity(rs.getString("city"));
      customer.setCountry(rs.getString("country"));
      return customer;
   }
}