import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 적록색약 {
    static char[][] greed;
    static int[][] check;
    static int[] dx = {0,0,-1,1};
    static int[] dy =  {-1,1,0,0};
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        greed = new char[n][n];
        check = new int[n][n];

        for(int i=0;i<n;i++){
            String a = br.readLine();
            for(int j=0;j<n;j++){
                greed[i][j] = a.charAt(j);
            }
        }

        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(check[i][j] == 0 && greed[i][j] == 'R'){
                    dfs(i,j,'R');
                    count++;
                }
                if(check[i][j] == 0 && greed[i][j] == 'G'){
                    dfs(i,j,'G');
                    count++;
                }
                if(check[i][j] == 0 && greed[i][j] == 'B'){
                    dfs(i,j,'B');
                    count++;
                }
            }
        }
        System.out.print(count+" ");
        for(int a[]:check){
            Arrays.fill(a, 0);
        }
//        for(int i=0;i<n;i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.println(check[i][j] + " ");
//            }
//            System.out.println("");
//        }

        count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(check[i][j] == 0 && (greed[i][j] == 'R' || greed[i][j] == 'G')){
                    dfs_2(i,j,'R', 'G');
                    count++;
                }
                if(check[i][j] == 0 && greed[i][j] == 'B'){
                    dfs(i,j,'B');
                    count++;
                }
            }
        }
        System.out.print(count);
    }

    static void dfs(int x, int y, char rgb) {
        check[x][y] = 1;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n ) continue;
            if(check[nx][ny] == 0 && greed[nx][ny] == rgb){
                check[nx][ny] = 1;
                dfs(nx, ny, rgb);
            }
        }
    }

    static void dfs_2(int x, int y, char rgb, char rgb2) {
        check[x][y] = 1;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n ) continue;
            if(check[nx][ny] == 0 && (greed[nx][ny] == rgb || greed[nx][ny] == rgb2)){
                check[nx][ny] = 1;
                dfs_2(nx, ny, rgb, rgb2);
            }
        }
    }
}
