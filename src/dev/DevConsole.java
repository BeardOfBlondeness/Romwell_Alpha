package dev;

import java.util.Scanner;

public class DevConsole {

	static Scanner sc;
	public static void beginDevConsole() {
		Thread thread = new Thread(){
		    public void run(){
		    	sc = new Scanner(System.in);
		      while(true) {
		    	  checkCommands();
		      }
		    }
		  };

		  thread.start();
	}
	
	@SuppressWarnings("static-access")
	public static void checkCommands() {

        String i = sc.nextLine();
        
        if(i.equals("setup")) {
        	gameStart.FrameLoop.gs.setStance("newGame");
        	try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	gameStart.FrameLoop.gs.getTitleSequence().getTitleSprite().setFadeFinish(true);
        }else {
        	
        }
        
	}
}
