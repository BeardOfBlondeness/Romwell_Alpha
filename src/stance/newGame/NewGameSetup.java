package stance.newGame;

import builders.Button;
import builders.TextOutput;
import builders.Paint;
import builders.Sprite;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.opengl.Texture;

public class NewGameSetup {
	
	private static boolean firstCall = true;
	static int i = 0;
	static int index = 0;
	static TextOutput text;
	
	public static void createGameFile() {
		if(firstCall) {
			generateSprites();
			firstCall = false;
		} else {
			gameStart.FrameLoop.gs.limitRenderFrames(false);
			text.drawText();
			
		}
	}
	
	public static void generateSprites() {
		text = new TextOutput(70, "res/menu/textBox.png", "white", 50, 350, 800, 90);
	}

}
