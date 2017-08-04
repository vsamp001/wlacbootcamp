/*
 Modify the MyList class that you wrote for Programming Challenge 1 so the type parameter 
 T should accept any type that implements the Comparable interface. Test the class in a 
 program that creates one instance of MyList to store Integers, and another instance to store Strings.
 */
import java.util.*;
public class MyList2 <T extends Comparable<T>>{
	ArrayList<T> arrList = new ArrayList<T>();
	public void add(T num){
		arrList.add(num);
	}
	public T largest(){
		T large = arrList.get(0);
		for (int i = 1 ; i < arrList.size(); i++){
		//	int test = arrList.get(i).compareTo(large);
			//System.out.println("Check if " + arrList.get(i) + " is greater than " + large + " "+ test);
			if(((Comparable<T>) arrList.get(i)).compareTo(large) > 0)
				large = arrList.get(i);
		}
		return large;
	}
	public T smallest(){
		T small = arrList.get(0);
		for (int i = 1; i < arrList.size() ; i++){
			if(((Comparable<T>) arrList.get(i)).compareTo(small) < 0)
				small = arrList.get(i);
		}
		return small;
	}
	public void display(){
		System.out.println(arrList);
	}

}
