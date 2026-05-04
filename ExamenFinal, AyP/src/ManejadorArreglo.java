/*
 * Mely Delgado 
 * O2023
 * Clase para practicar arreglos genéricos para el final.
 */
public class ManejadorArreglo {
	
	public static int ejercicio1(int a[], int b[], int n) {
		int ocupados=n;
		
		for(int i=0; i<n; i++) {
			if(a[i]%b[i]==0 || b[i]%a[i]==0) {
				for(int j=0; j<n-1; j++) {
					a[j]= a[j+1];
					b[j]= b[j+1];
				}
				ocupados--;
				i--;
			}
		}
		return ocupados;
	}

}
