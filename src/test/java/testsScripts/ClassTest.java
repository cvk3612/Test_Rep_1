package testsScripts;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import testCollections.CollectionClass2;

 class ClassTest extends CollectionClass2{
	
	public static void main(String[] args){
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss");
		Date d = new Date();
		String strDate = df.format(d);
		String folderPath = "TestReports//" + strDate + "//ExtReport.html";
		File reportFolder = new File(folderPath);
		reportFolder.getParentFile().mkdir();
		try {
			reportFolder.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void myTestInput(String str, int inte) throws Exception{
		System.out.println("takes string and integer");
	}
    
	public void myTestInput(String str, int inte, char c) throws Exception{
		if(c=='a') {
			System.out.println("Flag is true");
		}
		System.out.println("takes string and integer");
		
		System.out.println("Also will be used for calculations");
		
		System.out.println("New line added");
	}

}
