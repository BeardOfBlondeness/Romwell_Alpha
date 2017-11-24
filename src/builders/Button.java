package builders;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.Rectangle;

import gameStart.FrameLoop;

public class Button {

	private Rectangle rect;
	private Sprite sprite;
	private boolean activated;

	private boolean clicked;
	public Button(Sprite sprite) { 
		this.sprite = sprite; 
		this.setActivated(false);
		this.rect = new Rectangle(sprite.getxPos(), sprite.getyPos(), (int)sprite.getxRes(), (int)sprite.getyRes());
		this.clicked = false;
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

	public boolean makeButt() {
		if(rect.contains(Mouse.getX(), (540-Mouse.getY()))) {
			return true;
		}else {
			return false;
		}
	}

	public boolean isClicked() {
		try {
			return clicked;
		} finally {
			clicked = false;
		}
	}

	private boolean down = false;

	public void addListener(int item, String key, boolean shrink) {
		if(item == 0) {
			if(key.equals("LeftRelease")) {
				if(Mouse.isButtonDown(0)) {
					System.out.println("mouse down");
					if(shrink) {
						sprite.setxRes((float)(210));
						sprite.setyRes((float)53);
					}
					down = true;
				}
				while(Mouse.next()) {
					if(Mouse.isButtonDown(0)) {
						System.out.println("mouse down");
						this.down = true;
					}else if(down) {
						System.out.println("Mouse has been pressed");
						this.clicked = true;
						this.down = false;		
					}
				}
			}
		}
	}
}