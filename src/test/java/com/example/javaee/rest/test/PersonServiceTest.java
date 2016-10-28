package com.example.javaee.rest.test;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.junit.Test;

import com.example.javaee.rest.model.Person;
import com.jayway.restassured.response.Response;


public class PersonServiceTest {
	
	@Test
	public void mustSavePerson() {
		
		final Person p = new Person();
		p.setName("Leandro"); 
		p.setLastName("Bianchini");
		p.setSalary(100.0);

		Response response = (Response) given().header("Accept", MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).body(p).post().then().extract().response();

		assertEquals(Status.OK.getStatusCode(), response.getStatusCode());

	}


}