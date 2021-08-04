package com.ssafy.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ��ȣ�ǹ�Ʋ�ʵ� {

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

			char[][] map = new char[H][W]; // ��
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

			int userNum = Integer.parseInt(br.readLine()); // ���� �Է��� ����
			char[] input = new char[userNum]; // ���� �Է� �迭
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
				} else if (input[i] == 'S') { // ��ź �߻� : ���� ���� ���� ���¸� ���� �� or ��ö or �� ���� ���Ë����� �̵�
					if (map[car_row][car_col] == '^') {
//						System.out.println("aaaaaaaaaaaaaaaaaa");
						int nx = car_row;
						
						while(true) {
							if(nx <0)	break;
							if(map[nx][car_col] == '*') {	//���̸� ������ �����
//								System.out.println("bomb!!!!!!!!");
 								map[nx][car_col] = '.';
								break;
							}
							else if(map[nx][car_col] == '#')	break;	//��ö���̸� ������
							--nx;
						}
						
						
//						while (nx-1 >= 0 && map[nx-1][car_col] =='.' ) { //����ĭ�� ���̳� ��ö�϶����� ���� �̵�
//							if(map[nx-1][car_col] == '*') {	//���̸� ������ �����
//								System.out.println("bomb!!!!!!!!");
// 								map[nx-1][car_col] = '.';
//								break;
//							}
//							else if(map[nx-1][car_col] == '#')	break;	//��ö���̸� �׳� ������
//							--nx;
//							if(nx == -1) {	//�� ��
//								break;
//							}
//						}
					}
					else if(map[car_row][car_col] == 'v') {
						int nx = car_row;
						while(true) {
							if(nx >H-1)	break;
							if(map[nx][car_col] == '*') {	//���̸� ������ �����
//								System.out.println("bomb!!!!!!!!");
 								map[nx][car_col] = '.';
								break;
							}
							else if(map[nx][car_col] == '#')	break;	//��ö���̸� ������
							++nx;
						}
					}
					else if(map[car_row][car_col] == '<') {
						int ny = car_col;
						while(true) {
							if(ny <0)	break;
							if(map[car_row][ny] == '*') {	//���̸� ������ �����
//								System.out.println("bomb!!!!!!!!");
 								map[car_row][ny] = '.';
								break;
							}
							else if(map[car_row][ny] == '#')	break;	//��ö���̸� ������
							--ny;
						}
					}
					else if(map[car_row][car_col] == '>') {
						int ny = car_col;
						while(true) {
							if(ny > W-1)	break;
							if(map[car_row][ny] == '*') {	//���̸� ������ �����
//								System.out.println("bomb!!!!!!!!");
 								map[car_row][ny] = '.';
								break;
							}
							else if(map[car_row][ny] == '#')	break;	//��ö���̸� ������
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
