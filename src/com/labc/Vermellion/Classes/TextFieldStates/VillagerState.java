package com.labc.Vermellion.Classes.TextFieldStates;

import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.NPCs.Villager;

public class VillagerState extends TextFieldState{
	private static VillagerState instance = new VillagerState();
	
	public static VillagerState instance() {
		return instance;
	}
	
	@Override
	public void action() {
		String decision = Start.tf.getText();
		Villager vil = (Villager) Start.Player.getCurrent().mob;
		vil.makeDecision(decision);
	}
}
