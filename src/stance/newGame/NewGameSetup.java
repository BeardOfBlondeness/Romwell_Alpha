package stance.newGame;

import builders.Button;
import builders.TextOutput;
import builders.Paint;
import builders.Sprite;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.opengl.Texture;

public class NewGameSetup {
	
	private static boolean a = false;
	private static boolean b = false;
	private static boolean c = false;
	private static boolean d = false;
	private static boolean e = false;
	private static boolean f = false;
	private static boolean g = false;
	private static boolean h = false;
	private static boolean _i = false;
	private static boolean j = false;
	private static boolean k = false;
	private static boolean l = false;
	private static boolean m = false;
	private static boolean n = false;
	private static boolean o = false;
	private static boolean p = false;
	private static boolean q = false;
	private static boolean r = false;
	private static boolean s = false;
	private static boolean t = false;
	private static boolean u = false;
	private static boolean v = false;
	private static boolean w = false;
	private static boolean x = false;
	private static boolean y = false;
	private static boolean z = false;
	private static boolean back = false;
	private static boolean boxSelected = false;
	private static boolean firstCall = true;
	private static boolean keyDown = false;
	private static boolean draw = false;
	private static Texture flickerTex;
	private static Texture boxTex;
	private static Sprite textBox;
	private static Sprite flickerLine;
	private static Button textButt;
	private static TextOutput[] text;
	private static int fCount = 0;
	private static int charPos;
	static int i = 0;
	static int index = 0;
	public static void createGameFile() {
		if(firstCall) {
			generateSprites();
			firstCall = false;
		} else {
			textBox.draw(boxTex);
			createBoxListener();
			if(draw) {
				drawText();
			}
			
		}
	}
	
	public static void drawText() {
		if(index < 15) {
			for(int count = 0; count < index; count++) {
				System.out.println(count);
				text[count].drawChar(flickerLine.getxPos());
			}
		}
		
	}

	public static void generateSprites() {
		boxTex = Paint.loadTexture("res/menu/textBox.png", "PNG");
		flickerTex = Paint.loadTexture("res/builders/textLine.bmp", "BMP");
		flickerLine = new Sprite(0, 0, 210, 215, 0, 5, 110);
		textBox = new Sprite(0, 0, 200, 205, 0, 500, 130);
		textButt = new Button(textBox);
		
		text = new TextOutput[16];
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
			a = true;
		} else if(a) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			a = false;

			index++;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_B)){
			keyDown = true;
			charPos = 1;
			b = true;
		} else if(b) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			b = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_C)){
			keyDown = true;
			charPos = 2;
			c = true;
		} else if(c) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			c = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			keyDown = true;
			charPos = 3;
			d = true;
		} else if(d) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			d = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_E)){
			keyDown = true;
			charPos = 4;
			e = true;
		} else if(e) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			e = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_F)){
			keyDown = true;
			charPos = 5;
			f = true;
		} else if(f) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			f = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_G)){
			keyDown = true;
			charPos = 6;
			g = true;
		} else if(g) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			g = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_H)){
			keyDown = true;
			charPos = 7;
			h = true;
		} else if(h) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			h = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_I)){
			keyDown = true;
			charPos = 8;
			_i = true;
		} else if(_i) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			_i = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_J)){
			keyDown = true;
			charPos = 9;
			j = true;
		} else if(j) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			j = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_K)){
			keyDown = true;
			charPos = 10;
			k = true;
		} else if(k) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			k = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_L)){
			keyDown = true;
			charPos = 11;
			l = true;
		} else if(l) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			l = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_M)){
			keyDown = true;
			charPos = 12;
			m = true;
		} else if(m) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			m = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_N)){
			keyDown = true;
			charPos = 13;
			n = true;
		} else if(n) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			n = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_O)){
			keyDown = true;
			charPos = 14;
			o = true;
		} else if(o) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			o = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_P)){
			keyDown = true;
			charPos = 15;
			p = true;
		} else if(p) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			p = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_Q)){
			keyDown = true;
			charPos = 16;
			q = true;
		} else if(q) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			q = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_R)){
			keyDown = true;
			charPos = 17;
			r = true;
		} else if(r) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			r = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			keyDown = true;
			charPos = 18;
			s = true;
		} else if(s) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			s = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_T)){
			keyDown = true;
			charPos = 19;
			t = true;
		} else if(t) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			t = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_U)){
			keyDown = true;
			charPos = 20;
			u = true;
		} else if(u) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			u = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_V)){
			keyDown = true;
			charPos = 21;
			v = true;
		} else if(v) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			v = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			keyDown = true;
			charPos = 22;
			w = true;
		} else if(w) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			w = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_X)){
			keyDown = true;
			charPos = 23;
			x = true;
		} else if(x) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			x = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_Y)){
			keyDown = true;
			charPos = 24;
			y = true;
		} else if(y) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			y = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_Z)){
			keyDown = true;
			charPos = 25;
			z = true;
		} else if(z) {
			flickerLine.setxPos(flickerLine.getxPos() + 100);
			z = false;

			index++;
		} 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_BACK)){
			back = true;
		} else if(back) {
			flickerLine.setxPos(flickerLine.getxPos() - 100);
			back = false;
			
			index--;
		} 
		
		if(keyDown) {
			text[index] = new TextOutput(flickerLine.getxPos(), 220, 110, charPos);
			System.out.println(index);
			keyDown = false;
			draw = true;
		}
		
		
		
	}
	
	
	
}
