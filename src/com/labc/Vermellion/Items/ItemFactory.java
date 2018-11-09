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
import com.labc.Vermellion.Items.Weapons.Knive;
import com.labc.Vermellion.Items.Weapons.Mind;
import com.labc.Vermellion.Items.Weapons.Staff;
import com.labc.Vermellion.Items.Weapons.Sword;
import com.labc.Vermellion.Character;

public class ItemFactory {
	private Character owner;
	public ItemFactory(Character owner) {
		this.owner = owner;
	}
	
	public Item getItem ( String name ) {
		if(name.equals(null))
			return null;
		//Weapons
		else if(name.equalsIgnoreCase("AXE"))
			return new Axe(this.owner);
		
		else if(name.equalsIgnoreCase("BOW"))
			return new Bow(this.owner);
		
		else if(name.equalsIgnoreCase("KNIVE"))
			return new Knive(this.owner);
		
		else if(name.equalsIgnoreCase("MIND"))
			return new Mind(this.owner);
		
		else if(name.equalsIgnoreCase("STAFF"))
			return new Staff(this.owner);
		
		else if(name.equalsIgnoreCase("SWORD"))
			return new Sword(this.owner);
		//Food
		else if(name.equalsIgnoreCase("APPLE"))
			return new Apple(this.owner);
		
		else if(name.equalsIgnoreCase("BLUEPOT"))
			return new BluePot(this.owner);
		
		else if(name.equalsIgnoreCase("CACHITO"))
			return new Cachito(this.owner);
		
		else if(name.equalsIgnoreCase("CHICHA"))
			return new Chicha(this.owner);
		
		else if(name.equalsIgnoreCase("FUNGI"))
			return new Fungi(this.owner);
		
		else if(name.equalsIgnoreCase("GREENPOT"))
			return new GreenPot(this.owner);
		
		else if(name.equalsIgnoreCase("REDPOT"))
			return new RedPot(this.owner);
		
		else if(name.equalsIgnoreCase("SPAGHETTIOS"))
			return new SpaghettiOs(this.owner);
		
		return null;
	}
}
