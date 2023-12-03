package com.actions;

import com.entities.Character;
import com.entities.IEntity;
/**
 * Represents an action where a character draws an item.
 * This could be used for scenarios like drawing a weapon or a tool.
 * @see com.entities.Character
 * @see com.entities.Item
 */
public class CreateEffect implements IAction {
    private IEntity place;
    private String effect;

    /**
     * @param giver The character who hits
     * @param hits Whehter the attack hits
     */
    public CreateEffect(IEntity place, String effect) {
        this.place = place;
        this.effect = effect;
    }

    /**
     * @return CreateEffect
     */
    @Override
    public String getName() {
        return "CreateEffect";
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
        return String.format("%s(%s, %s)", place.getName(), effect);
    }
}
