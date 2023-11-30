package com.actions;

/**
 * Represents an action that triggers a fade-in effect.
 */
public class FadeIn implements IAction {

    /**
     * Constructor for FadeIn.
     */
    public FadeIn() {
        // Constructor logic, if any, goes here.
    }

    /**
     * @return FadeIn
     */
    @Override
    public String getName() {
        return "FadeIn";
    }

    /**
     * This action likely requires the system to wait until the fade-in effect is complete.
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
