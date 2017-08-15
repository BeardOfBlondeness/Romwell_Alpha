package gameStart;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glViewport;
import java.awt.Dimension;
import java.awt.Toolkit;
import builders.Paint;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import builders.Sprite;

public class FrameLoop {
	/**
	 * Creates and loops the game.
	 */

	private int FWIDTH = 900, FHEIGHT = 540; // Frame parameters
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Screen size
	private int WIDTH = (int) screenSize.getWidth(); // Screen width
	private int HEIGHT = (int) screenSize.getHeight(); // Screen height
	private int trueWidth = WIDTH; // Screen width full screen
	private int trueHeight = HEIGHT; // Screen height full screen
	private int mainStartPosx; // X start coordinate of viewport
	private int mainStartPosy; // y start coordinate of viewport
	public static GameStance gs; // State of the game
	private Sprite cursorSprite;
	private Texture cursorTexture;
	public FrameLoop() {
		/**
		 * Creates the frame.
		 */
		try {

			display();
			gs = new GameStance("menu");
			update();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void display() {
		/**
		 * Set the display.
		 */

		if(WIDTH > (HEIGHT/9)*16) {
			trueWidth = (HEIGHT/9)*16;
		} else {
			trueHeight = (WIDTH/16)*9;
		}
		mainStartPosx = (WIDTH - trueWidth)/2;
		mainStartPosy = (HEIGHT - trueHeight)/2;
		Display.setTitle("Romwell");
		cursorSprite = new Sprite(1, 1, 0, 0, 0, 20, 20);
		try {
			Display.setDisplayMode(new DisplayMode(FWIDTH, FHEIGHT));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, FWIDTH, FHEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		cursor();

		cursorTexture = Paint.loadTexture("res/game/Cursor.png", "PNG");
	}

	public void update() throws LWJGLException {
		/**
		 * Starts the game loop.
		 */

		while(!Display.isCloseRequested())
		{
			glClear(GL_COLOR_BUFFER_BIT);
			gs.checkStance();
			paintCursor();
			if(Keyboard.isKeyDown(Keyboard.KEY_F2)== true) {
				glViewport(mainStartPosx, mainStartPosy, trueWidth, trueHeight);
				Display.setDisplayModeAndFullscreen(Display.getDesktopDisplayMode());
			}
			Display.update();
			Display.sync(60);
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)== true) {
				break;
			}
		}
		killAllGame();
	}

	public static void killAllGame() {
		/**
		 * Destroys the game.
		 */
		Display.destroy();
		System.exit(0);
	}


	public void cursor() {
		/**
		 * Makes the cursor.
		 */
		Cursor emptyCursor;
		try {
			emptyCursor = new Cursor(1, 1, 0, 0, 1, BufferUtils.createIntBuffer(1), null);
			Mouse.setNativeCursor(emptyCursor);
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paintCursor() {
		cursorSprite.setxPos(Mouse.getX());
		cursorSprite.setyPos(FHEIGHT - Mouse.getY());
		cursorSprite.draw(cursorTexture);
	}
}
