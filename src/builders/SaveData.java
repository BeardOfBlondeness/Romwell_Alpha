package builders;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SaveData implements java.io.Serializable {

	private String saveName;

	public SaveData(String saveName) {
		this.setSaveName(saveName);
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public void saveGame() {
		try (
				OutputStream file = new FileOutputStream("saves/" + this.saveName + ".Rwell");
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
