package com.labc.Vermellion.Classes.TextFieldStates;

import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.NPCs.Goddess;

public class GoddessState extends TextFieldState {
	private static GoddessState instance = new GoddessState();
	
	public static GoddessState instance() {
		return instance;
	}
	
	@Override
	public void action() {
		String decision = Start.tf.getText();
		Goddess god = (Goddess) Start.Player.getCurrent().mob;
		god.makeDecision(decision);
	}

}
