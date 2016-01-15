import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Student extends Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	Data Field
	private Double gpa;
	private String major;
	private Integer credits;
	List<Courses> courses;
	List<Courses> inProgress;
	List<Courses> remaining;
	
	// Constructor
	public Student(String fName, String lName, Integer id, Integer phone,
			String home) {
		super(fName, lName, id, phone, home);
		courses = new ArrayList<>();
		inProgress = new ArrayList<>();
		remaining = new ArrayList<> ();
	}
	
	//	getters and setters
	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		String temp = super.toString();
		
		return "Student [" +temp.substring(8, temp.length()-1) +"," + " gpa=" + gpa + ", major=" + major + ", credits="
				+ credits + ", courses=" + courses + ", inProgress="
				+ inProgress + ", remaining=" + remaining + "]";
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

	public List<Courses> getInProgress() {
		return inProgress;
	}

	public void setInProgress(List<Courses> inProgress) {
		this.inProgress = inProgress;
	}

	public List<Courses> getRemaining() {
		return remaining;
	}

	public void setRemaining(List<Courses> remaining) {
		this.remaining = remaining;
	}

	
	
	
}
