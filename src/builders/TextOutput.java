package builders;

public class TextOutput {

	private int x;
	private int y;
	private int fontSize;
	private Sprite chara;
	
	public TextOutput(int x, int y, int fontSize) {
		this.x = x;
		this.y = y;
		this.fontSize = fontSize;
		chara = new Sprite(1, 1, x, y, 0, fontSize, fontSize);
		
	}
	
	private void drawChar(int charPos) {
		
	}
}
