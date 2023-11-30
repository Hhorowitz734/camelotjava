package com.actions;

public class SetNarration implements IAction {
    
    private String narrationText;

    /**
     * @param narrationText The text that will be used for narration.
     */
    public SetNarration(String narrationText) {
        this.narrationText = narrationText;
    }

    /**
     * @return SetNarration
     */
    @Override
    public String getName() {
        return "SetNarration";
    }

    /**
     * This action might not require waiting as it only changes the text and does not depend on user input or other actions.
     * @return false
     */
    @Override
    public boolean getShouldWait() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s(\"%s\")", getName(), narrationText);
    }
}