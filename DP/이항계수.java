import java.util.Arrays;
import java.util.Scanner;

public class 이항계수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] dp = new int[n+1][n+1];

        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for(int i=2;i<=n;i++){
            for(int j=1;j<=n;j++){
                int temp = dp[i-1][j-1]%10007 + dp[i-1][j]%10007;
                dp[i][j] = temp%10007;
            }
        }

//        for(int[] a:dp){
//            System.out.println(Arrays.toString(a));
//        }

        System.out.println(dp[n][k]);
    }
}
