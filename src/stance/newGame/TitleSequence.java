package stance.newGame;

import org.newdawn.slick.opengl.Texture;
import builders.Paint;
import builders.Sprite;

public class TitleSequence {

	private Sprite titleSprite;
	private Texture titleTexture;

	public TitleSequence() {
		this.titleSprite = new Sprite(1, 1, 0, 0, 0, 900, 540);
		this.titleTexture = Paint.loadTexture("res/title/TitleLogo.bmp", "BMP");
	}

	public Sprite getTitleSprite() {
		return titleSprite;
	}
	public void runTitleSequence() {
		if(!titleSprite.checkFadeStop()) {
			titleSprite.drawFade(titleTexture);
		}else {
			NewGameSetup.createGameFile();
		}
	}
}
