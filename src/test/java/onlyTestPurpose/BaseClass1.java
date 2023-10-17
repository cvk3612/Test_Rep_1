package onlyTestPurpose;

class BaseClass1 {
	
	public static String variableStr = "";
	
	public void myTestMethod(String str, int i) {
		System.out.println("Accepting string - in Base class");
	}
	
	public void myTestMethod(int i, String str) {
		System.out.println("Accepting string - in base class");
	}
	
	protected void myTestMethod(int i, String str, boolean flag) {
		System.out.println("Accepting string");
	}
	
	private boolean myTestMethod(int i, String str, boolean flag, String str1) {
		boolean test = true;
		variableStr = str;
		System.out.println("Accepting string");
		return test;
	}

}
