package mySpringWeb;

import java.net.URI;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.core.member.Customer;

public class UpdateCustomerTest {

	private RestTemplate restTemplate = new RestTemplate();
	private static final String BASE_URL = "http://localhost:8080/mySpringWeb/accounts/7";
	
	@Test
	public void createCustomer() {
		// use a unique number to avoid conflicts
		String url = BASE_URL ;
		Customer customer = new Customer(7,"Advik Vijay","abc","abc","abc","abc","abc");
		
		
		 restTemplate.put(url,customer);
		Customer updatedCustomer = restTemplate.getForObject(url, Customer.class);
		Assert.assertEquals("Advik Vijay", updatedCustomer.getName());
	}
	
}
