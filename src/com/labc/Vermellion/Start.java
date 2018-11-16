package com.labc.Vermellion;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import com.labc.Vermellion.Classes.TextFieldStates.ChooseClassState;
import com.labc.Vermellion.Classes.TextFieldStates.TextFieldState;
import javax.swing.*;

public class Start {
	public static Tile starting;
	private SingletonMap map;
	public static Random rnd = new Random();
	public static String clase = "";
	public static Character Player;
	public static boolean gameIsRunning;
	public static JFrame frame;
	public static JLabel pic;
	public static JTextField tf;
	public static TextFieldState tfState;
	public static JTextArea Stats, ta, TileTitle;
	
	public Start() throws IOException {
		Start.gameIsRunning = true;
		Start.tfState = ChooseClassState.instance();
		innitGui();
		map = SingletonMap.getInstance();
		//this.Player = Singleton.getInstance(starting, clase);
		int RndX = rnd.nextInt(SingletonMap.MapSize), RndY = rnd.nextInt(SingletonMap.MapSize);
		while(RndY>SingletonMap.MapSize/2)
			RndY = rnd.nextInt(SingletonMap.MapSize);
		Start.starting = map.getTile(RndX, RndY);
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
				//System.out.println(Start.Player.current.x+","+Start.Player.current.y);
			}
		});
	}

}
