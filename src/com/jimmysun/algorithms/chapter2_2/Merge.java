package com.jimmysun.algorithms.chapter2_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Merge {
	private static Comparable[] aux;

	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		//"S","A","E"  0 0 1
		//k= 0 , i=0 mid=0  j = 1  a[0]> a[1]    a[0]=aux[j++]= "A" j=2
		
		//k= 1 , i=0 mid=0  j = 2  j>hi    a[1]=aux[i++]= "S" j=2 i=1  
		
		//        2   3
		//"A",   "S","E" 2 2 3
		//k= 2 , i=2 mid=2 j=3  a[2]> a[3]    a[2]=aux[j++]= "E" j=4 i=2
		
		//k= 3 , i=2 mid=2 j=4  j>hi   a[3]=aux[i++]= "S" j=4 i=3         ES
		
		//AES
		//0,1,2    ,3,4
		
		//0 1 2 3 4
		//A E S D F
		//0-4
		//k= 0 , i=0 mid=2 j=3  4-->a[0]="A" i=1 j=3 
		//k= 1 , i=1 mid=2 j=3  3-->a[1]="D" i=1 j=4
		//k= 2 , i=1 mid=2 j=4  4-->a[2]="E" i=2 j=4
		//k= 3 , i=2 mid=2 j=4  3-->a[3]="F" i=2 j=5
		//k= 4 , i=2 mid=2 j=5  2-->a[4]="S" i=3 j=5
		
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];//1
			} else if (j > hi) {
				a[k] = aux[i++];//2
			} else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];//3
			} else {
				a[k] = aux[i++];//4
			}
			System.out.print(a[k]);
		}
		System.out.println();
	}

	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		System.out.println(lo+"--"+hi);
		if (hi <= lo) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}

	/**
	 * w>v时返回true
	 * @param v
	 * @param w
	 * @return
	 */
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
//		String[] a = new In().readAllStrings();
		String[] a = {"S","A","E","D","F"};
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
