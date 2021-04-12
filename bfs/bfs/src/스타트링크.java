import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 스타트링크 {
    static int[] check;
    static int F,S,G,U,D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();   // f층으로 이루어진 고층건물 , 최대 10만
        S = sc.nextInt();   // 강호의 현재 위치 s층
        G = sc.nextInt();   // 스타트링크의 위치
        U = sc.nextInt();   // + U층만큼 움직일 수 있음
        D = sc.nextInt();   // - D층만큼 움직일 수 있음
        check = new int[F+1];
        int result = bfs();
        if(result == -1)    System.out.println("use the stairs");
        else System.out.println(result - 1);
    }

    static int bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        check[S] = 1;
        while(!q.isEmpty()){
            int x = q.poll();
            if(x == G)  return check[G];
            if(x + U <= F && check[x + U] == 0){
                check[x + U] = check[x] + 1;
                q.offer(x+U);
            }
            if(x - D > 0 && check[x - D] == 0){
                check[x - D] = check[x] + 1;
                q.offer(x - D);
            }
        }
        return -1;
//        System.out.println(check[G]);
    }
}
