package com.example.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("N")
public class Node extends Circle{
	private double batteryLevel;
	private int roles;
	private int mobility;
	
	
	public Node(String email, double firstName,double rayon, double lastName, double batteryLevel, int roles, int mobility) {
		super(email, firstName, lastName, rayon);
		this.batteryLevel = batteryLevel;
		this.roles = roles;
		this.mobility = mobility;
	}
	public Node(String email, double firstName ,double lastName ,double rayon) {
		super(email, firstName, lastName, rayon);
		// TODO Auto-generated constructor stub
	}
	public Node() {
		super();
	}
	public double getBatteryLevel() {
		return batteryLevel;
	}
	public void setBatteryLevel(double batteryLevel) {
		this.batteryLevel = batteryLevel;
	}
	public int getRoles() {
		return roles;
	}
	public void setRoles(int roles) {
		this.roles = roles;
	}
	public int getMobility() {
		return mobility;
	}
	public void setMobility(int mobility) {
		this.mobility = mobility;
	}

}
