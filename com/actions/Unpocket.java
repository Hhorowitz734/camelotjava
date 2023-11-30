package com.actions;

import com.entities.Character;
import com.entities.Item;

/**
 * Represents an action where a character takes an item out of their pocket or inventory.
 * @see com.entities.Character
 * @see com.entities.Item
 */
public class Unpocket implements IAction {
    private Character character;
    private Item item;

    /**
     * @param character The character who will perform the action.
     * @param item The item to be taken out of the pocket or inventory.
     */
    public Unpocket(Character character, Item item) {
        this.character = character;
        this.item = item;
    }

    /**
     * @return Unpocket
     */
    @Override
    public String getName() {
        return "Unpocket";
    }

    /**
     * This action might require the system to wait until the character completes the action.
     * @return true
     */
    @Override
    public boolean getShouldWait() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s(%s, %s)", getName(), character.getName(), item.getName());
    }
}
