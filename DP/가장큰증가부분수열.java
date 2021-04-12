import java.util.Arrays;
import java.util.Scanner;

public class 가장큰증가부분수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

//        System.out.println(Arrays.toString(a));
        dp[0] = a[0];
        int max = -1;
        int sum = dp[0];
        for(int i=1;i<n;i++){
            for (int j = i; j > 0; j--) {
                if(a[j-1] < a[i] ){
                    max = Math.max(max, dp[j-1]+a[i]);
                }

            }
            if(max == -1)   max = a[i];
            sum = Math.max(sum, max);
            dp[i] = max;
            max = -1;
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(sum);
    }
}
