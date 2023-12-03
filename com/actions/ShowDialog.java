package com.actions;

/**
 * Represents an action that triggers a reset of the game or application state.
 */
public class ShowDialog implements IAction {

    /**
     * Constructor for ShowDialog.
     */
    public ShowDialog() {
        // Constructor logic, if any, goes here.
    }

    /**
     * @return ShowDialog
     */
    @Override
    public String getName() {
        return "ShowDialog";
    }

    /**
     * Depending on the context, this action might require the system to wait until the reset process is complete.
     * @return true or false based on context
     */
    @Override
    public boolean getShouldWait() {
        // Implement logic to determine if the action should wait or not.
        return true; // Placeholder return value.
    }

    @Override
    public String toString() {
        return getName() + "()";
    }
}
