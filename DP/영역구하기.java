import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 영역구하기 {
    static int[][] map;
    static int[][] check;
    static int area = 0;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N,M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        int K = sc.nextInt();
        map = new int[M+1][N+1];
        check = new int[M+1][N+1];
        ArrayList<Integer> areas = new ArrayList<>();

        while(K-->0){
            int y1 = sc.nextInt();
            int x1 = sc.nextInt();
            int y2 = sc.nextInt();
            int x2 = sc.nextInt();

            for(int i=x1;i<x2;i++){
                for(int j=y1;j<y2;j++){
                    map[i][j] = 1;
                }
            }
        }
        int count = 0;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(check[i][j] == 0 && map[i][j] == 0){
                    area = 0;
                    dfs(i,j);
                    count++;
                    areas.add(area);
                }
            }
        }
        System.out.println(count);
        Collections.sort(areas);
        for(int i=0;i<areas.size();i++){
            System.out.print(areas.get(i)+" ");
        }

//        for(int i=0;i<M;i++){
//            for(int j=0;j<N;j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println("");
//        }

    }

    static void dfs(int x, int y){
        check[x][y] = 1;
        area++;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= M || ny < 0 || ny >= N)    continue;
            if(check[nx][ny] == 0 && map[nx][ny] == 0){
                check[nx][ny] = 1;
                dfs(nx, ny);
            }
        }
    }
}
