package com.example.metier;

import java.util.List;

import com.example.entities.Circle;

public interface CircleMetier {
public Circle saveCircle(Circle personne);
public List<Circle> circles();
public Circle circle(String email);
}
