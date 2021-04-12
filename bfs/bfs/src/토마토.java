import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 토마토 {
    public static class Location{
        int row;
        int col;
        public Location(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    static Queue<Location> ripen;
    static int[][] check;
    static int N,M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[M][N];
        check = new int[M][N];
        ripen = new LinkedList<>();

//        int input;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1){ //익은 토마토
                    ripen.offer(new Location(i, j));
                    check[i][j] = 1;
                }
                if(map[i][j] == -1){
                    check[i][j] = -1;
                }
            }
        }

        System.out.println(bfs());
//        for(int i=0;i<M;i++){
//            for(int j=0;j<N;j++) {
//                System.out.print(check[i][j] + " ");
//            }
//            System.out.println("");
//        }


    }

    public static int bfs(){
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        while(!ripen.isEmpty()){
            Location x = ripen.poll();
            int row = x.row;
            int col = x.col;

            for (int i = 0; i < 4; i++) {
                int nx = row + dx[i];
                int ny = col + dy[i];

                if (nx < 0 || nx > M - 1 || ny < 0 || ny > N - 1) continue;   // 지도의 범위 밖인 경우
                if (map[nx][ny] == -1) continue;   // 토마토가 없는 곳인 경우

                if (check[nx][ny] == 0) {
                    ripen.offer(new Location(nx, ny));
                    check[nx][ny] = check[row][col] + 1;
                }
            }
        }

        int max = -1;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                max = Math.max(max, check[i][j]);
                if(check[i][j] == 0){
                    max = -1;
                    return max;
                }
            }
        }
        return max - 1;
    }
}
