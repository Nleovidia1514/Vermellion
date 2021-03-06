package com.labc.Vermellion.Classes.TextFieldStates;

import javax.sound.sampled.Clip;

import com.labc.Vermellion.SoundFX;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Classes.Archer;
import com.labc.Vermellion.Classes.Fighter;
import com.labc.Vermellion.Classes.Mage;
import com.labc.Vermellion.Classes.Nerio;
import com.labc.Vermellion.Classes.Rogue;

public class ChooseClassState extends TextFieldState {
	private static ChooseClassState instance = new ChooseClassState();
	
	public static ChooseClassState instance() {
		return instance;
	}
	
	private void chooseClass() {
		Start.clase = Start.tf.getText();
		if(Start.clase.toLowerCase().contains("staff")) 
			Start.Player = new Mage(Start.starting);
		else if(Start.clase.toLowerCase().contains("dagger"))
			Start.Player = new Rogue(Start.starting);
		else if(Start.clase.toLowerCase().contains("sword"))
			Start.Player = new Fighter(Start.starting);
		else if(Start.clase.toLowerCase().contains("glasses"))
			Start.Player = new Nerio(Start.starting);
		else if(Start.clase.toLowerCase().contains("bow"))
			Start.Player = new Archer(Start.starting);
		else
			Start.ta.append("\nCan you get the dick out of your mouth?");
		
		if(Start.Player!=null) {
			SoundFX.CHOOSE.stop();
			Start.background.loop(Clip.LOOP_CONTINUOUSLY, 0.10);
			Start.tfState = PlayState.instance();
			Start.starting.accept(Start.Player);
			Start.Stats.setText("HP - "+(int)Start.Player.getHP()+"   "
			+"MAGIC - "+Start.Player.getMagic()+"   "
			+"THIRST - "+Start.Player.getThirst());
		}
	}

	@Override
	public void action() {
		chooseClass();
	}

}
