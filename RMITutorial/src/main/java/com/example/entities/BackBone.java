package com.example.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class BackBone extends Circle {

	public BackBone(String email, double firstName, double lastName,double rayon) {
		super(email, firstName, lastName, rayon);
		// TODO Auto-generated constructor stub
	}

	public BackBone() {
		super();
	}
}
