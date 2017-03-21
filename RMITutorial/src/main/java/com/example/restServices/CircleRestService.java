package com.example.restServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Circle;

import com.example.metier.CircleMetier;


@RestController
public class CircleRestService {
	
	@Autowired
	private CircleMetier personneMetier;

	@RequestMapping(value = "/circles", method = RequestMethod.POST)
	public Circle savePersonne(@RequestBody Circle personne) {
		return personneMetier.saveCircle(personne);
	}

	@RequestMapping(value = "/circles", method = RequestMethod.GET)
	public List<Circle> personnes() {
		return personneMetier.circles();
	}
	@RequestMapping(value = "/circles/{email}", method = RequestMethod.GET)
	public Circle personne(@PathVariable String email) {
		 return personneMetier.circle(email);
	}

}
