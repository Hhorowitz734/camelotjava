package com.entities;

public class Furniture implements IEntity {

    //Private members
	private String name;

    //Constructors
	Furniture(String name) {
		this.name = name;
	}

    //IEntity functions
	@Override
	public String getName() { return name; }

	public String toString(){
		return getName();
	}
}
