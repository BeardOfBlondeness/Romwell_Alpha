package builders;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.Rectangle;

public class Button {

	private Rectangle rect;
	private Sprite sprite;
	private boolean activated;

	public Button(Sprite sprite) { 
		this.sprite = sprite; 
		this.setActivated(false);
		this.rect = new Rectangle(sprite.getxPos(), sprite.getyPos(), (int)sprite.getxRes(), (int)sprite.getyRes());
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public boolean MakeButt() {
		if(rect.contains(Mouse.getX(), (540-Mouse.getY()))) {
			return true;
		}else {
			return false;
		}
	}
	
}