import java.io.Serializable;
import java.util.List;

public class Courses implements Serializable{

	private static final long serialVersionUID = 1L;
	private String title;
	private String room;
	private String number;
	private Integer CRN;
	private Integer credits;
	private TextBook textBook;
	private Faculty faculty;
	List<Student> roster;
	public Courses(String title, String room, String number, Integer cRN,
			Integer credits, TextBook textBook, Faculty faculty,
			List<Student> roster) {

		this.title = title;
		this.room = room;
		this.number = number;
		this.CRN = cRN;
		this.credits = credits;
		this.textBook = textBook;
		this.faculty = faculty;
		this.roster = roster;
	}
	public Courses(String title){this.title = title;}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Integer getCRN() {
		return CRN;
	}
	public void setCRN(Integer cRN) {
		CRN = cRN;
	}
	public Integer getCredits() {
		return credits;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	public TextBook getTextBook() {
		return textBook;
	}
	public void setTextBook(TextBook textBook) {
		this.textBook = textBook;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public List<Student> getRoster() {
		return roster;
	}
	public void setRoster(List<Student> roster) {
		this.roster = roster;
	}
	@Override
	public String toString() {
		return "Course [title=" + title + ", room=" + room + ", number="
				+ number + ", CRN=" + CRN + ", credits=" + credits
				+ ", textBook=" + textBook + ", faculty=" + faculty
				+ ", roster=" + roster + "]";
	}

}
