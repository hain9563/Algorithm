import java.util.Map;
import java.util.Scanner;

public class 음식물피하기 {
    static int[][] map;
    static int[][] check;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N, M;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int K = sc.nextInt();
        map = new int[N+1][M+1];
        check = new int[N+1][M+1];

        for(int i=0;i<K;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1;
        }

        int max = -1;
        for(int i=0;i<N+1;i++) {
            for (int j = 0; j < M + 1; j++) {
                if (check[i][j] == 0 && map[i][j] == 1) {
                    count = 0;
                    check[i][j] = 1;
                    dfs(i, j);
                    max = Math.max(count, max);
                }
            }
        }
        System.out.println(max);
    }

    static void dfs(int x, int y){
//        check[x][y] = 1;
        count++;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx <= 0 || nx > N || ny <= 0 || ny > M) continue;
            if(check[nx][ny] == 0 && map[nx][ny] == 1){
                check[nx][ny] = 1;
                dfs(nx, ny);
            }
        }
    }
}
