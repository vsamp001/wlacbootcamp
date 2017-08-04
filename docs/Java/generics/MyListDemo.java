
public class MyListDemo {
	public static void main(String[] args){
		MyList<Number> list = new MyList<Number>();
		//call add method
		list.add(2);
		list.add(-2);
		list.add(1);
		list.add(6);
		list.add(20);
		list.add(3);
		list.add(30);
		list.add(14);
		list.add(5);
		list.add(-3);
		System.out.println("Numbers in ArrayList: ");
		list.display();
		Number largest = list.largest();
		System.out.println("The largest value in ArrayList: " + largest);
		Number smallest = list.smallest();
		System.out.println("The smallest value in ArrayList: " + smallest);
	}
}
