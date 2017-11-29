package builders;

import org.newdawn.slick.opengl.Texture;

public class TextOutput {

	private int x;
	private int y;
	private int fontSize;
	private Sprite chara;
	private Texture alphabet;
	
	public TextOutput(int x, int y, int fontSize) {
		this.x = x;
		this.y = y;
		this.fontSize = fontSize;
		chara = new Sprite(1, 1, x, y, 0, fontSize, fontSize);
		alphabet = Paint.loadTexture("res/builders/alphabet_white.png", "PNG");
	}
	
	public void drawChar(int charPos, int displayPos) {
		int selectX = 100*charPos;
		
		
		chara.drawSelection(alphabet, selectX, 0, 100, 100);
	}
}
