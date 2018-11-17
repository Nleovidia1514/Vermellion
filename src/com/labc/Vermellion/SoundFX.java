package com.labc.Vermellion;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public enum SoundFX {
	WALK("sounds/walk.wav"),
	BACKGROUND("sounds/music.wav"),
	SARIA("sounds/Sariassong.wav"),
	DIE("sounds/die.wav"),
	NAVI("sounds/navi.wav"),
	HELLO("sounds/hello.wav"),
	BATTLE("sounds/battle.wav"),
	CHOOSE("sounds/choosingClass.wav"),
	ZELDA("sounds/zeldaOoT.wav"),
	BATTLEZELDA("sounds/Zeldabattle.wav"),
	WITCH("sounds/witch.wav"),
	VILLAGER("sounds/villager.wav"),
	FINALBATTLE("sounds/finalbattle.wav"),
	VICTORY("sounds/victory.wav");
	
	public static enum Volume {
	      MUTE, LOW, MEDIUM, HIGH
	   }
	
	public static Volume vol = Volume.LOW;
	
	private Clip fx;
	SoundFX(String path){
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File(path));
			fx = AudioSystem.getClip();
			fx.open(audio);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public void play(double volume) {
		FloatControl gainControl = (FloatControl) fx.getControl(FloatControl.Type.MASTER_GAIN);
		double gain = volume;
		float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
		gainControl.setValue(dB);
		if(vol != Volume.MUTE) {
			if(fx.isRunning())
				fx.stop();
		fx.setFramePosition(0);
		fx.start();
		}
	}
	
	public void loop(int times, double volume) {
		FloatControl gainControl = (FloatControl) fx.getControl(FloatControl.Type.MASTER_GAIN);
		double gain = volume;
		float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
		gainControl.setValue(dB);
		if(!fx.isRunning()) {
			fx.setFramePosition(0);
			fx.loop(times);
		}
	}
	
	public void stop() {
		if(fx.isRunning()) fx.stop();
	}
	
	public boolean isRunning() {
		boolean running = fx.isRunning();
		return running;
	}


}
