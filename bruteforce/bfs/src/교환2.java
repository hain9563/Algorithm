import java.util.*;

public class 교환2 {
    public static class Location{
        int num;
        int k;
        public Location(int num, int k){
            this.num = num;
            this.k = k;
        }
    }
    static int[][] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int max = -1;
        check = new int[1000001][k+1];
        bfs(n,k);

        for(int i=1;i<1000001;i++){
            for(int j=1;j<k+1;j++) {
                if(check[i][j] > 0){
                    if(j == k){
                        max = Math.max(max, i);
                    }
                }
            }
        }
        System.out.println(max);
    }

    public static void bfs(int n, int k){
        Queue<Location> q = new LinkedList<>();
        int digits = (int) Math.log10(n)+1;
        q.offer(new Location(n, 0));
        check[n][0] = 1;
        while(!q.isEmpty()){
            Location x = q.poll();
            if(x.k == k)   return;
            for(int i=0;i<digits;i++){
                for(int j=i+1;j<digits;j++){
                    StringBuilder after = new StringBuilder(Integer.toString(x.num));
                    char temp = after.charAt(j);
                    after.setCharAt(j, after.charAt(i));
                    after.setCharAt(i, temp);
                    int after_num = Integer.parseInt(after.toString());
                    if(after.charAt(0) == '0')  continue;   //첫번째 자리가 0인 경우
                    if(check[after_num][x.k+1] == 0) {
                        check[after_num][x.k+1] = 1;
//                        System.out.println(after_num+" : "+ x.k);
                        q.offer(new Location(after_num, x.k+1));
                    }

                }
            }
        }
    }
}
