package com.labc.Vermellion.Classes.TextFieldStates;

import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.NPCs.SkullKid;

public class SariasSongState extends TextFieldState{
	private static SariasSongState instance = new SariasSongState();
	
	public static SariasSongState instance() {
		return instance;
	}
	
	@Override
	public void action() {
		SkullKid sk = (SkullKid) Start.Player.getCurrent().mob;
		String song = Start.tf.getText();
		sk.playSong(song);
	}

}
