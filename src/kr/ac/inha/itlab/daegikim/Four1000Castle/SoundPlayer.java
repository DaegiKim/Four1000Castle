
package kr.ac.inha.itlab.daegikim.Four1000Castle;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;

public class SoundPlayer {
	public static void playPew(){
		try{
			AudioInputStream ais = AudioSystem.getAudioInputStream(SoundPlayer.class.getResource("resources/pew.wav"));
			Clip clip = (Clip)AudioSystem.getLine(new Line.Info(Clip.class));
			clip.open(ais);
			clip.start();
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public static void playError(){
		try{
			AudioInputStream ais = AudioSystem.getAudioInputStream(SoundPlayer.class.getResource("resources/error.wav"));
			Clip clip = (Clip)AudioSystem.getLine(new Line.Info(Clip.class));
			clip.open(ais);
			clip.start();
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public static void playIntro(){
		try{
			AudioInputStream ais = AudioSystem.getAudioInputStream(SoundPlayer.class.getResource("resources/intro.wav"));
			Clip clip = (Clip)AudioSystem.getLine(new Line.Info(Clip.class));
			clip.open(ais);
			clip.start();
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public static void playApplause(){
		try{
			AudioInputStream ais = AudioSystem.getAudioInputStream(SoundPlayer.class.getResource("resources/applause.wav"));
			Clip clip = (Clip)AudioSystem.getLine(new Line.Info(Clip.class));
			clip.open(ais);
			clip.start();
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
}
