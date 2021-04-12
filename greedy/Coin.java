import java.util.Arrays;
import java.util.Scanner;

public class Coin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] num = new int[N];
        for(int i=0;i<N;i++){
            num[i] = sc.nextInt();
        }
        int sum = 0;
        for(int i=N-1;i>=0;i--){
            if(num[i] > K)  continue;
            if(K == 0) break;
            sum = sum + K / num[i];
            K = K % num[i];
        }

        System.out.println(sum);
    }
}
