package com.labc.Vermellion.Classes.TextFieldStates;

import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.NPCs.Fairy;

public class FairyState extends TextFieldState{
private static FairyState instance = new FairyState();
	
	public static FairyState instance() {
		return instance;
	}
	
	@Override
	public void action() {
		Fairy fair = (Fairy) Start.Player.getCurrent().mob;
		String decision = Start.tf.getText();
		fair.makeDecision(decision);
	}
	
	
}
