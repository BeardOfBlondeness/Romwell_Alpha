package builders;


import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Paint {

	
	/**
	 * Draw a quad.
	 * @param tex - Texture for the quad.
	 * @param x - X starting coordinate of the quad.
	 * @param y - Y starting coordinate of the quad.
	 * @param z - Z starting coordinate of the quad.
	 * @param width - Width of the quad
	 * @param height - Height of the quad.
	 */
	public static void DrawQuadTex(Texture tex, float x, float y, float z, float width, float height) {
		glClear(GL_COLOR_BUFFER_BIT);
		glPushMatrix();
		tex.bind();
		glTranslatef(x, y, z);		
		glColor3f(1,1,1);
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
			glVertex2f(0, 0);
			glTexCoord2f(0, tex.getHeight());
			glVertex2f(0, height);
			glTexCoord2f(tex.getWidth(), tex.getHeight());
			glVertex2f(width,height);
			glTexCoord2f(tex.getWidth(), 0);
			glVertex2f(width,0);
		}
		glEnd();
		glPopMatrix();
		glDeleteTextures(1);
	}

	/**
	 * Quick load a JPEG texture ( change to PNG)
	 * @param path - Path of the file
	 * @return Texture object
	 */
	public static Texture QuickLoad(String path) {
		Texture tex = null;
		tex = loadTexture(path, "JPEG");
		return tex;	
	}

	/**
	 * Loads a texture that isn't JPEG
	 * @param path - Path of the file 
	 * @param fileType - Type of file (PNG,JPEG ...)
	 * @return Texture object
	 */
	public static Texture loadTexture(String path, String fileType) {
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {
			tex = TextureLoader.getTexture(fileType, in); 
		} catch (IOException e) {

			e.printStackTrace();
		}
		return tex;
	}

}
