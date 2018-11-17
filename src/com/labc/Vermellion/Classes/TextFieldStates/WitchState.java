package com.labc.Vermellion.Classes.TextFieldStates;

import com.labc.Vermellion.SoundFX;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.Enemies.Witch;

public class WitchState extends TextFieldState {
	private static WitchState instance = new WitchState();
		
		public static WitchState instance() {
			return instance;
		}
		
		@Override
		public void action() {
			String decision = Start.tf.getText();
			Witch witch = (Witch) Start.Player.getCurrent().mob;
			witch.makeDecision(decision);
			SoundFX.WITCH.play(0.40);
		}
}
