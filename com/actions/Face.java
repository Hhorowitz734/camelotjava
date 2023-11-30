package com.actions;

import com.entities.Character;
import com.entities.IThing;

/**
 * Represents an action where a character turns to face a specific target.
 * The target could be a place, an object, or another character.
 * @see com.entities.Character
 * @see com.entities.IThing
 */
public class Face implements IAction {
    private Character character;
    private IThing<?> target;

    /**
     * @param character The character who will perform the action.
     * @param target The target the character will face.
     */
    public Face(Character character, IThing<?> target) {
        this.character = character;
        this.target = target;
    }

    /**
     * @return Face
     */
    @Override
    public String getName() {
        return "Face";
    }

    /**
     * This action likely does not require the system to wait, as facing a target is usually instantaneous.
     * @return false
     */
    @Override
    public boolean getShouldWait() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s(%s, %s)", getName(), character.getName(), target.getName());
    }
}
