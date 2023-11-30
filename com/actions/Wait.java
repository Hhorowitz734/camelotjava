package com.actions;

/**
 * Implements a wait or delay in the game or application.
 * This action causes the system to wait for a specified duration before proceeding.
 */
public class Wait implements IAction {
    private double duration;

    /**
     * @param duration The duration of the wait in seconds.
     */
    public Wait(double duration) {
        this.duration = duration;
    }

    /**
     * @return Wait
     */
    @Override
    public String getName() {
        return "Wait";
    }

    /**
     * This action requires the system to wait, so it should always return true.
     * @return true
     */
    @Override
    public boolean getShouldWait() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s(%.1f)", getName(), duration);
    }
}
