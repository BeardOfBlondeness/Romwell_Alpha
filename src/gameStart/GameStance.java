package gameStart;

import static builders.Paint.loadTexture;
import stance.newGame.TitleSequence;
import org.newdawn.slick.opengl.Texture;

import stance.Menu;

public class GameStance {

	private int frameCount;
	private String stance;
	private Menu m;
	private Texture[] textures;
	private int i;

	public GameStance(String stance) {
		this.stance = stance;
		frameCount = 0;
		i = 0;
		loadTextures();
	}

	public void loadTextures() {
		textures = new Texture[8];
		textures[0] = loadTexture("res/menu/1.png", "PNG");
		textures[1] = loadTexture("res/menu/2.png", "PNG");
		textures[2] = loadTexture("res/menu/3.png", "PNG");
		textures[3] = loadTexture("res/menu/4.png", "PNG");
		textures[4] = loadTexture("res/menu/5.png", "PNG");
		textures[5] = loadTexture("res/menu/6.png", "PNG");
		textures[6] = loadTexture("res/menu/7.png", "PNG");
		textures[7] = loadTexture("res/menu/8.png", "PNG");
		m = new Menu(loadTexture("res/menu/background.gif", "GIF"));
	}

	public String getStance() {
		return stance;
	}

	public void setStance(String stance) {
		this.stance = stance;
	}
	
	private boolean newGame = true;
	private TitleSequence title;
	
	public void limitRenderFrames() {
		frameCount=(frameCount+1)%3;
		if(frameCount == 0) i=(i+1)%8;
		m.setTex(textures[i]);
		m.draw();
	}
	
	public void checkStance() {
		switch(stance) {
		case "menu":
			limitRenderFrames();
			break;
		case "newGame":
			if(newGame) {
				title = new TitleSequence();
				newGame = false;
			} else { 
				title.runTitleSequence();
			}
		break;
		case "exit":
			FrameLoop.killAllGame();
			break;
		default:
			System.out.println("Default State");
		break;
		}
	}
}
