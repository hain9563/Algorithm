import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 평범한배낭 {
    public static class item implements Comparable<item>{
        int weight;
        int value;
        public item(int weight, int value){
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(item item) {
            if(this.weight < item.weight){
                return -1;
            } else if(this.weight == item.weight){
                return 0;
            } else{
                return 1;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //물품의 수
        int k = sc.nextInt();   //버틸 수 있는 무게
        List<item> items = new ArrayList<item>();
        int[][] dp = new int[n][k+1];

        for(int i=0;i<n;i++){
            items.add(new item(sc.nextInt(), sc.nextInt()));
            dp[i][0] = 0;
        }

//        Collections.sort(items);    //무게 기준 오름차순 정렬
//
        for(int i=0;i<=k;i++){
            if(items.get(0).weight > i) dp[0][i] = 0;
            else    dp[0][i] = items.get(0).value;
        }

        int max = 0;
        for(int i=1;i<n;i++){
            int weight = items.get(i).weight;
            int value = items.get(i).value;
            for(int j=1;j<=k;j++){
                if(weight > j) dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = Math.max(dp[i-1][j],  value + dp[i-1][j-weight]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }

//        for(int i=0;i<n;i++){
//            for(int j=0;j<=k;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println("");
//        }

        System.out.println(max);
    }
}
