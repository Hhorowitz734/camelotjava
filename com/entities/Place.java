package com.entities;
public class Place implements IThing<Place.Places> {

    //Template enum
    public enum Places {
		AlchemyShop, Blacksmith, Bridge, Camp, CastleBedroom, CastleCrossroads, City, Cottage, Courtyard, DiningRoom,
		Dungeon, Farm, ForestPath, GreatHall, Hallway, Library, Port, Ruins, SpookyPath, Storage, Tavern
	}

    //Private members
	private String name;
	private Places template;

    //Constructors
	public Place(String name, Places template) {
		this.name = name;
		this.template = template;
	}


	public Furniture getFurniture(String fname) {
        //ASK ABOUT THIS

		String m = this.name + "." + fname;
		Furniture furniture = new Furniture(m);
		return furniture;
	}

    //IThing Functions
	@Override
	public String getName() { return name; }
	@Override
	public Places getTemplate() { return template; }
}
