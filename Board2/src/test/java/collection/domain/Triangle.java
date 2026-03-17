package collection.domain;

public class Triangle {
	public static void main(String[] args) {
		for(int i=0; i<5; i++) {
			for (int k=0; k<5-1; k++) {
				System.out.println(" ");

			}				
			for(int j=1; j<=2*i+1; j++) { 
				System.out.print("*");
				}		
		
			System.out.println("");
		}
	}
	
}
