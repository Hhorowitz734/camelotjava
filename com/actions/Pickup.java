package com.actions;

import com.entities.Character;
import com.entities.Furniture;
import com.entities.Item;

/**
 * Represents an action where a character picks up an item, optionally from a specific location.
 * @see com.entities.Character
 * @see com.entities.Item
 * @see com.entities.Place
 */
public class Pickup implements IAction {
    private Character character;
    private Item item;
    private Furniture location; // This can be null if location is not specified.

    /**
     * Constructor for picking up an item without specifying a location.
     * @param character The character who will perform the action.
     * @param item The item to be picked up.
     */
    public Pickup(Character character, Item item) {
        this(character, item, null); // Delegate to the main constructor
    }

    /**
     * Constructor for picking up an item from a specific location.
     * @param character The character who will perform the action.
     * @param item The item to be picked up.
     * @param location The location from where the item is picked up.
     */
    public Pickup(Character character, Item item, Furniture location) {
        this.character = character;
        this.item = item;
        this.location = location;
    }

    /**
     * @return Pickup
     */
    @Override
    public String getName() {
        return "Pickup";
    }

    /**
     * This action might require the system to wait until the character completes picking up the item.
     * @return true
     */
    @Override
    public boolean getShouldWait() {
        return true;
    }

    @Override
    public String toString() {
        if (location != null) {
            return String.format("%s(%s, %s, %s)", getName(), character.getName(), item.getName(), location.getName());
        } else {
            return String.format("%s(%s, %s)", getName(), character.getName(), item.getName());
        }
    }
}
