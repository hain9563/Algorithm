import java.util.Arrays;
import java.util.Scanner;

public class 오르막수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n+1][10];

        for(int i=0;i<10;i++){
            dp[1][i] = 1;
        }
        for(int i=1;i<=n;i++){
            dp[i][0] = 1;
        }

        for(int i=2;i<=n;i++){
            for(int j=1;j<10;j++){
                int temp = dp[i][j-1]%10007 + dp[i-1][j]%10007;
                dp[i][j] = temp % 10007;
            }
        }
        int result = 0;
        for(int i=0;i<10;i++){
            result = result + dp[n][i];
        }

//        for(int[] a:dp){
//            System.out.println(Arrays.toString(a));
//        }
        System.out.println(result%10007);
    }
}
