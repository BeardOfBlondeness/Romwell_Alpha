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
	private boolean enter = false;
	private boolean keyDown = false;
	private boolean draw = false;
	private boolean boxSelected = false;
	private boolean backStart = true;
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
	private long beginTime;
	public TextOutput(int fontSize, String boxTexPath, String font, int boxX, int boxY, int boxSizeX, int boxSizeY) {
		this.fontSize = fontSize;
		this.alphabet = Paint.loadTexture("res/builders/alphabet_" + font + ".png", "PNG");
		this.boxTex = Paint.loadTexture(boxTexPath, "PNG");
		this.flickerTex = Paint.loadTexture("res/builders/textLine.bmp", "BMP");
		this.flickerLine = new Sprite(0, 0, boxX+(boxSizeX/40), (boxY+boxSizeY/10), 0, fontSize/20, fontSize);
		this.textBox = new Sprite(0, 0, boxX, boxY, 0, boxSizeX, boxSizeY);
		this.textButt = new Button(textBox);
		this.text = new Sprite[11];
		this.charPos = new int[11];
		
		for(int gen = 0; gen < 11; gen++) {
			text[gen] = new Sprite(1, 1, flickerLine.getxPos(), flickerLine.getyPos(), 0, fontSize, fontSize);
		}
	}
	
	public void drawText() {
		textBox.draw(boxTex);
		createBoxListener();
		if(draw && index < 11) {
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
	
	public void processKey(int charaPos) {
		if(index < 10) {
			charPos[index] = charaPos;
			text[index].setxPos(flickerLine.getxPos());
			index++;
			flickerLine.setxPos(flickerLine.getxPos() + fontSize);
		}
		
	}
	
	public void beginKeyboardListeners() {
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			keyDown = true;
			a = true;
		} else if(a) {
			a = false;
			processKey(0);
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_B)){
			keyDown = true;
			b = true;
		} else if(b) {
			b = false;
			processKey(1);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_C)){
			keyDown = true;
			c = true;
		} else if(c) {
			c = false;
			processKey(2);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			keyDown = true;
			d = true;
		} else if(d) {
			d = false;
			processKey(3);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_E)){
			keyDown = true;
			e = true;
		} else if(e) {
			e = false;
			processKey(4);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_F)){
			keyDown = true;
			f = true;
		} else if(f) {
			f = false;
			processKey(5);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_G)){
			keyDown = true;
			g = true;
		} else if(g) {
			g = false;
			processKey(6);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_H)){
			keyDown = true;
			h = true;
		} else if(h) {
			h = false;
			processKey(7);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_I)){
			keyDown = true;
			i = true;
		} else if(i) {
			i = false;
			processKey(8);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_J)){
			keyDown = true;
			j = true;
		} else if(j) {
			j = false;
			processKey(9);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_K)){
			keyDown = true;
			k = true;
		} else if(k) {
			k = false;
			processKey(10);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_L)){
			keyDown = true;
			l = true;
		} else if(l) {
			l = false;
			processKey(11);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_M)){
			keyDown = true;
			m = true;
		} else if(m) {
			m = false;
			processKey(12);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_N)){
			keyDown = true;
			n = true;
		} else if(n) {
			n = false;
			processKey(13);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_O)){
			keyDown = true;
			o = true;
		} else if(o) {
			o = false;
			processKey(14);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_P)){
			keyDown = true;
			p = true;
		} else if(p) {
			p = false;
			processKey(15);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_Q)){
			keyDown = true;
			q = true;
		} else if(q) {
			q = false;
			processKey(16);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_R)){
			keyDown = true;
			r = true;
		} else if(r) {
			r = false;
			processKey(17);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			keyDown = true;
			s = true;
		} else if(s) {
			s = false;
			processKey(18);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_T)){
			keyDown = true;
			t = true;
		} else if(t) {
			t = false;
			processKey(19);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_U)){
			keyDown = true;
			u = true;
		} else if(u) {
			u = false;
			processKey(20);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_V)){
			keyDown = true;
			v = true;
		} else if(v) {
			v = false;
			processKey(21);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			keyDown = true;
			w = true;
		} else if(w) {
			w = false;
			processKey(22);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_X)){
			keyDown = true;
			x = true;
		} else if(x) {
			x = false;
			processKey(23);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_Y)){
			keyDown = true;
			y = true;
		} else if(y) {
			y = false;
			processKey(24);
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_Z)){
			System.out.println("\nz");
			keyDown = true;
			z = true;
		} else if(z) {
			z = false;
			processKey(25);
		} 
		
		
		if(Keyboard.isKeyDown(Keyboard.KEY_BACK)){
			if(backStart) {
				beginTime = System.currentTimeMillis();
				backStart = false;
			}
			System.out.println("down");
			back = true;
			checkBackSpace();
		} else if(back) {
			backStart = true;
			back = false;
			if(index > 0) {
				flickerLine.setxPos(flickerLine.getxPos() - fontSize);
				index--;
			}
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
			enter = true;
		} else if(enter) {
			enter = false;
			finishCharacter();
		} 
		
		if(keyDown) {
			draw = true;
		}
	}
	
	public void checkBackSpace() {
		if((System.currentTimeMillis() - beginTime) > 500 && index > 0) {
			if((System.currentTimeMillis() - beginTime)%50 == 0) {
				flickerLine.setxPos(flickerLine.getxPos() - fontSize);
				index--;
			}
		}
	}
	
	public void finishCharacter() {
		CharacterSave s = new CharacterSave(charPos, index);
		s.saveGame();
	}
}
