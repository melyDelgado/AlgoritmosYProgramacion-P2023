import java.util.ArrayList;

/*
 * Clase para crear métodos de arreglos genéricos, para ser más eficientes en nuestro proyecto "Fantasy"
 */
public class ManejadorArreglosGenericos {
	
	public static <T extends Comparable<T>> int posMayor(T a[],int n) {
		int pos=0;
		T max= a[0];
		
		for(int i=0; i<n; i++) 
			if (a[i].compareTo(max) > 0) {
				max = a[i];
				pos = i;
			}
		return pos;	
	}
	
	public static <T extends Comparable<T>> int cuantosMayX(T a[], int n, T x) {
		int cuantos=0;

		for(int i=0;i<n;i++)
			if(a[i].compareTo(x)>0)
				cuantos++;
		return cuantos;
	}
	
	public static <T extends Comparable<T>> int cuantosMenX(T a[], int n, T x) {
		int cuantos=0;

		for(int i=0;i<n;i++)
			if(a[i].compareTo(x)<0)
				cuantos++;
		return cuantos;
	}
	
	public static <T extends Comparable<T>> ArrayList<Integer> cualesMayX(T a[], int n, T x) {
		int cuantos=0; 
		ArrayList<Integer>lista= new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
			if(a[i].compareTo(x)>0)
				lista.add(i);
		return lista;
	}
	
	public static <T extends Comparable<T>> ArrayList<Integer> cualesMenX(T a[], int n, T x) {
		int cuantos=0; 
		ArrayList<Integer>lista= new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
			if(a[i].compareTo(x)<0)
				lista.add(i);
		return lista;
	}
	
	public static <T> void swap(T a[], int i, int j) {
		T pos= a[i];
		
		a[i]= a[j];
		a[j]= pos;
	}
	
	public static <T> void invierte(T a[], int n) {
		int m=n/2;
		T aux;
		
		for(int i=0; i<m; i++) {
			aux=a[i];
			a[i]=a[n-1-i];
			a[n-1-i]=aux;	
		}
	}

	public static <T extends Comparable<T>> int posMenor(T a[],int n) {
		int pos=0;
		T min= a[0];
		
		for(int i = 0; i<n; i++) {
			if (a[i].compareTo(min) < 0) {
				min = a[i];
				pos = i;
			}
		}
		return pos;		
	}
	
	public static <T extends Comparable<T>> int buscaSecuencialOrdenada (T a[], int n, T v) {
		int i=0, resp;
		
		while(i<n && !a[i].equals(v))
			i++;
		if(i<n)
			resp=i;
		else
			resp=-1;
		return resp;
	}
	
	public static <T> int busquedaSecuencialDesordenada (T[] a, int n, T x) {
		int i=0, pos = -1;
		
		while(i<n && a[i]!=x ) {	
			i++;
		}
		if(i==n)
			pos=-1;
		else 
			pos= i;
		return pos;
	}
	
	public static <T extends Comparable <T>> int buscaBinaria(T a[], int n, T v) {
		int inicio=0, fin=n-1, mitad=(inicio + fin)/2, r;
		
		while(inicio <= fin && !a[mitad].equals(v)) {
			if(v.compareTo(a[mitad])<0)
				fin = mitad-1;
			else
				inicio = mitad + 1;
			mitad = (inicio + fin)/2;
		}
		if(inicio <= fin)
			r=mitad;
		else
			r = -inicio-1;
		return r;
	}
	
	public static <T> void unCorrimientoDer(T a[], int n, int pos) {
		
		for(int i=n;i>pos;i--)
			a[i]=a[i-1];
		a[pos]=null;
	}
	
	public static <T> void unCorrimientoIzq(T a[], int n, int pos) {
	
	for(int i=pos; i<n-1; i++)
		a[i]=a[i+1];
	a[n-1]=null;
	}
	
	public static <T extends Comparable<T>> boolean insertaEnOrden(T a[], int n, T v) {
		int pos=busquedaSecuencialDesordenada(a,n,v);
		boolean resp;
		
		if(pos>=0) {
			resp=false;
		}
		else {
			resp=true;
			pos=(pos*-1)-1;
			unCorrimientoDer(a,n,pos);
			a[pos]=v;
	}
		return resp;	
	}
	
	public static <T extends Comparable<T>> boolean insertaEnDesorden(T a[], int n, T v) {
		int pos=busquedaSecuencialDesordenada(a,n,v);
		boolean resp;
		
		if(pos>=0) {
			
			resp=false;
		}
		else {
			resp=true;
			a[n]=v;	
	}
		return resp;
	}
	
	public static <T> void insertaAlFinal(T[] a, int n, T x) {
		
		if(n<a.length) {
			a[n]=x;
			n++;
		}				
	}
	
	
	public static <T> void insertaAlInicio(T[] a, int n, T x) {
		
		if(n<a.length) {
			a[0]=x;
			n++;
		}				
	}
	
	public static <T extends Comparable<T>> boolean eliminaEnOrden(T a[], int n, T v) {
		int pos=buscaBinaria(a,n,v);
		boolean resp;
		
		if(pos>=0) {	
			unCorrimientoIzq(a,n,pos);
			resp=true;
		}
		else
			resp=false;
		return resp;	
	}
	
	public static <T extends Comparable<T>> boolean eliminaEnDesorden(T a[], int n, T v) {
		int pos=buscaSecuencialOrdenada(a,n,v);
		boolean resp;

		if(pos>=0) {	
			unCorrimientoIzq(a,n,pos);
			resp=true;
		}
		else
			resp=false;
		return resp;
	}
	
	public static <T extends Comparable<T>>void ordena(T a[], int n) {
		int min;
		T aux;
		
		for(int i=0; i < n-1; i++) {
			min = i;
			for(int j=i+1; j < n; j++)
				if(a[j].compareTo(a[min]) < 0)
					min = j;
			aux = a[i];
			a[i] = a[min];
			a[min] = aux;
		}
	}
	
	public static <T extends Comparable <T>> String toString(T a[], int n) {
		StringBuilder sb= new StringBuilder();
		
		for(int i=0; i<n; i++)
			sb.append(a[i].toString()+ "\n");
		return sb.toString();
	}
	
}