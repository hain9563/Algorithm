import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 센서2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //센서 개수
        int K = sc.nextInt();   //기지국 개수
        int[] sensor = new int[N];  //센서 위치

        for(int i=0;i<N;i++){
            sensor[i] = sc.nextInt();
        }

        Arrays.sort(sensor);

        int[] diff = new int[N-1];
        for(int i=0;i<N-1;i++){
            diff[i] = sensor[i+1] - sensor[i];
        }

        Arrays.sort(diff);
//        System.out.println(Arrays.toString(diff));
        int sum=0;
        for(int i=0;i<N-K;i++){
            sum = sum + diff[i];
        }
        System.out.println(sum);
    }
}
