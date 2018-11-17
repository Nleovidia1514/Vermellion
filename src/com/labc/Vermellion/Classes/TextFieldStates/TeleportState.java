package com.labc.Vermellion.Classes.TextFieldStates;

import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.NPCs.Fairy;

public class TeleportState extends TextFieldState {
	private static TeleportState instance = new TeleportState();
		
		public static TeleportState instance() {
			return instance;
		}
		
		@Override
		public void action() {
			Fairy fair = (Fairy) Start.Player.getCurrent().mob;
			String decision = Start.tf.getText();
			fair.teleport(decision);
		}
	
	
}
