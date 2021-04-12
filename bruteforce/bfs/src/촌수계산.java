import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 촌수계산 {
    static int[][] family;
    static Queue<Integer> q = new LinkedList<>();
    static int check[];
    static int p2;
    static void bfs(int start){
        q.offer(start);
        check[start] = 1;
        while(!q.isEmpty()){
            start = q.poll();
            for(int i=1;i<family.length;i++){
                if(check[i] == 0 && family[start][i] == 1 ){
                    q.offer(i);
                    check[i] = check[start]+1;
                }
            }
        }
        System.out.println(check[p2] == 0 ? -1 : check[p2]-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //사람수
        int p1 = sc.nextInt();
        p2 = sc.nextInt();
        int M = sc.nextInt();   //부모 자식 간의 관계의 개수

        family = new int[N+1][N+1];
        check = new int[N+1];
        for(int i=0;i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextByte();
            family[a][b] = 1;
            family[b][a] = 1;
        }

        bfs(p1);


    }
}
