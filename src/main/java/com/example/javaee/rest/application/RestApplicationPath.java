package com.example.javaee.rest.application;

import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("")
public class RestApplicationPath extends Application {
	
	public final static String PERSON = "persons";
	
}