import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 퍼즐{
    public static class Location{
        int row;
        int col;
        public Location(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static Location start;
    static int[][] check;
    static int[][] puzzle;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        puzzle = new int[3][3];
        check = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                puzzle[i][j] = sc.nextInt();
                if(puzzle[i][j] == 0){
                    start = new Location(i,j);
                }
            }
        }
        bfs();

    }

    static void bfs(){
        Queue<Location> q = new LinkedList<>();
        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        q.offer(start);
        check[start.row][start.col] = 1;
        while(!q.isEmpty()){
            Location x = q.poll();
            int row = x.row;
            int col = x.col;
            if(puzzle[0][0] == 1 && puzzle[0][1] == 2 && puzzle[0][2] == 3 && puzzle[1][0] == 4 &&
            puzzle[1][1] == 5 && puzzle[1][2] == 6 && puzzle[2][0] == 7 && puzzle[2][1] == 8 && puzzle[2][2] == 0)  System.out.println(check[row][col]);
            for(int i=0;i<4;i++){
                int nx = row + dx[i];
                int ny = col + dy[i];

                if(nx>=0 && nx<3 && ny>=0 && ny<3 && check[nx][ny] == 0){
                    q.offer(new Location(nx, ny));
                    int temp = puzzle[nx][ny];
                    puzzle[nx][ny] = puzzle[row][col];
                    puzzle[row][col] = temp;
                    for(int a=0;a<3;a++){
                        for(int b=0;b<3;b++){
                            System.out.print(puzzle[a][b] + " ");
                        }
                        System.out.println("");
                    }

                    check[nx][ny] = check[row][col] + 1;
                    System.out.println("");
                }
            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(check[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
