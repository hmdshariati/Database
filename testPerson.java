import java.io.IOException;


public class testPerson {
	public static void main(String[] args) throws IOException, ClassNotFoundException  {
		Person sho = new Person("sho","mon",1,347,"24 s Howell");
		Student boho = new Student("boho","mon",2,347,"24 s Howell");
		Faculty uncle = new Faculty("uncle","bhai",3,347,"24 s Howell");
		PeopleBag bag = new PeopleBag();
		bag.add(uncle);
		bag.add(boho);
		bag.add(sho);
		bag.save("familyBag.ser");
		PeopleBag famBag = new PeopleBag();
		famBag.load("familyBag.ser");
		System.out.println(famBag.find(2).toString());
	}
	
	
}
