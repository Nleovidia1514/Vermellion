package com.labc.Vermellion;

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
	JFrame frame;
	JPanel panel;
	public static JTextArea ta;
	public static JTextField tf;
	public static TextFieldState tfState;
	
	public Start() throws IOException {
		Start.gameIsRunning = true;
		Start.tfState = ChooseClassState.instance();
		innitGui();
		//this.Player = Singleton.getInstance(starting, clase);
		map = SingletonMap.getInstance();
		Start.starting = map.getTile(rnd.nextInt(SingletonMap.MapSize), rnd.nextInt(SingletonMap.MapSize));
	}
	
	private void innitGui() {
		frame = new JFrame("Vermellion");
		panel = new JPanel();
		ta = new JTextArea("You wake up in the middle of nowhere with nothing\n"
				+"but your skills and a thirst for revenge. You look\n"
				+"around and see a number of tools:\n\nA staff\nA dagger"
				+"\nA sword\nA pair of glasses\nA bow\nWhat do you grab?");
		tf = new JTextField(10);
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Start.tfState.action();
				tf.setText(null);
				frame.pack();
			}
			
		});
		ta.setEditable(false);
		panel.add(ta);
		panel.add(tf);
		tf.setRequestFocusEnabled(true);
		panel.setLayout(new GridLayout(2,1));
		frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new Start();
	}

}
