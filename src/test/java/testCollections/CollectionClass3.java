package testCollections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.google.common.collect.Ordering;

     class CollectionClass3 {

	public static void main(String[] args) {
		Set<String> mySet = new TreeSet<String>();
		
		mySet.add("Red");
		mySet.add("Orange");
		mySet.add("Green");
		mySet.add("Apple");
		mySet.add("Zion");
		mySet.add("Kite");
		
		System.out.println(mySet.add("Zion"));
		
		System.out.println(mySet);
		
        boolean isSortedList = Ordering.natural().isStrictlyOrdered(mySet);
		
		System.out.println(isSortedList);

	}

}
