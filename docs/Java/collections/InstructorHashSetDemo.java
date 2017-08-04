import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
/*
 	Chapter 8 presented an Instructor class that holds information about an instructor. Modify the 
 	Instructor Class by overriding the hashCose and equals methods. Then write a class that stores 
 	several Instructor objects in a HashSet. The class should be able to display all the Instructors
 	in the set, and allow the user to search for an instructor. Demonstrate the class in an application. 
 */
public class InstructorHashSetDemo {
	public static void main(String[] args){
		Scanner keyboard =  new Scanner(System.in);
		boolean isfound = false;
		Set<Instructor<String>> instructorSet = new HashSet<Instructor<String>>();
		instructorSet.add(new Instructor<String>("Kent", "Clark", "CE-123"));
		instructorSet.add(new Instructor<String>("Prince", "Diana", "CE-124"));
		instructorSet.add(new Instructor<String>("Wayne", "Bruce", "CE-125"));
		instructorSet.add(new Instructor<String>("Allen", "Barry", "CE-126"));
		instructorSet.add(new Instructor<String>("Curry", "Arthur", "CE-127"));
		instructorSet.add(new Instructor<String>("Lance", "Dinah", "CE-128"));
		instructorSet.add(new Instructor<String>("Gordon", "Barbara", "CE-129"));
		instructorSet.add(new Instructor<String>("Grayson", "Dick", "CE-130"));
		instructorSet.add(new Instructor<String>("Curry", "Arthur", "CE-127"));
		System.out.println("Instructors in the set:");
		for (Instructor<String> ins:instructorSet){
			System.out.println(ins.toString());
		}
		System.out.println("Search for Instructor");
		System.out.println("Enter first name:");
		String first = keyboard.next();
		System.out.println("Enter last name:");
		String last = keyboard.next();
		System.out.println("Enter office number:");
		String office = keyboard.next();	
		Instructor<String> newIns = new Instructor<String>(last, first, office);
		Iterator<Instructor<String>> itr = instructorSet.iterator();
		while(itr.hasNext())
			if (newIns.equals(itr.next()))
				isfound=true;
		if(isfound)
			System.out.println("Instructor Found");
		else 
			System.out.println("Instructor NOT Found");
		keyboard.close();
	}
}
