package builders;


import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;

import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;
import gameStart.FrameLoop;
public class Sprite {
	int xSquares; 
	int ySquares;
	int xPos;
	int yPos;
	float xRes;
	float yRes;
	static float RATIO = 1;
	int zPos;
	public static float getRatio() {
		return RATIO;
	}

	public void setRatio(float ratio) {
		RATIO = ratio;
	}

	public int getzPos() {
		return zPos;
	}

	public void setzPos(int zPos) {
		this.zPos = zPos;
	}

	public void setxRes(float xRes) {
		this.xRes = xRes;
	}

	public void setyRes(float yRes) {
		this.yRes = yRes;
	}

	public int getxSquares() {
		return xSquares;
	}

	public void setxSquares(int xSquares) {
		this.xSquares = xSquares;
	}

	public int getySquares() {
		return ySquares;
	}

	public void setySquares(int ySquares) {
		this.ySquares = ySquares;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public float getxRes() {
		return xRes;
	}

	public void setxRes(int xRes) {
		this.xRes = xRes;
	}

	public float getyRes() {
		return yRes;
	}

	public void setyRes(int yRes) {
		this.yRes = yRes;
	}

	public Sprite(int xSquares, int ySquares, int xPos, int yPos, int zPos, float xRes, float yRes) {
		this.xSquares = xSquares;
		this.ySquares = ySquares;
		this.xPos = xPos;
		this.yPos = yPos;
		this.xRes = xRes;
		this.yRes = yRes;
		this.zPos = zPos;
	}

	public void draw(Texture tex) {

		//glClear(GL_COLOR_BUFFER_BIT);
		glPushMatrix();
		tex.bind();
		glTranslatef(xPos, yPos, zPos);		
		glColor3f(1,1,1);
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
			glVertex2f(0, 0);
			glTexCoord2f(0, tex.getHeight());
			glVertex2f(0, yRes);
			glTexCoord2f(tex.getWidth(), tex.getHeight());
			glVertex2f(xRes,yRes);
			glTexCoord2f(tex.getWidth(), 0);
			glVertex2f(xRes,0);
		}
		glEnd();

		glPopMatrix();
	}

	private boolean down = false;

	public void addListener(int item, String key, String buttonAction) {
		if(item == 0) {
			if(key.equals("LeftRelease")) {
				if(Mouse.isButtonDown(0)) {
					System.out.println("mouse down");
					this.xRes = (210);
					this.yRes = (53);
					this.down = true;
				}
				while(Mouse.next()) {
					if(Mouse.isButtonDown(0)) {
						System.out.println("mouse down");
						this.down = true;
					}else { 
						if(down) {
							System.out.println("Mouse has been pressed");
							FrameLoop.gs.setStance(buttonAction);
							this.down = false;
						}
					}
				}
			}
		}
	}
}
