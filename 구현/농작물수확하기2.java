package com.ssafy.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class 농작물수확하기2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new FileReader(new File("input2.txt")));
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			int result = 0;
			for(int i=0;i<n;i++) {
				String a = br.readLine();
				for(int j=0;j<n;j++) {
					map[i][j] = a.charAt(j)-'0';
				}
			}
			
			for(int i=0;i<n/2;i++) {
				for(int j=n/2-i;j<=n/2+i;j++) {
					result += map[i][j];
				}
			}
			
			for(int i=n/2;i>=0;i--) {
				for(int j=n/2-i;j<=n/2+i;j++) {
					result += map[i][j];
				}
			}
			
			System.out.println("#"+(t+1)+" "+ result);
		}
	}

}
