package com.example.javaee.rest.service;

import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.javaee.rest.application.RestApplicationPath;
import com.example.javaee.rest.controller.PersonController;

import com.example.javaee.rest.model.Person;

@Path(RestApplicationPath.PERSON)
@Stateless
public class PersonService {
		
	@EJB
	private PersonController personController;
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response save(Person person) {
		
		personController.save(person);
		URI uri = URI.create(RestApplicationPath.PERSON + "/" + person.getId());
		return Response.created(uri).entity(person).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Person> getPersonList() {
		return personController.getPersonList();
	}

}
