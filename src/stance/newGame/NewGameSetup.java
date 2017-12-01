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
	private static boolean keyDown = false;
	private static Texture flickerTex;
	private static Texture boxTex;
	private static Sprite textBox;
	private static Sprite flickerLine;
	private static Button textButt;
	private static TextOutput text;
	private static int fCount = 0;
	private static int charPos;
	static int i = 0;
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
		
		text = new TextOutput(210, 220, 110);
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
		} if(Keyboard.isKeyDown(Keyboard.KEY_B)){
			keyDown = true;
			charPos = 1;
		} if(Keyboard.isKeyDown(Keyboard.KEY_C)){
			keyDown = true;
			charPos = 2;
		} if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			keyDown = true;
			charPos = 3;
		} if(Keyboard.isKeyDown(Keyboard.KEY_E)){
			keyDown = true;
			charPos = 4;
		} if(Keyboard.isKeyDown(Keyboard.KEY_F)){
			keyDown = true;
			charPos = 5;
		} if(Keyboard.isKeyDown(Keyboard.KEY_G)){
			keyDown = true;
			charPos = 6;
		} if(Keyboard.isKeyDown(Keyboard.KEY_H)){
			keyDown = true;
			charPos = 7;
		} if(Keyboard.isKeyDown(Keyboard.KEY_I)){
			keyDown = true;
			charPos = 8;
		} if(Keyboard.isKeyDown(Keyboard.KEY_J)){
			keyDown = true;
			charPos = 9;
		} if(Keyboard.isKeyDown(Keyboard.KEY_K)){
			keyDown = true;
			charPos = 10;
		} if(Keyboard.isKeyDown(Keyboard.KEY_L)){
			keyDown = true;
			charPos = 11;
		} if(Keyboard.isKeyDown(Keyboard.KEY_M)){
			keyDown = true;
			charPos = 12;
		} if(Keyboard.isKeyDown(Keyboard.KEY_N)){
			keyDown = true;
			charPos = 13;
		} if(Keyboard.isKeyDown(Keyboard.KEY_O)){
			keyDown = true;
			charPos = 14;
		} if(Keyboard.isKeyDown(Keyboard.KEY_P)){
			keyDown = true;
			charPos = 15;
		} if(Keyboard.isKeyDown(Keyboard.KEY_Q)){
			keyDown = true;
			charPos = 16;
		} if(Keyboard.isKeyDown(Keyboard.KEY_R)){
			keyDown = true;
			charPos = 17;
		} if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			keyDown = true;
			charPos = 18;
		} if(Keyboard.isKeyDown(Keyboard.KEY_T)){
			keyDown = true;
			charPos = 19;
		} if(Keyboard.isKeyDown(Keyboard.KEY_U)){
			keyDown = true;
			charPos = 20;
		} if(Keyboard.isKeyDown(Keyboard.KEY_V)){
			keyDown = true;
			charPos = 21;
		} if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			keyDown = true;
			charPos = 22;
		} if(Keyboard.isKeyDown(Keyboard.KEY_X)){
			keyDown = true;
			charPos = 23;
		} if(Keyboard.isKeyDown(Keyboard.KEY_Y)){
			keyDown = true;
			charPos = 24;
		} if(Keyboard.isKeyDown(Keyboard.KEY_Z)){
			keyDown = true;
			charPos = 25;
		} 
		if(keyDown) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			keyDown = false;
			drawText = true;
		}else {
		
		}
		
	}
	
}
