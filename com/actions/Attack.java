package com.actions;

import com.entities.Character;
/**
 * Represents an action where a character draws an item.
 * This could be used for scenarios like drawing a weapon or a tool.
 * @see com.entities.Character
 * @see com.entities.Item
 */
public class Attack implements IAction {
    private Character giver;
    private Character taker;
    private boolean hits;

    /**
     * @param giver The character who hits
     * @param taker The character who is hit
     * @param hits Whehter the attack hits
     */
    public Attack(Character giver, Character taker, boolean hits) {
        this.giver = giver;
        this.taker = taker;
        this.hits = hits;
    }

    /**
     * @return Attack
     */
    @Override
    public String getName() {
        return "Attack";
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
        return String.format("%s(%s, %s, %s)", getName(), giver.getName(), taker.getName(), hits);
    }
}
