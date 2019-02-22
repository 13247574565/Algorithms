package com.jimmysun.algorithms.chapter1_1;

public class Ex13 {
	public static void printTransposedMatrix(int[][] matrix) {
		for (int i = 0; i < matrix[0].length; i++) {//新的总行数为旧的总列数
			for (int j = 0; j < matrix.length; j++) {//新的总列数为旧的总行数
				System.out.printf("%4d", matrix[j][i]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] a = { { 100, 200, 300 }, { 400, 500, 600 } };
		printTransposedMatrix(a);
	}
}
