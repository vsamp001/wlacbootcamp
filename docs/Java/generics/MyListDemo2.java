
public class MyListDemo2 {
	public static void main(String[] args){
		MyList2<Integer> list2 = new MyList2<Integer>();
		MyList2<String>	list3 = new MyList2<String>();
		list2.add(3);
		list2.add(5);
		list2.add(5);
		list2.add(4);
		list2.add(1);
		list2.add(2);
		list2.add(2);
		list3.add("John");
		list3.add("Bobby");
		list3.add("Smith");
		list3.add("Margaret");
		list3.add("1alan");
		System.out.println("Integers in the ArrayList are: ");
		list2.display();
		Integer largest = list2.largest();
		System.out.println("The largest value: " + largest);
		Integer smallest = list2.smallest();
		System.out.println("The smallest value: " + smallest);
		System.out.println("\nStrings in the ArrayList are: ");
		list3.display();
		String largest2 = list3.largest();
		System.out.println("The largest: " + largest2);
		String smallest2 = list3.smallest();
		System.out.println("The smallest: " + smallest2);
		
	}
}
