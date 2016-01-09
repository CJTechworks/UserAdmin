package mySpringWeb;

import java.net.URI;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.core.member.Customer;

public class DeleteCustomerTest {

	private RestTemplate restTemplate = new RestTemplate();
	private static final String BASE_URL = "http://localhost:8080/mySpringWeb/accounts/1";
	
	@Test
	public void deleteAccount() {
		// use a unique number to avoid conflicts
		String url = BASE_URL ;
		
		 restTemplate.delete(url);
				
		
	}
	
}
