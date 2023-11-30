package com.actions;

import com.entities.Character;
import com.entities.IEntity;

/**
 * Represents an action where a character walks to a specific destination.
 * The destination could be another character or a place.
 * @see com.entities.Character
 * @see com.entities.IEntity
 */
public class WalkTo implements IAction {
    private Character character;
    private IEntity destination;

    /**
     * @param character The character who will perform the action.
     * @param destination The target destination the character will walk to.
     */
    public WalkTo(Character character, IEntity destination) {
        this.character = character;
        this.destination = destination;
    }

    /**
     * @return WalkTo
     */
    @Override
    public String getName() {
        return "WalkTo";
    }

    /**
     * This action likely requires the system to wait until the character reaches the destination.
     * @return true
     */
    @Override
    public boolean getShouldWait() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s(%s, %s)", getName(), character.getName(), destination.getName());
    }
}
