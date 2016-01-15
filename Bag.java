import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Bag implements Serializable{

	private static final long serialVersionUID = 1L;
	PeopleBag pBag;
	CourseBag cBag;
	TextBookBag tBag;
	public Bag(PeopleBag pBag, CourseBag cBag, TextBookBag tBag) {
		this.pBag = pBag;
		this.cBag = cBag;
		this.tBag = tBag;
	}
	
	public PeopleBag getpBag() {
		return pBag;
	}

	public void setpBag(PeopleBag pBag) {
		this.pBag = pBag;
	}

	public CourseBag getcBag() {
		return cBag;
	}

	public void setcBag(CourseBag cBag) {
		this.cBag = cBag;
	}

	public TextBookBag gettBag() {
		return tBag;
	}

	public void settBag(TextBookBag tBag) {
		this.tBag = tBag;
	}

	public void save(String name) throws IOException {
		// write object to file
		FileOutputStream fos = new FileOutputStream(name);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.close();
	}
	
	public void load(String name) throws IOException, ClassNotFoundException {
		// read object from file
		FileInputStream fis = new FileInputStream(name);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Bag result = (Bag) ois.readObject();
		this.pBag = result.pBag;
		this.cBag = result.cBag;
		this.tBag = result.tBag; 
		ois.close();
	}
	
}
