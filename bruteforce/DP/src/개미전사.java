import java.util.Arrays;
import java.util.Scanner;

public class 개미전사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1;i<n+1;i++){
            a[i] = sc.nextInt();
        }

        dp[1] = a[1];
        dp[2] = Math.max(a[1], a[2]);
        for(int i=3;i<n+1;i++){
            dp[i] = Math.max(dp[i-2]+ a[i], dp[i-1]);
        }
        System.out.println(Arrays.toString(dp));
    }
}
