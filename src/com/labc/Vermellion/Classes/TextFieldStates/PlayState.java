package com.labc.Vermellion.Classes.TextFieldStates;

import java.util.Scanner;

import com.labc.Vermellion.Start;

public class PlayState extends TextFieldState{
	private static PlayState instance = new PlayState();
	
	public static PlayState instance() {
		return instance;
	}
	
	@Override
	public void action() {
		play();
	}
	
	private void play() {
		
		if(Start.gameIsRunning) {
			Start.ta.setText("");
			changeGameState(Start.tf.getText());
			Start.Stats.setText("HP - "+(int)Start.Player.getHP()+"   "
					+"MAGIC - "+Start.Player.getMagic()+"   "
					+"THIRST - "+Start.Player.getThirst());
		}
	}
	
	private void changeGameState(String action) {
		Scanner sn1 = new Scanner(action);
		Start.Player.decideWhatToDo(sn1);
	}
}
