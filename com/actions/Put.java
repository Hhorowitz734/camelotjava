package com.actions;

import com.entities.Character;
import com.entities.Item;
import com.entities.Furniture;

/**
 * Represents an action where one character gives an item to another character.
 * @see com.entities.Character
 * @see com.entities.Item
 */
public class Put implements IAction {
    private Character giver;
    private Item item;
    private Furniture receiver;

    /**
     * @param giver The character who is giving the item.
     * @param item The item to be given.
     * @param receiver The character who will receive the item.
     */
    public Put(Character giver, Item item, Furniture receiver) {
        this.giver = giver;
        this.item = item;
        this.receiver = receiver;
    }

    /**
     * @return Put
     */
    @Override
    public String getName() {
        return "Put";
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
