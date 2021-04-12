import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 상범빌딩 {
    public static class Location{
        int floor;
        int row;
        int column;
        public Location(int floor, int row, int column){
            this.floor = floor;
            this.row = row;
            this.column = column;
        }
        public void printLoc(){
            System.out.println("floor : "+floor+" row : "+ row+ " column : "+ column);
        }
    }
    static String[][][] maze;
    static Location start = null;
    static Location exit = null;
    static int check[][][];
    static int L,R,C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            maze = new String[L][R][C];
            check = new int[L][R][C];
            if(L == 0 && R == 0 && C == 0)  break;

            for(int i=0;i<L;i++){
                for(int j=0;j<R;j++){
                    String input = br.readLine();
                    if(input.contains("S")) start = new Location(i, j, input.indexOf("S"));
                    if(input.contains("E")) exit = new Location(i, j, input.indexOf("E"));
                    maze[i][j] = input.split("");
                }
                br.readLine();
            }

            bfs();
//            for(int i=0;i<L;i++){
//                for(int j=0;j<R;j++){
//                    for(int k=0;k<C;k++) {
//                        System.out.print(maze[i][j][k]+ " ");
//                    }
//                    System.out.println("");
//                }
//                System.out.println("");
//            }
//
//            start.printLoc();
//            exit.printLoc();

        }
    }

    public static void bfs(){
        Queue<Location> q = new LinkedList<>();
        int[] dx = {-1,1,0,0,0,0};
        int[] dy = {0,0,-1,1,0,0};
        int[] dz = {0,0,0,0,-1,1};
        q.offer(start);
        check[start.floor][start.row][start.column] = 1;
        while(!q.isEmpty()){
            Location x = q.poll();
            int floor = x.floor;
            int row = x.row;
            int column = x.column;

            for(int i=0;i<6;i++){
                int nx = floor + dx[i];
                int ny = row + dy[i];
                int nz = column + dz[i];

                if(checkLocation(nx, ny, nz)){
                    q.offer(new Location(nx,ny,nz));
                    check[nx][ny][nz] = check[floor][row][column] + 1;
                }
            }
        }
        int minutes = check[exit.floor][exit.row][exit.column]-1;
        if(minutes < 0)   System.out.println("Trapped!");
        else    System.out.println("Escaped in "+ minutes+ " minute(s).");
    }

    static boolean checkLocation(int floor, int row, int col){
        if(floor < 0 || floor > L-1 || row < 0 || row > R-1 || col < 0 || col > C-1)  return false;
        if(check[floor][row][col] != 0 || maze[floor][row][col].equals("#") )   return false;
        return true;
    }
}
