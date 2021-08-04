package com.ssafy.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상호의배틀필드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new FileReader(new File("input.txt")));

		int testcase = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < testcase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int car_row = 0;
			int car_col = 0;
//			System.out.println("********* tc : "+tc+" ************");

			char[][] map = new char[H][W]; // 맵
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						car_row = i;
						car_col = j;
					}
				}
			}
			
//			System.out.println(car_row+" "+car_col);

			int userNum = Integer.parseInt(br.readLine()); // 유저 입력의 개수
			char[] input = new char[userNum]; // 유저 입력 배열
			input = br.readLine().toCharArray();

			for (int i = 0; i < userNum; i++) {
//				System.out.println(car_row + " "+ car_col);
				if (input[i] == 'U') {
					map[car_row][car_col] = '^';
					if (car_row - 1 >= 0 && map[car_row - 1][car_col] == '.' && map[car_row - 1][car_col] != '-') {
						map[car_row][car_col] = '.';
						map[car_row - 1][car_col] = '^';
						car_row = car_row - 1;
					}
				} else if (input[i] == 'D') {
					map[car_row][car_col] = 'v';
					if (car_row + 1 < H && map[car_row + 1][car_col] == '.' &&map[car_row + 1][car_col] != '-') {
						map[car_row][car_col] = '.';
						map[car_row + 1][car_col] = 'v';
						car_row = car_row + 1;
					}
				} else if (input[i] == 'L') {
					map[car_row][car_col] = '<';
					if (car_col - 1 >= 0 && map[car_row][car_col - 1] == '.' && map[car_row][car_col - 1] != '-') {
						map[car_row][car_col] = '.';
						map[car_row][car_col - 1] = '<';
						car_col = car_col - 1;
					}
				} else if (input[i] == 'R') {
					map[car_row][car_col] = '>';
					if (car_col + 1 < W && map[car_row][car_col + 1] == '.' && map[car_row][car_col + 1] != '-') {
						map[car_row][car_col] = '.';
						map[car_row][car_col + 1] = '>';
						car_col = car_col + 1;
					}
				} else if (input[i] == 'S') { // 포탄 발사 : 현재 전차 방향 상태를 보고 벽 or 강철 or 맵 끝이 나올떄까지 이동
					if (map[car_row][car_col] == '^') {
//						System.out.println("aaaaaaaaaaaaaaaaaa");
						int nx = car_row;
						
						while(true) {
							if(nx <0)	break;
							if(map[nx][car_col] == '*') {	//벽이면 평지로 만들기
//								System.out.println("bomb!!!!!!!!");
 								map[nx][car_col] = '.';
								break;
							}
							else if(map[nx][car_col] == '#')	break;	//강철벽이면 나오기
							--nx;
						}
						
						
//						while (nx-1 >= 0 && map[nx-1][car_col] =='.' ) { //다음칸이 벽이나 강철일때까지 전차 이동
//							if(map[nx-1][car_col] == '*') {	//벽이면 평지로 만들기
//								System.out.println("bomb!!!!!!!!");
// 								map[nx-1][car_col] = '.';
//								break;
//							}
//							else if(map[nx-1][car_col] == '#')	break;	//강철벽이면 그냥 나오기
//							--nx;
//							if(nx == -1) {	//맵 끝
//								break;
//							}
//						}
					}
					else if(map[car_row][car_col] == 'v') {
						int nx = car_row;
						while(true) {
							if(nx >H-1)	break;
							if(map[nx][car_col] == '*') {	//벽이면 평지로 만들기
//								System.out.println("bomb!!!!!!!!");
 								map[nx][car_col] = '.';
								break;
							}
							else if(map[nx][car_col] == '#')	break;	//강철벽이면 나오기
							++nx;
						}
					}
					else if(map[car_row][car_col] == '<') {
						int ny = car_col;
						while(true) {
							if(ny <0)	break;
							if(map[car_row][ny] == '*') {	//벽이면 평지로 만들기
//								System.out.println("bomb!!!!!!!!");
 								map[car_row][ny] = '.';
								break;
							}
							else if(map[car_row][ny] == '#')	break;	//강철벽이면 나오기
							--ny;
						}
					}
					else if(map[car_row][car_col] == '>') {
						int ny = car_col;
						while(true) {
							if(ny > W-1)	break;
							if(map[car_row][ny] == '*') {	//벽이면 평지로 만들기
//								System.out.println("bomb!!!!!!!!");
 								map[car_row][ny] = '.';
								break;
							}
							else if(map[car_row][ny] == '#')	break;	//강철벽이면 나오기
							++ny;
						}
					}
				}
				
				
			}
			System.out.print("#"+(tc+1)+" ");
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}

//		public static void checkPo()

	}

}
