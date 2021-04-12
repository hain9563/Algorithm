import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 안전영역 {
    static int[][] map;
    static int min, max, n;
    static int[][] check;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        check = new int[n][n];

        max = -1;
        min = 1000;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                max = Math.max(a, max);
            }
        }

        int count;
        int safe_space = -1;
        for(int k=0;k<=max;k++) {
            for(int a[]:check){
                Arrays.fill(a, 0);
            }
            count = 0;  //구역 개수 세기 위한 변수
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(check[i][j] == 0 && map[i][j] > k ){
                        count++;
                        dfs(i, j, k);
                    }
                }
            }
//            System.out.println(count);
            safe_space = Math.max(count, safe_space);
        }
        System.out.println(safe_space);
    }

    static void dfs(int x, int y, int flood) {
        check[x][y] = 1;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n ) continue;
            if(check[nx][ny] == 0 && map[nx][ny] > flood){
                dfs(nx, ny, flood);
            }
        }
    }
}
