package com.labc.Vermellion.Classes.TextFieldStates;

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
		if(Start.clase.equalsIgnoreCase("staff") || Start.clase.equalsIgnoreCase("Dagger")
				|| Start.clase.equalsIgnoreCase("sword") || Start.clase.equalsIgnoreCase("glasses")
				|| Start.clase.equalsIgnoreCase("BOW")) {
			if(Start.clase.equalsIgnoreCase("staff")) 
				Start.Player = new Mage(Start.starting);
			else if(Start.clase.equalsIgnoreCase("dagger"))
				Start.Player = new Rogue(Start.starting);
			else if(Start.clase.equalsIgnoreCase("sword"))
				Start.Player = new Fighter(Start.starting);
			else if(Start.clase.equalsIgnoreCase("glasses"))
				Start.Player = new Nerio(Start.starting);
			else if(Start.clase.equalsIgnoreCase("bow"))
				Start.Player = new Archer(Start.starting);
			else
				Start.ta.setText("You look for "+Start.clase+" but you can't find one");
		}
		Start.tfState = PlayState.instance();
		Start.ta.append(Start.Player.getCurrent().getShortDescription());
		Start.ta.append("\nHP - "+Start.Player.getHP()+"\n"
		+"MAGIC - "+Start.Player.getMagic()+"\n"
		+"THIRST - "+Start.Player.getThirst());
	}

	@Override
	public void action() {
		chooseClass();
	}

}
