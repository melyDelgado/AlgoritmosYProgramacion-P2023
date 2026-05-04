import java.util.ArrayList;
import java.util.Scanner;

public class PruebaManejadorArreglos {
	
	public static void leeArreglo(int a[], int n) {
		int i;
		Scanner lector = new Scanner(System.in);
		
		for(i = 0; i<n; i++) {
			System.out.println("Dame el elemento " + i + ": \n");
			a[i] = lector.nextInt();
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> resp;
		
		int nums[]= new int[5];
		leeArreglo(nums, 5);
		
	}

}
