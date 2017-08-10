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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.IntBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

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
	private GameStance gs; // State of the game
	
	
	public FrameLoop() { 
		/**
		 * Creates the frame.
		 */
		try {
			
			Display();
			gs = new GameStance("menu");
			Update();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Display() {
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
	}

	public void Update() throws LWJGLException {
		/**
		 * Starts the game loop.
		 */
		
		while(!Display.isCloseRequested())
		{
			glClear(GL_COLOR_BUFFER_BIT);
			gs.CheckStance();
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
		KillAllGame();
	}
	
	public void KillAllGame() {
		/**
		 * Destroys the game.
		 */
		Display.destroy();
	}

	
	public void cursor() {
		/**
		 * Makes the cursor.
		 */
		BufferedImage img;
		try {
			img = ImageIO.read(new File("res/Game/Cursor.png"));
		    final int w = img.getWidth();
		    final int h = img.getHeight();

		    int rgbData[] = new int[w * h];

		    for (int i = 0; i < rgbData.length; i++)
		    {
		        int x = i % w;
		        int y = h - 1 - i / w; // this will also flip the image vertically

		        rgbData[i] = img.getRGB(x, y);
		    }

			
		    IntBuffer buffer = BufferUtils.createIntBuffer(w * h);
		    buffer.put(rgbData);
		    buffer.rewind();
			Cursor cursor = new Cursor(20, 20,0, 19, 1, buffer, null);
			Mouse.setNativeCursor(cursor);
		} catch (IOException | LWJGLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}