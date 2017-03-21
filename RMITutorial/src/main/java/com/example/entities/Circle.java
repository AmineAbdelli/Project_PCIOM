package com.example.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_circle", discriminatorType = DiscriminatorType.STRING, length = 1)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(name = "B", value = BackBone.class), @Type(name = "N", value = Node.class),
		@Type(name = "I", value = InterestZone.class) })
public abstract class Circle implements Serializable {
	//{"ID":"500" ,""centre":"2","rayon":"3","batteryLevel":"30" ,"roles":"5", "mobility":"0"}
	@Id
	private String email;
	private double Latitude ;
	private double Longitude;
	private double rayon;
	

	public Circle(String email, double Latitude, double Longitude,double rayon) {
		super();
		this.email = email;
		this.Latitude = Latitude;
		this.Longitude = Longitude;
		this.rayon = rayon;
	}

	public Circle() {
		super();
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getLatitude() {
		return Latitude;
	}

	public void setLatitude(double latitude) {
		Latitude = latitude;
	}

	public double getLongitude() {
		return Longitude;
	}

	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}


}
