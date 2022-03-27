package bai1TableTH2_TranThiMinhHuyen_34_20105231;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LuuTru {
	public boolean LuuFile(Object obj, String filePath) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = null;
		oos = new ObjectOutputStream(new FileOutputStream(filePath));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
		return false;
	}
	public Object DocFile(String filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream( new FileInputStream(filePath));
		Object o = ois.readObject();
		ois.close();
		return o;
	}
}
