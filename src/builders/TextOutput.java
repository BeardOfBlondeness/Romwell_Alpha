package builders;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.opengl.Texture;

public class TextOutput {
	private boolean a = false;
	private boolean b = false;
	private boolean c = false;
	private boolean d = false;
	private boolean e = false;
	private boolean f = false;
	private boolean g = false;
	private boolean h = false;
	private boolean i = false;
	private boolean j = false;
	private boolean k = false;
	private boolean l = false;
	private boolean m = false;
	private boolean n = false;
	private boolean o = false;
	private boolean p = false;
	private boolean q = false;
	private boolean r = false;
	private boolean s = false;
	private boolean t = false;
	private boolean u = false;
	private boolean v = false;
	private boolean w = false;
	private boolean x = false;
	private boolean y = false;
	private boolean z = false;
	private boolean back = false;
	private boolean keyDown = false;
	private boolean draw = false;
	private boolean boxSelected = false;
	private int index = 0;
	private int fontSize;
	private int fCount = 0;
	private int[] charPos;
	private Sprite[] text;
	private Sprite textBox;
	private Sprite flickerLine;
	private Button textButt;
	private Texture alphabet;
	private Texture flickerTex;
	private Texture boxTex;
	
	public TextOutput(int fontSize, String boxTexPath, String font, int boxX, int boxY, int boxSizeX, int boxSizeY) {
		this.fontSize = fontSize;
		this.alphabet = Paint.loadTexture("res/builders/alphabet_" + font + ".png", "PNG");
		this.boxTex = Paint.loadTexture(boxTexPath, "PNG");
		this.flickerTex = Paint.loadTexture("res/builders/textLine.bmp", "BMP");
		this.flickerLine = new Sprite(0, 0, boxX+(boxSizeX/40), (boxY+boxSizeY/10), 0, fontSize/20, fontSize);
		this.textBox = new Sprite(0, 0, boxX, boxY, 0, boxSizeX, boxSizeY);
		this.textButt = new Button(textBox);
		this.text = new Sprite[16];
		this.charPos = new int[16];
		
		for(int gen = 0; gen < 16; gen++) {
			text[gen] = new Sprite(1, 1, flickerLine.getxPos(), flickerLine.getyPos(), 0, fontSize, fontSize);
		}
	}
	
	public void drawText() {
		textBox.draw(boxTex);
		createBoxListener();
		if(draw && index < 15) {
			for(int count = 0; count < index; count++) {
				text[count].drawSelection(this.alphabet, 100*charPos[count], 0, 100, 100, fontSize, fontSize);
			}
		}
	}
	
	public void createBoxListener() {
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
	
	public void drawFlickeryThingy() {
		if(fCount < 30) {
			flickerLine.draw(flickerTex);
		} else if(fCount == 60) {
			fCount = 0;
		}
		fCount++;
	}
	
	public void beginKeyboardListeners() {
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			keyDown = true;
			a = true;
		} else if(a) {
			a = false;
			charPos[index] = 0;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_B)){
			keyDown = true;
			b = true;
		} else if(b) {
			b = false;
			charPos[index] = 1;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_C)){
			keyDown = true;
			c = true;
		} else if(c) {
			c = false;
			charPos[index] = 2;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			keyDown = true;
			d = true;
		} else if(d) {
			d = false;
			charPos[index] = 3;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_E)){
			keyDown = true;
			e = true;
		} else if(e) {
			e = false;
			charPos[index] = 4;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_F)){
			keyDown = true;
			f = true;
		} else if(f) {
			f = false;
			charPos[index] = 5;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_G)){
			keyDown = true;
			g = true;
		} else if(g) {
			g = false;
			charPos[index] = 6;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_H)){
			keyDown = true;
			h = true;
		} else if(h) {
			h = false;
			charPos[index] = 7;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_I)){
			keyDown = true;
			i = true;
		} else if(i) {
			i = false;
			charPos[index] = 8;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_J)){
			keyDown = true;
			j = true;
		} else if(j) {
			j = false;
			charPos[index] = 9;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_K)){
			keyDown = true;
			k = true;
		} else if(k) {
			k = false;
			charPos[index] = 10;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_L)){
			keyDown = true;
			l = true;
		} else if(l) {
			l = false;
			charPos[index] = 11;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_M)){
			keyDown = true;
			m = true;
		} else if(m) {
			m = false;
			charPos[index] = 12;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_N)){
			keyDown = true;
			n = true;
		} else if(n) {
			n = false;
			charPos[index] = 13;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_O)){
			keyDown = true;
			o = true;
		} else if(o) {
			o = false;
			charPos[index] = 14;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_P)){
			keyDown = true;
			p = true;
		} else if(p) {
			p = false;
			charPos[index] = 15;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_Q)){
			keyDown = true;
			q = true;
		} else if(q) {
			q = false;
			charPos[index] = 16;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_R)){
			keyDown = true;
			r = true;
		} else if(r) {
			r = false;
			charPos[index] = 17;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			keyDown = true;
			s = true;
		} else if(s) {
			s = false;
			charPos[index] = 18;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_T)){
			keyDown = true;
			t = true;
		} else if(t) {
			t = false;
			charPos[index] = 19;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_U)){
			keyDown = true;
			u = true;
		} else if(u) {
			u = false;
			charPos[index] = 20;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_V)){
			keyDown = true;
			v = true;
		} else if(v) {
			v = false;
			charPos[index] = 21;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			keyDown = true;
			w = true;
		} else if(w) {
			w = false;
			charPos[index] = 22;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_X)){
			keyDown = true;
			x = true;
		} else if(x) {
			x = false;
			charPos[index] = 23;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_Y)){
			System.out.println("\ny");
			keyDown = true;
			y = true;
		} else if(y) {
			y = false;
			charPos[index] = 24;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_Z)){
			System.out.println("\nz");
			keyDown = true;
			z = true;
		} else if(z) {
			z = false;
			charPos[index] = 25;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_BACK)){
			back = true;
		} else if(back) {
			back = false;
			if(index > 0) {
				flickerLine.setxPos(flickerLine.getxPos() - fontSize);
				index--;
			}
		} 
		if(keyDown) {
			draw = true;
		}
	}
	
}
