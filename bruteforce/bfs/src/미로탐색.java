import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 미로탐색 {
    public static class Location{
        int row;
        int col;
        public Location(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static int[][] check;
    static int N,M;
    static int[][] maze;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   //도착지 x좌표
        M = Integer.parseInt(st.nextToken());   //도착지 y좌표
        maze = new int[N+1][M+1];
        check = new int[N+1][M+1];
        for(int i=1;i<N+1;i++){
            String input = br.readLine();
            for(int j=1;j<M+1;j++){
                maze[i][j] = input.charAt(j - 1) - '0';
            }
        }
        bfs();
    }

    public static void bfs(){
        Queue<Location> q = new LinkedList<>();
        int[] dx = {0,0,1,-1};
        int[] dy = {-1,1,0,0};
        q.add(new Location(1,1));
        check[1][1] = 1;
        while(!q.isEmpty()){
            Location x = q.poll();
            int row = x.row;
            int col = x.col;
            for(int i=0;i<4;i++){
                int nx = row + dx[i];
                int ny = col + dy[i];

                if((nx > 0 && nx < N+1) && (ny > 0 && ny < M+1)){   //바뀐 좌표가 범위 안인지
                    if(check[nx][ny] == 0 && maze[nx][ny] == 1){    //방문한 좌표가 아닌지, 길이 맞는지
                        q.offer(new Location(nx, ny));
                        check[nx][ny] = check[row][col] + 1;    //정점까지 거리
                    }
                }
            }
        }
        System.out.println(check[N][M]);
    }
}
