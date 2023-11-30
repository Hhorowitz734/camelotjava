package com.actions;

import com.entities.Character;
import com.entities.Item;

/**
 * Represents an action where a character puts an item into their pocket or inventory.
 * @see com.entities.Character
 * @see com.entities.Item
 */
public class Pocket implements IAction {
    private Character character;
    private Item item;

    /**
     * @param character The character who will perform the action.
     * @param item The item to be put into the pocket or inventory.
     */
    public Pocket(Character character, Item item) {
        this.character = character;
        this.item = item;
    }

    /**
     * @return Pocket
     */
    @Override
    public String getName() {
        return "Pocket";
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
