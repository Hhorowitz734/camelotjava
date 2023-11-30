package com.actions;


public class DisableInput implements IAction{
	

    boolean disable;

	public DisableInput() {
		this.disable=false;
	}

	@Override
	public String getName() {
		return disable ? "EnableInput":"DisableInput";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s()", getName());
	}
}
