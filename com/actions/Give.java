package com.actions;

import com.entities.Character;
import com.entities.Item;

/**
 * Represents an action where one character gives an item to another character.
 * @see com.entities.Character
 * @see com.entities.Item
 */
public class Give implements IAction {
    private Character giver;
    private Item item;
    private Character receiver;

    /**
     * @param giver The character who is giving the item.
     * @param item The item to be given.
     * @param receiver The character who will receive the item.
     */
    public Give(Character giver, Item item, Character receiver) {
        this.giver = giver;
        this.item = item;
        this.receiver = receiver;
    }

    /**
     * @return Give
     */
    @Override
    public String getName() {
        return "Give";
    }

    /**
     * This action might require the system to wait until the transfer of the item is complete.
     * @return true
     */
    @Override
    public boolean getShouldWait() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s(%s, %s, %s)", getName(), giver.getName(), item.getName(), receiver.getName());
    }
}
