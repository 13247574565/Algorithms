package com.jimmysun.algorithms.chapter1_2;

import java.util.Arrays;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdIn;

public class Ex09 {
	public static int rank(int key, int[] a, Counter counter) {
		return rank(key, a, 0, a.length - 1, counter);
	}

	public static int rank(int key, int[] a, int lo, int hi, Counter counter) {
		if (lo > hi) {
			return -1;
		}
		counter.increment();
		int mid = lo + (hi - lo) / 2;
		if (key < a[mid]) {
			return rank(key, a, lo, mid - 1, counter);
		} else if (key > a[mid]) {
			return rank(key, a, mid + 1, hi, counter);
		} else {
			return mid;
		}
	}

	public static void main(String[] args) {
		int[] a = {10,20,30,40,50,60,70,80,90,100,20};
		Arrays.sort(a);
		int key = 10;
		Counter counter = new Counter("keys");
		System.out.println(rank(key, a, counter));
		System.out.println(counter);
	}
}
