package mySpringWeb;

import java.net.URI;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.core.member.Customer;

public class CreateCustomerTest {

	private RestTemplate restTemplate = new RestTemplate();
	private static final String BASE_URL = "http://localhost:8080/mySpringWeb/accounts";
	
	@Test
	public void createCustomer() {
		// use a unique number to avoid conflicts
		String url = BASE_URL ;
		Customer customer = new Customer(7,"Advik","abc","abc","abc","abc","abc");
		
		
		URI newAccountLocation = restTemplate.postForLocation(url, customer);
		//	TODO 08: Create a new Account by POSTing to the right URL and store its location in a variable

		//	TODO 09: Retrieve the Account you just created from the location that was returned.
		//	Run this test.  Whether it passes or not, proceed with the next step.
		System.out.println(newAccountLocation);
		Customer customerNew = restTemplate.getForObject(newAccountLocation,Customer.class);
		Assert.assertEquals("Advik", customerNew.getName());
	}
	
}
