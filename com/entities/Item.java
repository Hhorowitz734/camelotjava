package com.entities;

public class Item implements IEntity, IThing<Item.Items> {

    //Enum of Camelot Items
    public enum Items {
		Apple, Bag, BlueBook, BlueCloth, BlueKey, BluePotion, Bottle, Bread, ChickenLeg, Coin, Compass, Cup, EvilBook,
		GoldCup, GreenBook, GreenKey, GreenPotion, Hammer, Helmet, InkandQuill, JewelKey, LitTorch, Lock,
		MagnifyingGlass, OpenScroll, PurpleBook, PurpleCloth, PurpleKey, PurplePotion, Rags, RedBook, RedCloth, RedKey,
		RedPotion, Skull, Scroll, SpellBook, Sword, Torch, Woodpile
	}

    //Private Members
	private String name;
	private Items template;
	
    //Constructors
	public Item(String name, Items template) {
		this.name = name;
		this.template = template;
	}

    //Functions for IThing interface
	@Override
	public Items getTemplate() { return template; }
	@Override
	public String getName() { return name; }
}
