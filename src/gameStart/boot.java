package gameStart;

public class boot {
	/**
	 * Launches the game loop.
	 * @param args - Arguments for main.
	 */
	public static void main(String[] args) { 
		dev.DevConsole.beginDevConsole();
		new FrameLoop();
		
	}
	
}