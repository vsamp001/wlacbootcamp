
public class HighestAndLowestDemo {
	public static void main(String[] args){
		Integer[] integers = {3,1,4,2,5,6,-2};
		String[] strings = {"David", "Mike", "Jasmine", "Katherine", "Joe", "Wallace"};
		HighestAndLowest<Integer> test1 = new HighestAndLowest<Integer>(integers);
		HighestAndLowest<String> test2 = new HighestAndLowest<String>(strings);
		System.out.print("Array 1:");
		for (int i = 0 ; i < integers.length; i++){
			System.out.print(" " + integers[i]);
		}
		Integer intHigh = test1.highest();
		System.out.println("\nHighest: " + intHigh);
		Integer intLow = test1.lowest();
		System.out.println("Lowest: " + intLow);
		
		System.out.print("Array 2:");
		for (int i = 0 ; i < strings.length; i++){
			System.out.print(" " + strings[i]);
		}
		String stringHigh = test2.highest();
		System.out.println("\nHighest: " + stringHigh);
		String stringLow = test2.lowest();
		System.out.println("Lowest: " + stringLow);
	}
}
