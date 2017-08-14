package stance;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import builders.Button;
import builders.Sprite;
import javax.sound.sampled.*;
import static builders.Paint.LoadTexture;

public class Menu {

	private Texture background;
	private Sprite bg;
	private Texture tex;
	private Texture exitTexture;
	private Texture loadTexture;
	private Texture newTexture;
	private Texture settingsTexture;

	private Sprite exitT;
	private Sprite loadT;
	private Sprite newT;
	private Sprite settingsT;
	private Button newBut;
	private Button loadBut;
	private Button settingsBut;
	private Button exitBut;

	public Menu(Texture tex) {

		this.background = tex;
		this.setTex(tex);

		bg = new Sprite(16, 9, 0, 0, 0, 900, 540);
		exitTexture = LoadTexture("res/menu/Exit.png", "PNG");
		loadTexture = LoadTexture("res/menu/LoadGame.png", "PNG");
		newTexture = LoadTexture("res/menu/NewGame.png", "PNG");
		settingsTexture = LoadTexture("res/menu/Settings.png", "PNG");

		newT = new Sprite(1, 1, 0, 300, 0, 200, 50);
		loadT = new Sprite(1, 1, 0, 360, 0, 200, 50);
		settingsT = new Sprite(1, 1, 0, 420, 0, 200, 50);
		exitT = new Sprite(1, 1, 0, 480, 0, 200, 50);

		newBut = new Button(newT);
		loadBut = new Button(loadT);
		settingsBut = new Button(settingsT);
		exitBut = new Button(exitT);
		try {
			File yourFile = new File("res/menu/rain.wav");
			AudioInputStream stream;
			AudioFormat format;
			DataLine.Info info;
			Clip clip;

			stream = AudioSystem.getAudioInputStream(yourFile);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			FloatControl gainControl = 
					(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-20.0f);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void draw() {
		bg.Draw(background);
		drawButtons();
	}

	public Texture getTex() {
		return tex;
	}

	public void setTex(Texture tex) {
		this.tex = tex;
		this.background = tex;
	}

	private boolean hover = false;
	private boolean down = false;
	
	public void drawButtons() {
		newT.Draw(newTexture);
		loadT.Draw(loadTexture);
		settingsT.Draw(settingsTexture);
		exitT.Draw(exitTexture);

		if(newBut.MakeButt()) {
			if(!hover) {

				newT.setxRes(220);
				newT.setyRes(55);
				newT.addListener(0, "LeftRelease");
				loadT.setxRes(200);
				loadT.setyRes(50);
				settingsT.setxRes(200);
				settingsT.setyRes(50);
				exitT.setxRes(200);
				exitT.setyRes(50);
				hover = true;
			} else {
				hover = false;
			}
		}else if(loadBut.MakeButt()) {
			if(!hover) {
				newT.setxRes(200);
				newT.setyRes(50);
				settingsT.setxRes(200);
				settingsT.setyRes(50);
				exitT.setxRes(200);
				exitT.setyRes(50);
				loadT.setxRes(220);
				loadT.setyRes(55);
				loadT.addListener(0, "LeftRelease");
				hover = true;
			}else {
				hover = false;
			}
		}else if(settingsBut.MakeButt()) {
			if(!hover) {
				newT.setxRes(200);
				newT.setyRes(50);
				loadT.setxRes(200);
				loadT.setyRes(50);
				exitT.setxRes(200);
				exitT.setyRes(50);
				settingsT.setxRes(220);
				settingsT.setyRes(55);
				settingsT.addListener(0, "LeftRelease");
				hover = true;
			}else {
				hover = false;
			}
		}else if(exitBut.MakeButt()) {
			if(!hover) {
				newT.setxRes(200);
				newT.setyRes(50);
				loadT.setxRes(200);
				loadT.setyRes(50);
				settingsT.setxRes(200);
				settingsT.setyRes(50);
				exitT.setxRes(220);
				exitT.setyRes(55);
				exitT.addListener(0, "LeftRelease");
				hover = true;
			}else {
				hover = false;
			}
		} else { 
			if(hover) {
				newT.setxRes(200);
				newT.setyRes(50);
				loadT.setxRes(200);
				loadT.setyRes(50);
				settingsT.setxRes(200);
				settingsT.setyRes(50);
				exitT.setxRes(200);
				exitT.setyRes(50);
				hover = false;
			}else {
				hover = true;
			}
		}
	}


}
