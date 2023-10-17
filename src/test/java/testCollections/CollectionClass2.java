package testCollections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import com.google.common.collect.Ordering;

public class CollectionClass2 {
	
	public static void main(String[] args) {
		List<String> myList = new Vector<String>();
		myList.add("Red");
		myList.add("Apple");
		myList.add(null);
		myList.add("Green");
		myList.add("Blue");
		myList.add(null);
		myList.add("Violet");
		myList.add("Tetra");
		
		boolean isSortedList = Ordering.natural().isOrdered(myList);
		
		System.out.println(isSortedList);
		
		
		
		System.out.println(myList);
	}
	
	public void test111(String str) throws InterruptedException {
		Thread.sleep(1000);
	}

}
