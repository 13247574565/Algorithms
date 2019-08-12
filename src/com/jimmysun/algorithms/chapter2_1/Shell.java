package com.jimmysun.algorithms.chapter2_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Shell {
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3) {
			h = 3 * h + 1;// 1,4,13,40,121,364,1093......
		}
		for (int i = 0; i < a.length; i++) {
			if (i < 10) {
				System.out.print(i + "   ");
			} else {
				System.out.print(i + "  ");
			}

		}
		System.out.println();

		for (int i = 0; i < a.length; i++) {

			System.out.print(a[i] + "   ");

		}
		System.out.println();
		while (h >= 1) {//h 13 4 1  h为4 i:4-->12  i=9时  j: 9
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h],j); j -= h) {
					exch(a, j, j - h);
				}
			}
			h = h / 3;
		}
	}

	private static boolean less(Comparable v, Comparable w,int h) {
		System.out.println(h);
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
		for (int n = 0; n < a.length; n++) {
			StdOut.print(a[n] + "   ");
		}
		System.out.println();
	}

	private static void show(Comparable[] a) {
		System.out.println("————————————————————————————最终结果————————————————————————————");
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + "   ");
		}
		StdOut.println();
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			if (less(a[i], a[i - 1], i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// String[] a = new In().readAllStrings();
		// String[] a =
		// {"E","A","S","Y","S","H","E","L","L","S","O","R","T","Q","U","E","S","T","I","O","N"};
		String[] a = { "S", "H", "E", "L", "L", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
