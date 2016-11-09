package com.example.javaee.rest.service;

import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.javaee.rest.application.RestApplicationPath;
import com.example.javaee.rest.controller.CountryController;
import com.example.javaee.rest.model.Country;

@Path(RestApplicationPath.COUNTRY)
@Stateless
public class CountryService {
	
	@EJB
	private CountryController countryController;
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response save(Country country) {
		countryController.save(country);
		URI uri = URI.create(RestApplicationPath.COUNTRY + "/" + country.getId());
		return Response.created(uri).entity(country).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Country> getAll() {
		return countryController.getAll(Country.class);
	}

	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Country getById(@PathParam("id") Integer id) {
		return countryController.getById(Country.class, id);
	}

}
