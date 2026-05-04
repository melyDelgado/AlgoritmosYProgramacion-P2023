import java.util.Scanner;

public class PruebaManejadorArreglos {
	
	public static void leeArreglo(int a[], int n) {
		int i;
		Scanner lector = new Scanner(System.in);
		
		for(i = 0; i  < n; i++) {
			System.out.println("Dame el elemento " + i + ": \n");
			a[i] = lector.nextInt();
		}
		
	}
	
	public static void imprimeArreglo(int a[], int n) {
		int i;
		for(i = 0; i  < n; i++)
			System.out.print(a[i] + "  ");
}

	public static void main(String[] args) {
		int b[]= new int[5];
		leeArreglo(b,5);
		int a[] = new int[5];
		leeArreglo(a, 5);
		int n;
		
		n= ManejadorArreglo.ejercicio1(a, b, 5);
		System.out.println(n);
	}

}
