import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class CourseBag implements Serializable{

	private static final long serialVersionUID = 1L;
	List<Courses> courses;
	String result;
	public CourseBag() {
		courses = new ArrayList<>();
		result = "";
	}
	
	public void add(Courses course) {courses.add(course);}
	
	public String display() {
		for (Courses c: courses)
			result += c.toString() + "\n";
		return result;
	}
	
	public Courses find(Integer CRN) {
		for (Courses c: courses)
			if (CRN.equals(c.getCRN()))
				return c;
		return null;
	}
	
	public boolean delete(Integer CRN) {
		for (Courses c: courses)
			if (CRN.equals(c.getCRN())){
				courses.remove(c);
				return true;
			}
		return false;
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
		CourseBag result = (CourseBag) ois.readObject();
		this.courses = result.courses;
		ois.close();
	}

}
