package testCollections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import com.google.common.collect.Ordering;

public class CollectionClass1 {

	public static void main(String[] args) {
		
		Map<String, String> myMap = new TreeMap<String, String>();
		myMap.put("Color", "Red");
		myMap.put("Shape", "Sqaure");
		myMap.put("Test", null);
		myMap.put("Dimensions", "2D");
		myMap.put("Root", null);
		System.out.println(myMap);
		
		Map<String, String> myMapNew = new TreeMap<String, String>();
		myMapNew.put("Vehicle", "Car");
		myMapNew.put("EngineType", "Gas");
		//myMap.put(null, null);
		myMapNew.put("Model", "Top end");
		
		myMap.putAll(myMapNew);
		
		System.out.println(myMap);
		
		System.out.println(myMap.put("Color", "Green"));
		
		System.out.println(myMap.get("EngineType"));
		
		System.out.println(myMap.remove("EngineType"));
		System.out.println(myMap);
		

	}

}
