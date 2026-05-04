/*
 * Carmen Sofía Delgado Escobar
 * O2023
 * Clase para almacenar metodos de arreglos que nos puedan ayudar en futuros proyectos
 */

import java.util.ArrayList;

public class ManejadorArreglos {
	
	public static double suma(double a[], int n) {
		double suma=0;
		int i;
			
		for (i = 0; i < n; i++)
			suma += a[i];
		return suma;
	}
	
	public static double promedio(double a[], int n){
		double prom;

		prom = suma(a,n)/n;
		return prom;
	}
	
	public static int posMayor(double a[],int n) {
		int pos=0, i;
		double min=a[0];
		
		for(i = 0; i<n; i++) {
			if (a[i] < min) {
				min = a[i];
				pos = i;
			}
		}
		return pos;	
	}
	
	public static int posMenor(double a[],int n) {
		int pos=0, i;
		double max= a[0];
		
		for(i = 0; i<n; i++) {
			if (a[i] > max) {
				max = a[i];
				pos = i;
			}
		}
		return pos;	
	}

	public static int cuantosMayX(double a[], int n, double x) {
		int cuantos=0;

		for(int i=0;i<n;i++)
			if(a[i]>x)
				cuantos++;
		return cuantos;
	}
	
	public static int cuantosMenX(double a[], int n, double x) {
		int cuantos=0, i;
		
		for(i=0;i<n;i++)
			if(a[i]<x)
				cuantos++;
		return cuantos;
	}
	
	public static ArrayList<Integer> cualesMayX(double a[], int n, double x) {
		int cuantos=0;
		ArrayList<Integer>lista= new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
			if(a[i]>x)
				lista.add(i);
		return lista;
	}
	
	public static ArrayList<Integer> cualesMayprom(double a[], int n) {
		int cuantos=0;
		ArrayList<Integer>lista= new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
			if(a[i]>promedio(a, n))
				lista.add(i);
		return lista;
	}
	
	public static ArrayList<Integer> cualesMenX(double a[], int n, double x) {
		int cuantos=0;
		ArrayList<Integer>lista= new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
			if(a[i]<x)
				lista.add(i);
		return lista;
	}
	
	public static void swap(double a[], int pos1, int pos2) {
		double pos= a[pos1];
		
		a[pos1]= a[pos2];
		a[pos2]= pos;
	}
	
	public static void invierte(double a[], int inicio) {
		int fin= a.length - 1;
		
		while (inicio < fin) {
			double posi= a[inicio];
			a[inicio]= a[fin];
			a[fin]= posi;
			inicio++;
			fin++;
		}
	} //Aquí acaba la tarea 17
	
	//Tarea 20
	
	public static double[] kCorrimientoDer(double a[],int k, int n) {		
			double c[] = new double[n];
			
			for(int i=0; i<n; i++)
			c[i]= a[k-1+i];
			return c;
	}
	
	public static double[] kCorrimientoIzq(double a[],int k, int n) {		
		double c[] = new double[n];
		
		for(int i=0; i<n; i++)
		c[i]= a[k+i];
		return c;
}
	
	public static int busSecBinaria(double a[], int n, double v) { 	
		int inicio=0, fin= n - 1, mitad= (inicio + fin)/2, r;
		
		while(inicio <= fin && a[mitad]!= v) {
			if(v<a[mitad])
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
	
	public static int buscSecOrdenada(double a[], int n, double num) {
		int resp = -1;
		int i = 0;
		boolean enc = false;
		while(i < n || !enc) {
			if(a[i] == num) {
				enc = true;
				resp = i;
			}
			i++;
		}
		return resp;
	}

	public static ArrayList<Integer> unionArreglos(int a[], int b[]) {
		ArrayList<Integer>c= new ArrayList<Integer>();
		int i, j;
		
		for(i=0; i<a.length; i++) 
			c.add(a[i]);
		
		for(j=0; j<b.length; j++) {
			if(!c.contains(b[i]))
			c.add(b[j]);	
		}
		return c;
	}
	
	public static boolean calculaCapicua(int a[]) {
		int x=0, y=a.length;
		boolean capicua=true;
		
		while(x<y && capicua) {
			if(a[x]==a[y]) {
				x++;
				y--;
			}
			else
				capicua=false;
		}
		return capicua;
	}
	
	public static boolean esCapicua(int a[]) {
		boolean resp=true;
		int i=0, tam= a.length;
		
		while(i < tam && resp) {
			if(a[i] != a[tam - 1 - i])
				resp = false;
			i++;
		}
		
		return resp;
		
	}
	
	public static boolean igualesTradicional(int a[], int b[]) {
		boolean iguales=true;
		int i=0;
		
		if(a.length==b.length && i<a.length) {
			if(a[i]==b[i])
				i++;
			else
				iguales=false;
		}
		return iguales;
	}
	
	public static boolean equals(int a[], int  b[]) {
		boolean iguales;
		if(a.equals(b))
			iguales=true;
		else
			iguales=false;
		return iguales;
	}
	
	public static boolean igualesTradicional2(int a[], int b[]) {
		boolean iguales;
		iguales = true;
		int i;
		if(a.length != b.length) {
			iguales = false;
		} 
		else {
			i = 0;
			while( i < a.length && iguales) 
				if(a[i] != b[i])
					iguales = false;
		}
		return iguales;
	}
	
	public static void ordena(double a[], int n) {
		int j, min;
		double aux;
		
		for(int i=0; i < n-1; i++) {
			min = i;
			for(j=i+1; j < n; j++)
				if(a[j] < a[min])
					min = j;
			aux = a[i];
			a[i] = a[min];
			a[min] = aux;
		}
	}
	
	public static int[] clientesCaja(ArrayList<Integer>cajas){
		int cont[]= new int[5];
		int numCaja;
		 
		for(int i=0; i<cont.length; i++)
			cont[i]=0;
		for(int i=0; i<cajas.size();i++)
			numCaja=cajas.get(i);
		return cont;
	}
	
}
