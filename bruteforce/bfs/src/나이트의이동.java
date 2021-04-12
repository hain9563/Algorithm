import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 나이트의이동 {
    public static class Location{
        int row;
        int col;
        public Location(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    static int[][] check;
    static Location dest, start;
    static int chess_size;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        for(int i=0;i<testcase;i++){
            chess_size = sc.nextInt();  //체스판 한 변의 길이
            check = new int[chess_size][chess_size];
            start = new Location(sc.nextInt(), sc.nextInt());   //출발지점
            dest = new Location(sc.nextInt(), sc.nextInt());    //도착지점
            System.out.println(bfs(start));

        }
    }

    public static int bfs(Location x){
        Queue<Location> q = new LinkedList<>();
        int[] dx = {1,2,2,1,-1,-2,-2,-1};
        int[] dy = {2,1,-1,-2,-2,-1,1,2};
        q.offer(x);
        check[x.row][x.col] = 1;
        while(!q.isEmpty()){
            Location loc = q.poll();
            int row = loc.row;
            int col = loc.col;

            for(int i=0;i<8;i++){
                int nx = row + dx[i];
                int ny = col + dy[i];

                if(nx < 0 || nx > chess_size-1 || ny < 0 || ny > chess_size-1)  continue;   //체스판을 벗어난 경우
                if(check[nx][ny] != 0) continue;    //이미 왔던 곳인 경우

                q.offer(new Location(nx, ny));
                check[nx][ny] = check[row][col] + 1;
            }
        }
        return check[dest.row][dest.col] - 1;
    }
}
