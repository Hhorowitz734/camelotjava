package com.actions;

import com.entities.IEntity;



/**
 * Represents an action to set the position of an entity (character or item)
 * in a specific location, which could be another entity, a place, furniture, or a specific position.
 */
public class SetPosition implements IAction {
    private IEntity entity;
    private Object targetPosition; // Can be Entity, Place, Furniture, or specific position

    /**
     * Constructor for setting the position of an entity. If targetPosition is null, the entity disappears but still exists.
     * @param entity The entity (character or item) whose position is to be set.
     * @param targetPosition The target position (Entity, Place, Furniture, or specific point) where the entity's position is to be set.
     */
    public SetPosition(IEntity entity, Object targetPosition) {
        this.entity = entity;
        this.targetPosition = targetPosition;
    }

    /**
     * @return SetPosition
     */
    @Override
    public String getName() {
        return "SetPosition";
    }

    /**
     * This action might require the system to wait until the entity is positioned.
     * @return true
     */
    @Override
    public boolean getShouldWait() {
        return true; // Assuming positioning might take time.
    }

    @Override
    public String toString() {
        String targetPosDescription = (targetPosition != null) ? targetPosition.toString() : "null";
        return String.format("%s(%s, %s)", getName(), entity.getName(), targetPosDescription);
    }
}
