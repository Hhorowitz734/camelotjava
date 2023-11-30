package com.actions;

/**
 * Shows the currently set narration text on screen.
 * This action is responsible for displaying the narration text to the player.
 * The experience manager handles the visibility and timing of the narration display.
 */
public class ShowNarration implements IAction {

    /**
     * Constructor for ShowNarration.
     */
    public ShowNarration() {
        // Constructor logic (if any) goes here.
    }

    /**
     * @return ShowNarration
     */
    @Override
    public String getName() {
        return "ShowNarration";
    }

    /**
     * This action might need to wait until the narration is fully displayed.
     * @return true
     */
    @Override
    public boolean getShouldWait() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + "()";
    }
}
