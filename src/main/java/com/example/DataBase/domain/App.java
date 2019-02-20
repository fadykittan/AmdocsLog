package com.example.DataBase.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity

public class App {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name, type;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "app")
	private List<DefectInstance> defects;

//--------------------------------------------------------constructors---------------------------------------------------------------------
	public App() {
	}

	public App(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

//---------------------------------------------------------getters and setters----------------------------------------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
