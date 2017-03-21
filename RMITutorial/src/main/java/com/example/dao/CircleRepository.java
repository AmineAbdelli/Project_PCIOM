package com.example.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Circle;

public interface CircleRepository extends JpaRepository<Circle, String>{

}
