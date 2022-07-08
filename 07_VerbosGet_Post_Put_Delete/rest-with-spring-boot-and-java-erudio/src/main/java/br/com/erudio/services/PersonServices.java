package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;
@Service
public class PersonServices {
	
	private final AtomicLong couter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		logger.info("Finding All person!");
		return persons ;
	}
	
	public Person findById(String id) {
		logger.info("Finding one person!");
		Person person = new Person();
		person.setId(couter.incrementAndGet());
		person.setFirstName("Gabriel");
		person.setLastName("Alves");
		person.setAddress("Ceilandia - Distrito Federal");
		person.setGender("Male");
		return person;
	}
	
	public Person create(Person person) {
		
		logger.info("create one person!");
		
		return person;
		
	}
	
	public Person update(Person person) {
		
		logger.info("update one person!");
		
		return person;
		
	}
	
public void delete(String id) {
		
		logger.info("delete one person!");
		
		
	}
	
	private Person mockPerson(int i) {
		
		Person person = new Person();
		person.setId(couter.incrementAndGet());
		person.setFirstName("Person name "+ i);
		person.setLastName("Last name "+ i);
		person.setAddress("Address Brasil" + i);
		person.setGender("Male" + i);
		return person;
	}

}
