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
		int z = 0;
		if(Start.gameIsRunning) {
			changeGameState(Start.tf.getText());
			if(z==0) {
				Start.ta.setText(Start.Player.getCurrent().getShortDescription());
				Start.ta.append("\nHP - "+Start.Player.getHP()+"\n"
						+"MAGIC - "+Start.Player.getMagic()+"\n"
						+"THIRST - "+Start.Player.getThirst());
				z++;
			}
			else {
				Start.ta.append("\n"+Start.Player.getCurrent().getShortDescription());
				Start.ta.append("\nHP - "+Start.Player.getHP()+"\n"
						+"MAGIC - "+Start.Player.getMagic()+"\n"
						+"THIRST - "+Start.Player.getThirst());
				z--;
			}
		}
	}
	
	private void changeGameState(String action) {
		Scanner sn1 = new Scanner(action);
		Start.Player.decideWhatToDo(sn1);
	}
}
