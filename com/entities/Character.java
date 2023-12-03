
package com.entities;

public class Character implements IEntity, IThing<Character.BodyType> {
	private String name;
	private BodyType bodyType;
	private Clothing clothing;
	private Hairstyles hairStyle;

	public enum BodyType { A, B, C, D, E, F, G, H }
	public enum Clothing { Bandit, Beggar, LightArmour, HeavyArmour, Merchant, Noble, Peasant, Priest }
	public enum Hairstyles { Long, Spiky, Short }

    //Constructors
	public Character(String name) { this(name, BodyType.D, Clothing.LightArmour, Hairstyles.Spiky); }
	public Character(String name, BodyType bodyType) { this(name, bodyType, Clothing.Noble, Hairstyles.Long); }
	public Character(String name, BodyType bodyType, Clothing clothing) { this(name, bodyType, clothing, Hairstyles.Long); }
	public Character(String name, BodyType bodyType, Clothing clothing, Hairstyles hairStyle) {
		this.name = name;
		this.bodyType = bodyType;
		this.clothing = clothing;
		this.hairStyle = hairStyle;
	}

    //Getter methods
	public Clothing getClothing() { return clothing; }
	public Hairstyles getHairStyle() { return hairStyle; }

    //IThing Extenders
	@Override
	public BodyType getTemplate() { return bodyType; }
	@Override
	public String getName() { return name; }
}





