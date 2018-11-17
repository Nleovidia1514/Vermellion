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
import com.labc.Vermellion.Items.Equipamiento.Weapons.Axe;
import com.labc.Vermellion.Items.Equipamiento.Weapons.Bow;
import com.labc.Vermellion.Items.Equipamiento.Weapons.Dagger;
import com.labc.Vermellion.Items.Equipamiento.Weapons.Excalibur;
import com.labc.Vermellion.Items.Equipamiento.ChestPieces.Chestplate;
import com.labc.Vermellion.Items.Equipamiento.ChestPieces.HylianShield;
import com.labc.Vermellion.Items.Equipamiento.ChestPieces.Robe;
import com.labc.Vermellion.Items.Equipamiento.ChestPieces.TShirt;
import com.labc.Vermellion.Items.Equipamiento.ChestPieces.Tunic;
import com.labc.Vermellion.Items.Equipamiento.FootwearPieces.Boots;
import com.labc.Vermellion.Items.Equipamiento.FootwearPieces.IronBoots;
import com.labc.Vermellion.Items.Equipamiento.FootwearPieces.Sandals;
import com.labc.Vermellion.Items.Equipamiento.Helmets.Cap;
import com.labc.Vermellion.Items.Equipamiento.Helmets.Hat;
import com.labc.Vermellion.Items.Equipamiento.Helmets.Hood;
import com.labc.Vermellion.Items.Equipamiento.Helmets.IronHelmet;
import com.labc.Vermellion.Items.Equipamiento.Helmets.MajorasMask;
import com.labc.Vermellion.Items.Equipamiento.Helmets.Mind;
import com.labc.Vermellion.Items.Equipamiento.LeggingPieces.Chainmail;
import com.labc.Vermellion.Items.Equipamiento.LeggingPieces.Trousers;
import com.labc.Vermellion.Items.Equipamiento.Weapons.Staff;
import com.labc.Vermellion.Items.Equipamiento.Weapons.Sword;
import com.labc.Vermellion.Character;

public class ItemFactory {
	
	
	public static Item getItem ( String name, Character owner ) {
		if(name.equals(null))
			return null;
		//Equipment
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
		
		else if(name.equalsIgnoreCase("CHESTPLATE"))
			return new Chestplate(owner);
		
		else if(name.equalsIgnoreCase("HYLIANSHIELD"))
			return new HylianShield(owner);
		
		else if(name.equalsIgnoreCase("ROBE"))
			return new Robe(owner);
		
		else if(name.equalsIgnoreCase("TSHIRT"))
			return new TShirt(owner);
		
		else if(name.equalsIgnoreCase("TUNIC"))
			return new Tunic(owner);
		
		else if(name.equalsIgnoreCase("HOOD"))
			return new Hood(owner);
		
		else if(name.equalsIgnoreCase("IRONHELMET"))
			return new IronHelmet(owner);
		
		else if(name.equalsIgnoreCase("HAT"))
			return new Hat(owner);
		
		else if(name.equalsIgnoreCase("CAP"))
			return new Cap(owner);
		
		else if(name.equalsIgnoreCase("BOOTS"))
			return new Boots(owner);
		
		else if(name.equalsIgnoreCase("IRONBOOTS"))
			return new IronBoots(owner);
		
		else if(name.equalsIgnoreCase("SANDALS"))
			return new Sandals(owner);
		
		else if(name.equalsIgnoreCase("CHAINMAIL"))
			return new Chainmail(owner);
		
		else if(name.equalsIgnoreCase("TROUSERS"))
			return new Trousers(owner); 
		
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
