
public class Instructor <T extends Comparable<T>>{
	private String lastName;
	private String firstName;
	private String officeNumber;
	public Instructor(String lname, String fname, String office){
		lastName = lname;
		firstName = fname;
		officeNumber = office;
	}
	public Instructor(Instructor<T> ins){
		lastName = ins.lastName;
		firstName = ins.firstName;
		officeNumber = ins.officeNumber;
	}
	public void set(String lname, String fname, String office){
		lastName = lname;
		firstName = fname;
		officeNumber = office;
	}
	public int hashCode(){
		return officeNumber.hashCode();
	}
	public boolean equals(Object obj){
		if (obj != null && obj instanceof Instructor){
			@SuppressWarnings("unchecked")
			Instructor<T> obj2 = (Instructor<T>)obj;
			Instructor<T> tempins = obj2;
			if(hashCode() == tempins.hashCode())
				return true;
			else
				return false;
		} else 
			return false;
	}
	public String getLastName(){
		return lastName;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getOffice(){
		return officeNumber;
	}
	public String toString(){
		return "Name: " + getFirstName() + " " + getLastName() + "\tOffice Number: " + getOffice();
	}
}
