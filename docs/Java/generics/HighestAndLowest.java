//Write a generic class with a type parameter constrained to any type that implements 
//Comparable. The constructor should accept an array of such objects. The class 
//should have methods that return the highest and lowest values in the array. 
//Demonstrate the class in an application.

 
public class HighestAndLowest<T extends Comparable<T>>{
	T[] array;
	//constructor
	public HighestAndLowest(T[] arr){
		array = arr;
	}
	//highest method returns the highest value
	public T highest(){
		T high = array[0];
		for (int i = 1 ; i < array.length; i++){
			if(high.compareTo(array[i])< 0){
				high = array[i];
			}
		}
		return high;
	}
	public T lowest(){
		T low = array[0];
		for (int i  = 1; i < array.length; i++){
			if (low.compareTo(array[i]) > 0){
				low = array[i];
			}
		}
		return low;
	}

}
