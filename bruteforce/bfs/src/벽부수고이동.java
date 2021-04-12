import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동 {
    public static class Location{
        int row;
        int col;
        int flag;
        public Location(int row, int col, int flag){
            this.row  = row;
            this.col = col;
            this.flag = flag;
        }
    }

    static int[][][] check;
    static int n, m;
    static int map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        check = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = a.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }


    static int bfs(){
        Queue<Location> q = new LinkedList<>();
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        q.offer(new Location(0,0, 0));
        check[0][0][0] = 1;
        while(!q.isEmpty()){
            Location x = q.poll();
            int row = x.row;
            int column = x.col;
            int flag = x.flag;

            if(row == n-1 && column == m-1) return check[row][column][flag];
            for(int i=0;i<4;i++){
                int nx = row + dx[i];
                int ny = column + dy[i];

                if(nx < 0 || nx > n-1 || ny < 0 || ny > m-1)    continue;   //범위를 벗어날 경우
                if(check[nx][ny][flag] != 0)    continue; //이미 갔던 길인 경우
                if(map[nx][ny] == 0){   //길이 맞을 때
                    q.offer(new Location(nx, ny, flag));
                    check[nx][ny][flag] = check[row][column][flag] + 1;
                }
                if(map[nx][ny] == 1 && flag == 0){  //벽인데 아직 한번도 벽을 안뚫음
                    q.offer(new Location(nx, ny, 1));
                    check[nx][ny][1] = check[row][column][flag] + 1;
                }

//                if(nx > 0 && nx <= n && ny > 0 && ny <= m){
//                    if(check[nx][ny] == 0 && map[nx][ny] == 0){
//                        q.offer(new Location(nx, ny));
//                        check[nx][ny] = check[row][column] + 1;
//                    }
//                }
            }
        }
        return -1;

    }

}
