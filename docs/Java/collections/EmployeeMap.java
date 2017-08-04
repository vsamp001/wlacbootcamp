import java.util.SortedMap;
import java.util.TreeMap;
/*
  Create an Employee class that stores an employee's ID number and name. Then create an 
  EmployeeMap class that allows you to add Employee objects and look them up by their ID
  Numbers. The EmployeeMap class should use a Map object to map ID numbers to Employee objects.
  Create an application to demonstrate the classes.
 */
public class EmployeeMap {
	private SortedMap<Integer, String> map = new TreeMap<Integer, String>();
	public void add(Employee employee){
		map.put(employee.getID(), employee.getName());
	}
	public String lookUp(int id){
		return map.get(id);
	}
}
