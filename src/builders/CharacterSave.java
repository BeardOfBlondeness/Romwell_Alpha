package builders;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class CharacterSave implements java.io.Serializable {
	private String name;
	private String gameStance;
	private int level;
	
	public CharacterSave(int[] name, int nameLength) {
		this.name = convertString(name, nameLength);
		this.gameStance = "beginning";
		this.level = 0;
	}
	
	public String convertString(int[] name, int nameLength) {
		String chara = "";
		int asciiVal;
		asciiVal = name[0] + 65;
		chara = chara + Character.toString((char) asciiVal);
		
		for(int i = 1; i < nameLength; i++) {
			asciiVal = (name[i]) + 97;
			chara = chara + Character.toString((char) asciiVal);
		}
		return chara;
	}
	
	public void saveGame() {
		try (
				OutputStream file = new FileOutputStream("saves/" + this.name + ".Rwell");
				OutputStream buffer = new BufferedOutputStream(file);
				ObjectOutput output = new ObjectOutputStream(buffer);
				){
			output.writeObject(this);
		}  
		catch(IOException ex){
			System.out.println("Cannot perform output." + ex);
		}
	}
}
