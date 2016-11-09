package com.example.javaee.rest.test;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.junit.Test;

import com.example.javaee.rest.application.RestApplicationPath;
import com.example.javaee.rest.model.Country;
import com.example.javaee.rest.model.Person;
import com.example.javaee.rest.model.Phone;
import com.example.javaee.rest.model.PhoneType;
import com.example.javaee.rest.model.State;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;


public class PersonServiceTest {
	
	@Test
	public void mustSavePerson() {
		
		final Person p = new Person();
		p.setName("Leandro"); 
		p.setLastName("Bianchini");
		p.setSalary(100.0);
		
		RestAssured.baseURI = "http://localhost:8080/JavaEE-REST" + RestApplicationPath.PERSON;

		Response response = (Response) given().header("Accept", MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).body(p).post().then().extract().response();

		assertEquals(Status.CREATED.getStatusCode(), response.getStatusCode());

	}
	
	@Test	
	public void mustSavePersonWithPhone() {

		final Country country = new Country();
		country.setName("Brazil");
		country.setPhoneCode("+55");
		
		final State state = new State();
		state.setName("Rio de Janeiro");
		state.setPhoneCode("021");
		
		final PhoneType phoneType = new PhoneType();
		phoneType.setName("Mobile");

		final Phone phone = new Phone();
		phone.setCountry(country);
		phone.setState(state);
		phone.setPhoneType(phoneType);
		phone.setNumber("9999-9999");
		
		final List<Phone> listPhone = new ArrayList<Phone>();
		listPhone.add(phone);
		
		final Person p = new Person();
		p.setName("Person"); 
		p.setLastName("With Phone");
		p.setSalary(100.0);
		p.setPhones(listPhone);

		RestAssured.baseURI = "http://localhost:8080/JavaEE-REST" + RestApplicationPath.PERSON;

		Response response = (Response) given().header("Accept", MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).body(p).post().then().extract().response();

		assertEquals(Status.CREATED.getStatusCode(), response.getStatusCode());
		
	}


	@Test	
	public void mustSavePersonWithMoreThanOnePhone() {

		final Country country = new Country();
		country.setName("Brazil");
		country.setPhoneCode("+55");
		
		final State state = new State();
		state.setName("Rio de Janeiro");
		state.setPhoneCode("021");
		
		final PhoneType phoneType = new PhoneType();
		phoneType.setName("Mobile");

		final Phone phone1 = new Phone();
		phone1.setCountry(country);
		phone1.setState(state);
		phone1.setPhoneType(phoneType);
		phone1.setNumber("9999-9999");
		
		final Phone phone2 = new Phone();
		phone2.setCountry(country);
		phone2.setState(state);
		phone2.setPhoneType(phoneType);
		phone2.setNumber("9999-9999");

		final Phone phone3 = new Phone();
		phone3.setCountry(country);
		phone3.setState(state);
		phone3.setPhoneType(phoneType);
		phone3.setNumber("9999-9999");

		final List<Phone> listPhone = new ArrayList<Phone>();
		listPhone.add(phone1);
		listPhone.add(phone2);
		listPhone.add(phone3);
		
		final Person p = new Person();
		p.setName("Person"); 
		p.setLastName("With Phone");
		p.setSalary(100.0);
		p.setPhones(listPhone);

		RestAssured.baseURI = "http://localhost:8080/JavaEE-REST" + RestApplicationPath.PERSON;

		Response response = (Response) given().header("Accept", MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).body(p).post().then().extract().response();

		assertEquals(Status.CREATED.getStatusCode(), response.getStatusCode());
		
	}

	
	
}