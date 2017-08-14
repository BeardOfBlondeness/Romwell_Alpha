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
import static builders.Paint.loadTexture;

public class Menu {

	private Sprite  bg;
	private Texture background;
	private Texture tex;
	private Texture exitTexture;
	private Texture loadTexture;
	private Texture newTexture;
	private Texture settingsTexture;

	private Sprite exitSprite;
	private Sprite loadSprite;
	private Sprite newSprite;
	private Sprite settingsSprite;
	private Button newButton;
	private Button loadButton;
	private Button settingsButton;
	private Button exitButton;

	public Menu(Texture tex) {

		this.background = tex;
		this.setTex(tex);

		bg = new Sprite(16, 9, 0, 0, 0, 900, 540);
		exitTexture = loadTexture("res/menu/Exit.png", "PNG");
		loadTexture = loadTexture("res/menu/LoadGame.png", "PNG");
		newTexture = loadTexture("res/menu/NewGame.png", "PNG");
		settingsTexture = loadTexture("res/menu/Settings.png", "PNG");

		newSprite = new Sprite(1, 1, 0, 300, 0, 200, 50);
		loadSprite = new Sprite(1, 1, 0, 360, 0, 200, 50);
		settingsSprite = new Sprite(1, 1, 0, 420, 0, 200, 50);
		exitSprite = new Sprite(1, 1, 0, 480, 0, 200, 50);

		newButton = new Button(newSprite);
		loadButton = new Button(loadSprite);
		settingsButton = new Button(settingsSprite);
		exitButton = new Button(exitSprite);
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
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-20.0f);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void draw() {
		bg.draw(background);
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
		newSprite.draw(newTexture);
		loadSprite.draw(loadTexture);
		settingsSprite.draw(settingsTexture);
		exitSprite.draw(exitTexture);

		if(newButton.makeButt()) {
			if(!hover) {

				newSprite.setxRes(220);
				newSprite.setyRes(55);
				newSprite.addListener(0, "LeftRelease");
				loadSprite.setxRes(200);
				loadSprite.setyRes(50);
				settingsSprite.setxRes(200);
				settingsSprite.setyRes(50);
				exitSprite.setxRes(200);
				exitSprite.setyRes(50);
				hover = true;
			} else {
				hover = false;
			}
		}else if(loadButton.makeButt()) {
			if(!hover) {
				newSprite.setxRes(200);
				newSprite.setyRes(50);
				settingsSprite.setxRes(200);
				settingsSprite.setyRes(50);
				exitSprite.setxRes(200);
				exitSprite.setyRes(50);
				loadSprite.setxRes(220);
				loadSprite.setyRes(55);
				loadSprite.addListener(0, "LeftRelease");
				hover = true;
			}else {
				hover = false;
			}
		}else if(settingsButton.makeButt()) {
			if(!hover) {
				newSprite.setxRes(200);
				newSprite.setyRes(50);
				loadSprite.setxRes(200);
				loadSprite.setyRes(50);
				exitSprite.setxRes(200);
				exitSprite.setyRes(50);
				settingsSprite.setxRes(220);
				settingsSprite.setyRes(55);
				settingsSprite.addListener(0, "LeftRelease");
				hover = true;
			}else {
				hover = false;
			}
		}else if(exitButton.makeButt()) {
			if(!hover) {
				newSprite.setxRes(200);
				newSprite.setyRes(50);
				loadSprite.setxRes(200);
				loadSprite.setyRes(50);
				settingsSprite.setxRes(200);
				settingsSprite.setyRes(50);
				exitSprite.setxRes(220);
				exitSprite.setyRes(55);
				exitSprite.addListener(0, "LeftRelease");
				hover = true;
			}else {
				hover = false;
			}
		} else {
			if(hover) {
				newSprite.setxRes(200);
				newSprite.setyRes(50);
				loadSprite.setxRes(200);
				loadSprite.setyRes(50);
				settingsSprite.setxRes(200);
				settingsSprite.setyRes(50);
				exitSprite.setxRes(200);
				exitSprite.setyRes(50);
				hover = false;
			}else {
				hover = true;
			}
		}
	}


}
