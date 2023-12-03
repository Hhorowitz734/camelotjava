package com.actions;

/**
 * Represents an action that triggers a reset of the game or application state.
 */
public class SetDialog implements IAction {

    private String dialog;

    /**
     * Constructor for SetDialog.
     */
    public SetDialog(String dialog) {
        this.dialog = dialog;
    }

    /**
     * @return SetDialog
     */
    @Override
    public String getName() {
        return "SetDialog";
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
        return String.format("%s(\"%s\")", getName(), dialog);
    }
}
