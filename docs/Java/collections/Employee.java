
public class Employee {
	private String name;
	private int ID;
	Employee(){
		name = "";
		ID = 0;
	}
	Employee(String n, int id){
		name = n;
		ID = id;
	}
	int getID(){
		return ID;
	}
	String getName(){
		return name;
	}
	public String toString(){
		return "Name: " + name  + "\tID: " + ID;
	}
	
}
