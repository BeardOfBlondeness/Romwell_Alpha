package builders;


import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

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
		glPushMatrix();
		tex.bind();
		glTranslatef(xPos, yPos, zPos);		
		glColor3f(1,1,1);
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);                 			 glVertex2f(0, 0);
			glTexCoord2f(0, tex.getHeight());   			 glVertex2f(0, yRes);
			glTexCoord2f(tex.getWidth(), tex.getHeight()); 	 glVertex2f(xRes,yRes);
			glTexCoord2f(tex.getWidth(), 0);				 glVertex2f(xRes,0);
		}
		glEnd();

		glPopMatrix();
	}

	/*
	 * Don't judge me I'm lazy
	 */
	public void drawSelection(Texture tex, int posX, int posY, int sizeX, int sizeY) {
		
		float startX = posX/tex.getWidth();
		float startY = posY/tex.getHeight();
		
		float endX = (float) (startX+0.027);
		float endY = (float) 1;//posY+(sizeY/tex.getHeight());
		glPushMatrix();
		tex.bind();
		glTranslatef(xPos, yPos, zPos);		
		glColor3f(1,1,1);
		glBegin(GL_QUADS);
		{
			glTexCoord2f(startX, startY);                 	 glVertex2f(0, 0);
			glTexCoord2f(startX, endY);   					 glVertex2f(0, sizeY);
			glTexCoord2f(endX, endY); 						 glVertex2f(sizeX-10, sizeY);
			glTexCoord2f(endX, startY);						 glVertex2f(sizeX,0);
		}
		glEnd();

		glPopMatrix();
	}
	
	
	private float alpha = 0;
	private boolean fadeIn = true;
	private boolean fadeFinish = false;
	
	public void drawFade(Texture tex) {
		glPushMatrix();
		tex.bind();
		glTranslatef(xPos, yPos, zPos);		
		glColor4f(1,2,3,alpha);
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
		doubleFadeAlpha();
	}

	public void doubleFadeAlpha() {
		if(!fadeFinish) { 
			if(alpha <= 1.2 && fadeIn) {
				alpha+=0.005;
			}else if(alpha >= -0.05){
				fadeIn = false;
				alpha-=0.005;
			} else {
				fadeFinish = true;
			}
		} 
	}

	public boolean checkFadeStop() { 
		return fadeFinish;
	}

}
