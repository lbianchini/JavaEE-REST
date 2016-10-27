package com.example.javaee.rest.dao.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.javaee.rest.dao.PersonDao;
import com.example.javaee.rest.model.Person;

@RunWith(Arquillian.class)
public class PersonDaoTest {

	@Inject
	private PersonDao personDao;
	
	
	@Deployment
	public static Archive<?> createDeployFile() {
		Archive<?> arquivoTeste = ShrinkWrap.create(WebArchive.class)
				.addPackage(PersonDao.class.getPackage())
				.addClass(Person.class).addAsResource("META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
		return arquivoTeste;
	}
	
	@Test
	public void mustSavePerson() {
		Person p = new Person();
		p.setName("Leandro");
		p.setLastName("Bianchini");
		p.setSalary(100.0);
		
		personDao.save(p);
		
		Assert.assertEquals("Leandro", p.getName());
		
	}

}
