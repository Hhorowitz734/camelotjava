package com.actions;

/**
 * Represents an action that triggers a fade-out effect.
 */
public class FadeOut implements IAction {

    /**
     * Constructor for FadeOut.
     */
    public FadeOut() {
        // Constructor logic, if any, goes here.
    }

    /**
     * @return FadeOut
     */
    @Override
    public String getName() {
        return "FadeOut";
    }

    /**
     * This action likely requires the system to wait until the fade-out effect is complete.
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
