import java.io.*;
import java.util.*;
import javax.swing.*;
@SuppressWarnings("unused")
public class TraceGenealogies {
	public static void main(String [] args) throws IOException
	{
		Map<String, List<String>> list = loadList();
		//display(list);
		Scanner keyboard = new Scanner(System.in);
  	   	String parent;
  	   	String kid;
  	   	System.out.print("Enter parent name: ");
  	   	parent = keyboard.nextLine();
  	   	System.out.print("Enter child name: ");
  	   	kid = keyboard.nextLine();
  	   	try{
	  	   	List<String> genealogy = findTrace(parent, kid, list);
	  		if(genealogy.isEmpty()){
	  	   		System.out.println(kid + " is not a descendant of " + parent + ".");
	  	   	} else{
	  	   		for (int i = 0; i < genealogy.size(); i ++){
	  	   	    System.out.print(genealogy.get(i));
	  	   	    	if(i < (genealogy.size()-1)){
	  	   	    		System.out.print(" -> ");
	  	   	    	}
	  	   		}
	  	   	}
  	   	} catch (Exception e){
  	   		System.out.println(kid + " is not a descendant of " + parent + ", because they are not in the list.");
  	   	}
  	   
  	   	
  	   	keyboard.close();
	}
	private static Map<String, List<String>> loadList() throws IOException {
		File file = new File ("family.txt");
		Scanner scan = new Scanner(file);
		int entries = scan.nextInt();
		Map<String, List<String>> list  = new HashMap<String, List<String>>();
		scan.nextLine();
		for (int i = 0 ; i < entries; i++){
			String name;
			int numOfKids;
			List<String> kids = new ArrayList<String>();
			name = scan.next();
			numOfKids = scan.nextInt();
			for (int j = 0; j < numOfKids; j++){
				kids.add(scan.next());
			}
			list.put(name, kids);
			if (scan.hasNextLine()) scan.nextLine();
		}
		scan.close();
		return list;
	}
	
	private static void display(Map<String,List<String>> map) {
		Set <String> keys = map.keySet();
		for ( String key : keys){
			System.out.println(key +" -> " +  map.get(key));
		}
	}
	private static List<String> findTrace(String name1, String name2, Map<String, List<String>> list) throws NullPointerException {
		Stack<String> stack = new Stack<String>();
		Map<String, Iterator<String>> iterate = new HashMap<String, Iterator<String>>();
		Set<String> names = list.keySet();
		for (String name: names){
			iterate.put(name, list.get(name).iterator());
		}
		stack.push(name1);
		while(!stack.empty()){
			String topName = stack.peek();
			if(topName.equals(name2))
				return stack;
			Iterator<String> topNameIterator = iterate.get(topName);
			if(!topNameIterator.hasNext()){
				stack.pop();
				continue;
			}
			stack.push(topNameIterator.next());
		}
		return stack;
	}
}
