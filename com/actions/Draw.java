package com.actions;

import com.entities.Character;
import com.entities.Item;

/**
 * Represents an action where a character draws an item.
 * This could be used for scenarios like drawing a weapon or a tool.
 * @see com.entities.Character
 * @see com.entities.Item
 */
public class Draw implements IAction {
    private Character character;
    private Item item;

    /**
     * @param character The character who will draw the item.
     * @param item The item to be drawn by the character.
     */
    public Draw(Character character, Item item) {
        this.character = character;
        this.item = item;
    }

    /**
     * @return Draw
     */
    @Override
    public String getName() {
        return "Draw";
    }

    /**
     * Whether or not to wait for this action to complete could depend on the context.
     * @return true or false based on context
     */
    @Override
    public boolean getShouldWait() {
        // Implement logic to determine if the action should wait or not.
        return true; // Placeholder return value.
    }

    @Override
    public String toString() {
        return String.format("%s(%s, %s)", getName(), character.getName(), item.getName());
    }
}
