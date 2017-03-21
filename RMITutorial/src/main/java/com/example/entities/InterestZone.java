package com.example.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("I")
public class InterestZone extends Circle {

	public InterestZone(String email, double firstName, double lastName,double rayon) {
		super(email, firstName, lastName, rayon);
		// TODO Auto-generated constructor stub
	}

	public InterestZone() {
		super();
	}
}
