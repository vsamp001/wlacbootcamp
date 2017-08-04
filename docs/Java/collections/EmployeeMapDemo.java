import java.util.*;

public class EmployeeMapDemo {
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		EmployeeMap employeeMap = new EmployeeMap();
		
		Employee employ1 = new Employee("Gaara", 1234);
		Employee employ2 = new Employee("Boruto", 1236);
		Employee employ3 = new Employee("Sasuke", 2312);
		Employee employ4 = new Employee("Sakura", 5643);
		employeeMap.add(employ1);
		employeeMap.add(employ2);
		employeeMap.add(employ3);
		employeeMap.add(employ4);
		System.out.println("Enter the Employee ID:");
		int id = keyboard.nextInt();
		String name = employeeMap.lookUp(id);
		if (name == null){
			System.out.println("Employee ID "+ id + " not found in the map.");
		} else {
			System.out.println(name + " is the employee with ID " + id );
		}	
					
		keyboard.close();
	}
}