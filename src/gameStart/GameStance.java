package gameStart;

import static builders.Paint.LoadTexture;

import org.newdawn.slick.opengl.Texture;

import stance.Menu;

public class GameStance {
	
	private int doit;
	private String stances;
	private Menu m;
	private Texture[] textures;
	private int i;
	
	public GameStance(String stance) { 
		this.stances = stance;
		doit = 0;
		i = 0;
		loadTextures();
	}
	
	public void loadTextures() {
		textures = new Texture[8];
		textures[0] = LoadTexture("res/menu/1.png", "PNG");
		textures[1] = LoadTexture("res/menu/2.png", "PNG");
		textures[2] = LoadTexture("res/menu/3.png", "PNG");
		textures[3] = LoadTexture("res/menu/4.png", "PNG");
		textures[4] = LoadTexture("res/menu/5.png", "PNG");
		textures[5] = LoadTexture("res/menu/6.png", "PNG");
		textures[6] = LoadTexture("res/menu/7.png", "PNG");
		textures[7] = LoadTexture("res/menu/8.png", "PNG");
		m = new Menu(LoadTexture("res/menu/background.gif", "GIF"));
	}

	public String getStance() {
		return stances;
	}

	public void setStance(String stance) {
		this.stances = stance;
	}
	
	public void CheckStance() {
		switch(stances) {
		case "menu": 
			if(i==8) {
				i = 0;	
			}
			if(doit == 0) {
				m.setTex(textures[i]);
				m.draw();
				i++;
				doit++;
			}else if (doit == 1){
				doit++;
				m.setTex(textures[i]);
				m.draw();
			}else if(doit == 2) {
				doit = 0;
				m.setTex(textures[i]);
				m.draw();
			}
		}
	}
}