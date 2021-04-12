import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추 {
//    static int check[];
    static int[][] map;
    static int[][] check;
    static int M,N;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            check = new int[N][M];

            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[b][a] = 1;
            }

            int count = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(check[i][j] == 0 && map[i][j] == 1){
                        dfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);

//            for(int i=0;i<N;i++){
//                for(int j=0;j<M;j++){
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println("");
//            }
        }
    }

    static void dfs(int y, int x){
//        if(x >= N || x<0 || y >= M || y<0)  return;
//        if(map[x][y] != 1)  return;

        check[y][x] = 1;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= M || nx<0 || ny >= N || ny<0)  continue;
            if(check[ny][nx] == 0 && map[ny][nx] == 1){
                check[ny][nx] = 1;
                dfs(ny, nx);
            }
        }


    }
}
