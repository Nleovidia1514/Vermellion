package com.labc.Vermellion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import com.labc.Vermellion.Classes.TextFieldStates.ChooseClassState;
import com.labc.Vermellion.Classes.TextFieldStates.TextFieldState;

import javax.sound.sampled.Clip;
import javax.swing.*;

public class Start {
	public static Tile starting;
	private SingletonMap map;
	public static Random rnd = new Random();
	public static String clase = "";
	public static SoundFX background = SoundFX.BACKGROUND; 
	public static SoundFX battle = SoundFX.BATTLE;
	public static Character Player;
	public static boolean gameIsRunning;
	public static JFrame frame;
	public static JLabel pic;
	public static JTextField tf;
	public static TextFieldState tfState;
	public static JTextArea Stats, ta, TileTitle;
	
	public Start() throws IOException {
		pic.setIcon(Descriptions.ChooseClass);
		Start.gameIsRunning = true;
		Start.tfState = ChooseClassState.instance();
		innitGui();
		map = SingletonMap.getInstance();
		//this.Player = Singleton.getInstance(starting, clase);
		int RndX = rnd.nextInt(SingletonMap.MapSize), RndY = 0;
		Start.starting = map.getTile(RndX, RndY);
		int z=0;
		while(!starting.getName().equals("forest") && !starting.getName().equals("lake")) {
			if(z==SingletonMap.MapSize-1) {
				z=0;
				RndY++;
			}
			else {
				z++;
				Start.starting = map.getTile(rnd.nextInt(SingletonMap.MapSize), RndY);
			}
		}
		SoundFX.CHOOSE.loop(Clip.LOOP_CONTINUOUSLY, 0.10);	
	}
	
	private void innitGui() {
		ta.setText("You wake up in the middle of nowhere with nothing"
				+" but your skills and a thirst for revenge. You look"
				+" around and see a number of tools:\n\nA staff\nA dagger"
				+"\nA sword\nA pair of glasses\nA bow\nWhat do you grab?");
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Start.tfState.action();
				Start.tf.setText(null);
				if(Start.Player!=null && Start.gameIsRunning) {
					if(Start.Player.current.hasEnemy && !battle.isRunning()) {
						background.stop();
						battle.loop(Clip.LOOP_CONTINUOUSLY,0.25);
					}
					else if(!Start.Player.current.hasEnemy && battle.isRunning()) {
						battle.stop();
						background.loop(Clip.LOOP_CONTINUOUSLY, 0.10);
					}
					
					else if(!Start.Player.current.hasEnemy && !battle.isRunning()) {
						background.loop(Clip.LOOP_CONTINUOUSLY, 0.1);
					}
					
					else if(Start.Player.current.hasEnemy && battle.isRunning()) {
						battle.loop(Clip.LOOP_CONTINUOUSLY, 0.25);
					}
				}
				//System.out.println(Start.Player.current.x+","+Start.Player.current.y);
			}
		});
	}

}
