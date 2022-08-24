package com.vaya.bestpractice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.vaya.bestpractice.data.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("test")
public class StudentControllerTests {
	
	@LocalServerPort
    private int port;
	
	URL base;
	
	@BeforeAll
	public void setUp() {
		try {
			base = new URL("http://localhost/demo");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} 
	}

//    TestRestTemplate restTemplate = new TestRestTemplate();
	
	TestRestTemplate restTemplate = new TestRestTemplate("user", "password");

    HttpHeaders headers = new HttpHeaders();
    @Test
    @Disabled
    public void testCreateStudent() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/students"), HttpMethod.POST, entity, String.class);

        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

        assertTrue(actual.contains("/students"));
    }  
    
    @Test
    public void testRetrieveStudent() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<User[]> response = restTemplate.exchange( createURLWithPort("/get-user"), HttpMethod.GET, entity, User[].class);

//        String expected = "{\"id\":1,\"name\":\"Rajesh Bhojwani\",\"description\":\"Class 10\"}";
        
        String expected = "25";
        String actual = response.getBody()[0].getAge()+"";

        JSONAssert.assertEquals(expected, actual, true);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
