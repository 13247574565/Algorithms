package com.jimmysun.algorithms.chapter1_1;

import java.util.Random;

public class Ex11 {
	public static void printBooleanMatrix(boolean[][] matrix) {
		System.out.print(' ');
		//打印列数
		for (int i = 0; i < matrix[0].length; i++) {
			System.out.print(i);
		}
		System.out.println();
		
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(i);
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] ? '*' : ' ');
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		boolean[][] a = new boolean[6][3];
		Random random = new Random();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (random.nextInt(99)%2 == 1) {
					a[i][j] = true;
				} else {
					a[i][j] = false;
				}
			}
			
		}
		
		
		
		
		printBooleanMatrix(a);
	}
}
