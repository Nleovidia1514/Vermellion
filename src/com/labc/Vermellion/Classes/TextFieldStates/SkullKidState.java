package com.labc.Vermellion.Classes.TextFieldStates;

import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.NPCs.SkullKid;

public class SkullKidState extends TextFieldState {
	private static SkullKidState instance = new SkullKidState();
	
	public static SkullKidState instance() {
		return instance;
	}
	
	@Override
	public void action() {
		SkullKid kd = (SkullKid) Start.Player.getCurrent().mob;
		String decision = Start.tf.getText();
		kd.makeDecision(decision);
	}

	
}
