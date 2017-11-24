package stance.newGame;

import builders.Button;
import builders.TextOutput;
import builders.Paint;
import builders.SaveData;
import builders.Sprite;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.opengl.Texture;

public class NewGameSetup {

	private static boolean boxSelected = false;
	private static boolean firstCall = true;
	private static boolean drawText = false;
	private static Texture flickerTex;
	private static Texture boxTex;
	private static Sprite textBox;
	private static Sprite flickerLine;
	private static Button textButt;
	private static TextOutput text;
	private static int fCount = 0;
	private static boolean keyDown = false;
	private static int charPos;
	
	public static void createGameFile() {
		if(firstCall) {
			generateSprites();
			firstCall = false;
		} else {
			textBox.draw(boxTex);
			createBoxListener();
			if(drawText) {
				text.drawChar(charPos, flickerLine.getxPos());
			}
		}
	}

	public static void generateSprites() {
		boxTex = Paint.loadTexture("res/menu/textBox.png", "PNG");
		flickerTex = Paint.loadTexture("res/builders/textLine.bmp", "BMP");
		flickerLine = new Sprite(0, 0, 210, 215, 0, 5, 110);
		textBox = new Sprite(0, 0, 200, 205, 0, 500, 130);
		textButt = new Button(textBox);
		
		text = new TextOutput(210, 215, 110);
	}

	public static void createBoxListener() {
		if(textButt.makeButt()) {
			textButt.addListener(0, "LeftRelease", false);
			if(textButt.isClicked()) {
				fCount = 0;
				boxSelected = true;
			}
		}else {
			textButt.addListener(0, "LeftRelease", false);
			if(textButt.isClicked()) {
				boxSelected = false;
			}
		}
		if(boxSelected) {
			drawFlickeryThingy();
			beginKeyboardListeners();
		}
	}

	public static void drawFlickeryThingy() {
		if(fCount < 30) {
			flickerLine.draw(flickerTex);
		} else if(fCount == 60) {
			fCount = 0;
		}
		fCount++;
	}

	public static void beginKeyboardListeners() {
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			keyDown = true;
			charPos = 0;
		}else if(keyDown) {
			keyDown = false;
			drawText = true;
		}
		
	}
	
}
