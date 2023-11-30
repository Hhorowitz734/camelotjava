package com.actions;

import com.entities.IEntity;

/**
 * Represents an action where an entity is added to a list.
 * The entity can be added with or without an accompanying description.
 * @see com.entities.Entity
 */
public class AddToList implements IAction {
    private IEntity entity;
    private String description;

    /**
     * Constructor for adding an entity without a description.
     * @param entity The entity to be added to the list.
     */
    public AddToList(IEntity entity) {
        this(entity, ""); // Using an empty string for the default description
    }

    /**
     * Constructor for adding an entity with a description.
     * @param entity The entity to be added to the list.
     * @param description The description of the entity, if any.
     */
    public AddToList(IEntity entity, String description) {
        this.entity = entity;
        this.description = description;
    }

    /**
     * @return AddToList
     */
    @Override
    public String getName() {
        return "AddToList";
    }

    /**
     * This action likely does not require the system to wait, as it is a simple addition to a list.
     * @return false
     */
    @Override
    public boolean getShouldWait() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s(%s, \"%s\")", getName(), entity.getName(), description);
    }
}
