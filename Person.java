import java.io.Serializable;


public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fName;
	private String lName;
	private Integer id;
	private Integer phone;
	private String home;
	
	public Person(String fName, String lName, Integer id, Integer phone, String home){
		this.fName = fName;
		this.lName = lName;
		this.id = id;
		this.phone = phone;
		this.home = home;
	}
	public Person(String lName) {this.lName = lName;}
	
	//	Getters
	public String getfName() {return this.fName; }
	public String getlName() {return this.lName; }
	public Integer getID() {return this.id;}
	public Integer getPhone() {return this.phone;}
	public String getHome() {return this.home;}
	
	//	Setters
	public void setFName(String name) {this.fName = name;}
	public void setLName(String name) {this.lName = name;}
	public void setID(Integer id) {this.id = id;}
	public void setPhone(Integer phone) {this.phone = phone;}
	public void setHome(String home) {this.home = home;}

	@Override
	public String toString() {
		return "Person [fName=" + fName + ", lName=" + lName + ", id=" + id
				+ ", phone=" + phone + ", home=" + home + "]";
	}

}
