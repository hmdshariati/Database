import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PeopleBag implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Person> personList;
	List<Student> studentList;
	List<Faculty> facultyList;
	private String result;	//	return value of Display
	
	public PeopleBag() {
        personList = new ArrayList<>();
        studentList = new ArrayList<>();
        facultyList = new ArrayList<>();
        result = "";
    }
	
	public void add(Person person) {personList.add(person);}
	public void add(Student student) {studentList.add(student);}
	public void add(Faculty faculty) {facultyList.add(faculty);}
	
	public String display() {
		//	Person
		result += "Person\n";
		for (Person p: personList) 
			result += p.toString() + "\n";
		//	Students
		result += "\nStudent\n";
		for (Student s: studentList) 
			result += s.toString() + "\n"; 
		//	Faculty
		result += "\nFaculty\n";
		for (Faculty f: facultyList) 
			result += f.toString() + "\n";
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T find(Integer id) {
		for (Person p: personList) {
			if (id.equals(p.getID())){
				return (T)p;
			}
		}
		
		for (Student s: studentList) {
			if (id.equals(s.getID()))
				return (T)s;
		}
		
		for (Faculty f: facultyList) {
			if (id.equals(f.getID()))
				return (T)f;
		}
		
		return null;
	}
	
	public boolean delete(Integer id) {
		for (Person p: personList) {
			if (id.equals(p.getID())){
				personList.remove(p);
				return true;
			}
		}
		
		for (Student s: studentList) {
			if (id.equals(s.getID())){
				studentList.remove(s);
				return true;
			}
		}
		
		for (Faculty f: facultyList) {
			if (id.equals(f.getID())){
				facultyList.remove(f);
				return true;
			}
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
		PeopleBag result = (PeopleBag) ois.readObject();
		this.personList = result.personList;
		this.studentList = result.studentList;
		this.facultyList = result.facultyList; 
		ois.close();
	}
	
	
	
	
}
