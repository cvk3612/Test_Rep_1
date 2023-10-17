package onlyTestPurpose;

public class ThirdPartyClass1 {
	
	public static void main(String[] args) {
		
		int[] arr = {7,5,6,4};
		
		for(int i = 0; i<arr.length; i++) {
			for(int j = i+1; j<=arr.length; j++) {
				if(arr[i] < arr[j] || arr[i] == arr[j]) {
					continue;
				}
				
				else if(arr[i] > arr[j]) {
					int temp = arr[i];
					
				}
			}
		}
	
	
	}
}
