package com.actions;

/**
 * Hides the currently displayed narration text from the screen.
 * This action is responsible for making the narration text invisible to the player.
 */
public class HideDialog implements IAction {

    /**
     * Constructor for HideDialog.
     */
    public HideDialog() {
        // Constructor logic (if any) goes here.
    }

    /**
     * @return HideDialog
     */
    @Override
    public String getName() {
        return "HideDialog";
    }

    /**
     * This action might not require waiting as it only changes the visibility of the text.
     * @return false
     */
    @Override
    public boolean getShouldWait() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + "()";
    }
}
