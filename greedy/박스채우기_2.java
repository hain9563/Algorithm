import java.util.Arrays;
import java.util.Scanner;

public class 박스채우기_2 {
    static class Cube {
        int side;   //큐브의 한 변의 길이
        int number; //큐브 개수
        long cube_vol;   //큐브 하나의 부피

        public Cube(int s, int number) {
            this.side = s;
            this.number = number;
            this.cube_vol = (long) Math.pow(side, 3);
        }
        public void showInfo() {
            System.out.println(side+" "+number+" "+cube_vol);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int width = sc.nextInt();
        int height = sc.nextInt();
        int N = sc.nextInt();

        int[] cube = new int[21];
        Arrays.fill(cube, -1);
        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int num = sc.nextInt();
            cube[s] = num;
        }

        long max_cube_num;
        long need;
        long side;
        long temp = 0;
        long count = 0;
        long mult;
        for(int i=20;i>=0;i--){
            if(cube[i] != -1) {
                side = (long) Math.pow(2, i);
                if(side > length && side > width && side > height) continue;
                else{

                    temp = temp * 8;
                    max_cube_num = length / side * width / side * height / side;
                    need = Math.min(cube[i], max_cube_num - temp);
                    temp = temp + need;
                    count = count + need;
                }
            }
        }
        if(temp == length * width * height) System.out.println(count);
        else    System.out.println("-1");
    }
}
