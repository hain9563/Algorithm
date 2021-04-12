import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 단지번호붙이기 {
    static int[][] map;
    static int[][] check;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int n;
    static int count_home;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        check = new int[n][n];
        ArrayList<Integer> home = new ArrayList<>();

        for(int i=0;i<n;i++){
            String a = br.readLine();
            for(int j=0;j<n;j++){
                map[i][j] = a.charAt(j) - '0';
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(check[i][j] == 0 && map[i][j] == 1){
                    count_home = 0;
                    dfs(i,j);
                    count++;
                    home.add(count_home);
                }
            }
        }
        System.out.println(count);
        Collections.sort(home);
        for(int i=0;i<home.size();i++){
            System.out.println(home.get(i));
        }
    }

    static void dfs(int x, int y){
        check[x][y] = 1;
        count_home++;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n)    continue;
            if(map[nx][ny] == 1 && check[nx][ny] == 0){
                check[nx][ny] = 1;
                dfs(nx, ny);
            }
        }
    }
}
