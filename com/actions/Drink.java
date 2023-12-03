package com.actions;

import com.entities.Character;

/**
 * Represents an action where a character takes an item out of their pocket or inventory.
 * @see com.entities.Character
 * @see com.entities.Item
 */
public class Drink implements IAction {
    private Character character;

    /**
     * @param character The character who will perform the action.
     * @param item The item to be taken out of the pocket or inventory.
     */
    public Drink(Character character) {
        this.character = character;
    }

    /**
     * @return Drink
     */
    @Override
    public String getName() {
        return "Drink";
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
        return String.format("%s(%s)", getName(), character.getName());
    }
}
