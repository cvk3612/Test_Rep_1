package testsScripts;



import java.util.HashMap;

import org.testng.annotations.Test;

import methods.Keywords;

public class Test1 extends ClassTest{
	
	public static void main(String[] args) {
		String s = "key1:val1";
		HashMap<String, String> hm = new HashMap<String, String>();
		hm = createInput(s);
		System.out.println(hm);
		
		
	}
	
	public static HashMap<String, String> createInput(String str) {
		
		HashMap<String, String> hm = new HashMap<String, String>();
		String [] splitstr = str.split(";");
		for(int i = 0; i<=splitstr.length-1; i++) {
			String currentP = splitstr[i];
			String[] splisplit = currentP.split(":");
			hm.put(splisplit[0], splisplit[1]);
		}
		
		return hm;
	}
	
	public void myTestInput(String str, int inte) {
		System.out.println("takes string and integer and flag");
	}
	
	public String setCustomerType(int id) {
		int custID = id;
		String custType = "";
		
		switch (custID) {
		case 1:
		{
			custType = "Standard";
			break;
		}
		
		case 2:
		{
			custType = "Premium";
			break;
		}
		
		case 3:
		{
			custType = "Comprehensive";
			break;
		}
		
		default:
		{
			custType = "Minimum";
			break;
		}
		}
		
		
		
		return custType;
	}

}
