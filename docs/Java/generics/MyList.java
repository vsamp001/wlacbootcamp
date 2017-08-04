/*
	Write a generic class name MyList, with a type parameter T. The type parameter
	T should be constrained to an upper bound: the Number class. The class should have
	as a field an ArrayList of T. Write a public method named add, which accepts a 
	parameter of type T. When an argument is passed to the method, it is added to the 
	ArrayList. Write two other methods, largest and smallest, which return the largest
	and smallest values in the ArrayList.
 */
import java.util.*;
public class MyList <T extends Number >{
	//create ArrayList object of type T
	ArrayList<T> arrList = new ArrayList<T>();
	/*
	Write a public method named add, which accepts a 
	parameter of type T. When an argument is passed to the method, it is added to the 
	ArrayList.
	*/
	public void add(T num){
		arrList.add(num);
	}
	/*
	 largest and smallest, which return the largest
		and smallest values in the ArrayList.
	 */
	public T largest(){
		T large = arrList.get(0);
		for(int i = 0; i < arrList.size(); i++){
			//System.out.println(large  + " " + arrList.get(i));
			if(arrList.get(i).doubleValue() > large.doubleValue())
				large = arrList.get(i);
		//	System.out.println(arrList.get(i));
		}
		return large;
	}
	public T smallest() {
		T small = arrList.get(0);
		for (int i = 0; i < arrList.size(); i++){
			if (arrList.get(i).doubleValue() < small.doubleValue())
					small = arrList.get(i);
		}
		return small;
	}
	public void display(){
		System.out.println(arrList);
	}

}
