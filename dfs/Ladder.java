package com.ssafy.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ladder {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new FileReader(new File("input.txt")));

		for (int tc = 0; tc < 10; tc++) {
			int testcase = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			int result = 0;

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int dc = 0;
			int dr = 99;

			for (int i = 0; i < 100; i++) {
				if (arr[99][i] == 2)
					dc = i;
			}
//			System.out.println(dc);

			for (int i = 99; i >= 0; i--) {
				if (checkIndex(i, dc + 1) && arr[i][dc + 1] == 1) {
					while (checkIndex(i, dc + 1) && arr[i][dc + 1] == 1) { // ¿À¸¥ÂÊ
						dc++;
					}
				}

				else if (checkIndex(i, dc - 1) && arr[i][dc - 1] == 1) {
					while (checkIndex(i, dc - 1) && arr[i][dc - 1] == 1) { // ¿ÞÂÊ
						dc--;
					}
				}
//				System.out.println(i + " " + dc);

//				if (i == 0) {
//					result = dc;
//					break;
//				}
			}
			System.out.println("#" + (tc + 1) + " " + dc);

		}

	}

	public static boolean checkIndex(int row, int col) {
		if (row < 0 || col < 0 || row >= 100 || col >= 100)
			return false;
		return true;
	}

}
