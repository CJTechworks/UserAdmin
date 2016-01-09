package com.core.member;


import java.net.URI;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	public CustomerJDBCTemplate customer;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/accounts",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Customer> accountSummary() {
		return customer.listCustomers();
	}
	
	@RequestMapping(value = "/accounts", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public HttpEntity<String> createAccount(@RequestBody Customer newCustomer,
			@Value("#{request.requestURL}") StringBuffer url) {
		 Customer cust =customer.create(newCustomer);

		return entityWithLocation(url, cust.getCustomer_id());
	
		//	TODO 07: Set the Location header on the Response to the location of the created account.
		//	Note the existing entityWithLocation method below.
	}

	
	@RequestMapping(value="/accounts/{custID}",method=RequestMethod.GET)
	public  @ResponseBody Customer customerDetails(@PathVariable("custID") int id) {
		return customer.getCustomer(id);
	}
	
	private HttpEntity<String> entityWithLocation(StringBuffer url,
			Object resourceId) {
		// Configure and return an HttpEntity object - it will be used to build
		// the HttpServletResponse
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(getLocationForChildResource(url, resourceId));
		return new HttpEntity<String>(headers);
	}
	
	
	private URI getLocationForChildResource(StringBuffer url,
			Object childIdentifier) {
		UriTemplate template = new UriTemplate(url.append("/{childId}")
				.toString());
		return template.expand(childIdentifier);
	}
	
	@RequestMapping(value="/accounts/{custID}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeCustomer(@PathVariable("custID") int id) {
		customer.delete(id);
	}
	
	@RequestMapping(value="/accounts/{custID}",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCustomer(@RequestBody Customer updatedCustomer) {
		customer.update(updatedCustomer);
	}
	
	
	
	
}
