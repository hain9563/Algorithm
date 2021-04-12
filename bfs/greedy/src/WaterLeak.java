import java.util.Arrays;
import java.util.Scanner;

//백준 1449번
public class WaterLeak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] num = new int[N+1];

        for(int i =1;i<N+1;i++){
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);
        int temp = 0;
        int count = 0;

        base:
        for(int i=1;i<N+1;i++){
            temp = num[i] + L -1;

            while(num[i]<= temp){
                i++;    //테이프로 막을 수 있는 곳까지 막기
                if(temp < num[i]) count++;

                if(i == N){
                    count++;
                    break base;
                }
            }
            i--;
        }

        System.out.println(count);
    }
}
