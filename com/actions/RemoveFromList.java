package com.actions;

import com.entities.Item;

/**
 * Represents an action where an item is removed from a list.
 * @see com.entities.Item
 */
public class RemoveFromList implements IAction {
    private Item item;

    /**
     * @param item The item to be removed from the list.
     */
    public RemoveFromList(Item item) {
        this.item = item;
    }

    /**
     * @return RemoveFromList
     */
    @Override
    public String getName() {
        return "RemoveFromList";
    }

    /**
     * This action likely does not require the system to wait, as it is a simple removal from a list.
     * @return false
     */
    @Override
    public boolean getShouldWait() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", getName(), item.getName());
    }
}
