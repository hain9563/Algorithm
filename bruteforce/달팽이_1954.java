package com.ssafy.hw02;

import java.util.Scanner;

public class ¥ﬁ∆ÿ¿Ã_1954 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int tc = 0; tc < testcase; tc++) {
			int n = sc.nextInt();

			int[][] arr = new int[n][n];
			int cx = 0;
			int cy = 0;

			int[] dx = { 0, 1, 0, -1 };
			int[] dy = { 1, 0, -1, 0 }; // ø¿ æ∆ øﬁ ¿ß
			int num = 1;
			arr[0][0] = num;
			num++;

			for (int i = 0; i < 2 * n - 1; i++) {
				while (true) {
					int nx = cx + dx[i % 4];
					int ny = cy + dy[i % 4];

					if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] == 0) {
						arr[nx][ny] = num;
						num++;
					}else {
						break;
					}
					cx = nx;
					cy = ny;
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}

				System.out.println("");
			}
		}

	}

}
