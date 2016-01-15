
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TextBookBag implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<TextBook> books;
	private String result;
	private int size;
	public TextBookBag() {
		this.books = new ArrayList<>();
		result = "";
		size = 0;
	}
	
	public void add(TextBook book) {books.add(book); size++;}
	
	public String display() {
		for (TextBook b: books)
			result += b.toString() +"\n";
		return result;
	}
	
	public TextBook find(Integer ISBN) {
		for (TextBook b: books){
			if (ISBN.equals(b.getISBN()))
				return b;
		}
	return null;
	}
	
	public boolean delete(Integer ISBN) {
		for (TextBook b: books)
			if (ISBN.equals(b.getISBN())){
				books.remove(b);
				size--;
				return true;
			}
		return false;
	}
	
	public int size() {return size;}
	
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
		TextBookBag result = (TextBookBag) ois.readObject();
		this.books = result.books;
		ois.close();
	}


}
