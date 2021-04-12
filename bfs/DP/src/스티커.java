import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[3][n+1];
            int[][] a = new int[3][n+1];

            for(int i=1;i<3;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1;j<=n;j++){
                    dp[i][j] = Integer.parseInt(st.nextToken());
                }
            }

//            for(int[] a:dp){
//                System.out.println(Arrays.toString(a));
//            }

            int max = 0;
            a[1][1] = dp[1][1];
            a[2][1] = dp[2][1];
            a[1][2] = dp[1][2] + dp[2][1];
            a[2][2] = dp[2][2] + dp[1][1];
            for(int i=3;i<=n;i++){
                a[1][i] = Math.max(dp[1][i]+a[2][i-1], a[2][i-2]+dp[1][i]);
                a[2][i] = Math.max(dp[2][i]+a[1][i-1], a[1][i-2]+dp[2][i]);
            }

//
//            for(int[] k:a){
//                System.out.println(Arrays.toString(k));
//            }

            max = Math.max(a[1][n], a[2][n]);
            System.out.println(max);

        }

    }
}
