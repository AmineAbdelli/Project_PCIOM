package com.example.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CircleRepository;

import com.example.entities.Circle;
@Service
public class CircleMetierImpl implements CircleMetier{
	@Autowired
	private CircleRepository personneRepository;
	//@Autowired
	//private VehiculeRepository vehiculeRepository;
	@Override
	public Circle saveCircle(Circle personne) {
		//ParckSingleton.getInstance(   vehiculeRepository,personneRepository).savePersonne(personne);
		return personneRepository.save(personne);
	}

	@Override
	public List<Circle> circles() {
		// TODO Auto-generated method stub
		return personneRepository.findAll();
	}

	@Override
	public Circle circle(String email) {
		return personneRepository.findOne(email);
	}

}
