import java.io.Serializable;


public class Faculty extends Person implements Serializable{

	private static final long serialVersionUID = 1L;
	public Faculty(String fName, String lName, Integer id, Integer phone,
			String home) {
		super(fName, lName, id, phone, home);
	}
    public Faculty(String lName) {super(lName);}
    
    //	Data field
	private String officeAdd;
    private String title;
    private  String department;
    private Integer payScale;
    
    //	Getters and Setters
	public String getOfficeAdd() {
		return officeAdd;
	}
	public void setOfficeAdd(String officeAdd) {
		this.officeAdd = officeAdd;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getPayScale() {
		return payScale;
	}
	public void setPayScale(int payScale) {
		//	Must be between 1 and 12
		if (payScale>0 && payScale<13)
			this.payScale = payScale;
	}
	@Override
	public String toString() {
		String temp = super.toString();
		return "Faculty [" +temp.substring(8, temp.length()-1) +", " +"office=" + officeAdd + ", title=" + title
				+ ", department=" + department + ", payScale=" + payScale + "]";
	}

}
