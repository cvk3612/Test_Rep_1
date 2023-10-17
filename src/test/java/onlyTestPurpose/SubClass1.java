package onlyTestPurpose;

 public class SubClass1 extends BaseClass1 {
	
	public void myTestMethod(String str, int i) {
		System.out.println("Accepting string - in Sub class");
	}
	
	private boolean myTestMethod(int i, String str, boolean flag, String str1) {
		boolean test = true;
		variableStr = str;
		System.out.println("Accepting string");
		return test;
	}

}
