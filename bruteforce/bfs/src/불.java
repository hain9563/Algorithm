import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불 {
    public static class Location{
        int row;
        int col;
        public Location(int row, int col){
            this.row = row;
            this.col = col;
        }
        public void printLoc(){
            System.out.println("row : "+row+" col : "+col);
        }
    }
    static char[][] map;
    static int R,C;
    static Location start = new Location(-1,-1);
    static Location fire = new Location(-1,-1);
    static int check[][];
    static int check_fire[][];
    static Queue<Location> fires;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int t=0;t<N;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            map = new char[R][C];
            check = new int[R][C];
            check_fire = new int[R][C];
            fires = new LinkedList<>();
            for (int i = 0; i < R; i++) {
                String input = br.readLine();
                for(int j = 0;j<C;j++) {
                    char c = input.charAt(j);
                    map[i][j] = c;
                    if (c == '@') start = new Location(i, j);
                    if (c == '*') {
                        fires.offer(new Location(i, j));
                        check_fire[i][j] = -1;
                    }
                }

            }

//            for(int i=0;i<R;i++){
//                for(int j=0;j<C;j++){
//                    System.out.print(check_fire[i][j]+" ");
//                }
//                System.out.println("");
//            }
            bfs();

            int min = Integer.MAX_VALUE;
            for(int i=0;i<R;i++){
                for(int j=0;j<C;j++){
//                System.out.print(check[i][j]+" ");
                    if(i == 0 || j == 0 || i == R-1 || j == C-1){
                        if(check[i][j] != 0) min = Math.min(min, check[i][j]);
                    }
                }
//            System.out.println("");
            }
            if(min == 0 || min == Integer.MAX_VALUE)   System.out.println("IMPOSSIBLE");
            else    System.out.println(min);

        }
    }
    //상근이 먼저 움직인 후 불이 번져야 함
    // check가 1이면 이미 왔던 칸, -1이면 불이 옮겨진 칸
    static void bfs(){
        Queue<Location> q = new LinkedList<>();
        int[] dx = {0,0,1,-1};
        int[] dy = {-1,1,0,0};
        q.offer(start);
        check[start.row][start.col] = 1;

        while(!q.isEmpty()){
            int s = fires.size();
            for(int i=0;i<s;i++){
                Location f = fires.poll();
                int row = f.row;
                int col = f.col;

                for(int j=0;j<4;j++){
                    int nx = row + dx[j];
                    int ny = col + dy[j];
                    if(nx >= 0 && nx < R && ny >= 0 && ny < C){
                        if(check_fire[nx][ny] != -1 && map[nx][ny] != '#') {
                            check_fire[nx][ny] = -1;
                            fires.offer(new Location(nx, ny));
                        }
                    }
                }
            }

            int k = q.size();
            for(int i=0;i<k;i++){
                Location x = q.poll();
                int row = x.row;
                int col = x.col;
                for(int j=0;j<4;j++){
                    int nx = row + dx[j];
                    int ny = col + dy[j];

                    if(checkLocation(nx, ny)){
                        q.offer(new Location(nx, ny));
                        check[nx][ny] = check[row][col] + 1;
                    }
                }
            }
        }


    }

    static boolean checkLocation(int row, int col){
        if(row < 0 || row > R-1 || col < 0 || col > C-1)    return false;
        if(check_fire[row][col] == -1 || check[row][col] != 0  || map[row][col] == '#')  return false;
        return true;
    }
}
