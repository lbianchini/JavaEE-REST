package com.example.javaee.rest.tests;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.PomEquippedResolveStage;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.javaee.rest.model.Person;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

@RunWith(Arquillian.class)
public class PersonServiceTest {
	
	@Deployment
	public static Archive<?> createDeploy() {

		WebArchive warDeploy = ShrinkWrap.create(WebArchive.class, "JavaEE-REST.war")
				.addPackages(true, "com.example.javaee.rest")
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
		
		PomEquippedResolveStage mavenResolver = Maven.resolver().loadPomFromFile("pom.xml");
		File[] libsRestAssured = mavenResolver.resolve("com.jayway.restassured:rest-assured").withTransitivity().asFile();		
		
		warDeploy.addAsLibraries(libsRestAssured);
		
		System.out.println(warDeploy.toString(true));
		return warDeploy;
	}
	
	@Test
	public void mustAddPerson() {
		RestAssured.baseURI = "http://localhost:8080/JavaEE-REST/persons";
		Person person = new Person();
		person.setName("Leandro");
		person.setLastName("Bianchini");
		person.setSalary(100.00);
		
		Response response = (Response) given().header("Accept", MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).body(person).post().then().extract().response();

		assertEquals(Status.CREATED.getStatusCode(), response.getStatusCode());
		
//		Person personTestReturn = response.body().as(Person.class);
//
//		assertEquals(RestAssured.baseURI + "/" + personTestReturn.getId(), response.getHeader("location"));
//		assertEquals(person.getName(), personTestReturn.getName());
	}

}
