package com.actions;

import com.entities.Character;
import com.entities.Furniture;

/**
 * Represents an action where a character opens a piece of furniture.
 * @see com.entities.Character
 * @see com.entities.Furniture
 */
public class OpenFurniture implements IAction {
    private Character character;
    private Furniture furniture;

    /**
     * @param character The character who will perform the action of opening the furniture.
     * @param furniture The piece of furniture to be opened.
     */
    public OpenFurniture(Character character, Furniture furniture) {
        this.character = character;
        this.furniture = furniture;
    }

    /**
     * @return OpenFurniture
     */
    @Override
    public String getName() {
        return "OpenFurniture";
    }

    /**
     * This action might require the system to wait until the furniture is fully opened.
     * @return true
     */
    @Override
    public boolean getShouldWait() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s(%s, %s)", getName(), character.getName(), furniture.getName());
    }
}
