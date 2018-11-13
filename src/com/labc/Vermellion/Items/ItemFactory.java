package com.labc.Vermellion.Items;

import com.labc.Vermellion.Item;
import com.labc.Vermellion.Items.Consumables.Apple;
import com.labc.Vermellion.Items.Consumables.BluePot;
import com.labc.Vermellion.Items.Consumables.Cachito;
import com.labc.Vermellion.Items.Consumables.Chicha;
import com.labc.Vermellion.Items.Consumables.Fungi;
import com.labc.Vermellion.Items.Consumables.GreenPot;
import com.labc.Vermellion.Items.Consumables.RedPot;
import com.labc.Vermellion.Items.Consumables.SpaghettiOs;
import com.labc.Vermellion.Items.Weapons.Axe;
import com.labc.Vermellion.Items.Weapons.Bow;
import com.labc.Vermellion.Items.Weapons.Dagger;
import com.labc.Vermellion.Items.Weapons.Excalibur;
import com.labc.Vermellion.Items.Weapons.MajorasMask;
import com.labc.Vermellion.Items.Weapons.Mind;
import com.labc.Vermellion.Items.Weapons.Staff;
import com.labc.Vermellion.Items.Weapons.Sword;
import com.labc.Vermellion.Character;

public class ItemFactory {
	
	
	public static Item getItem ( String name, Character owner ) {
		if(name.equals(null))
			return null;
		//Weapons
		else if(name.equalsIgnoreCase("AXE"))
			return new Axe(owner);
		
		else if(name.equalsIgnoreCase("BOW"))
			return new Bow(owner);
		
		else if(name.equalsIgnoreCase("DAGGER"))
			return new Dagger(owner);
		
		else if(name.equalsIgnoreCase("MIND"))
			return new Mind(owner);
		
		else if(name.equalsIgnoreCase("STAFF"))
			return new Staff(owner);
		
		else if(name.equalsIgnoreCase("SWORD"))
			return new Sword(owner);
		
		else if(name.equalsIgnoreCase("EXCALIBUR"))
			return new Excalibur(owner);
		
		else if(name.equalsIgnoreCase("MAJORASMASK"))
			return new MajorasMask(owner);
		//Food
		else if(name.equalsIgnoreCase("APPLE"))
			return new Apple(owner);
		
		else if(name.equalsIgnoreCase("BLUEPOT"))
			return new BluePot(owner);
		
		else if(name.equalsIgnoreCase("CACHITO"))
			return new Cachito(owner);
		
		else if(name.equalsIgnoreCase("CHICHA"))
			return new Chicha(owner);
		
		else if(name.equalsIgnoreCase("FUNGI"))
			return new Fungi(owner);
		
		else if(name.equalsIgnoreCase("GREENPOT"))
			return new GreenPot(owner);
		
		else if(name.equalsIgnoreCase("REDPOT"))
			return new RedPot(owner);
		
		else if(name.equalsIgnoreCase("SPAGHETTIOS"))
			return new SpaghettiOs(owner);
		
		return null;
	}
}
