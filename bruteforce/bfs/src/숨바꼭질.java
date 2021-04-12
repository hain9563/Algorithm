import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질 {
    static int check[];
    static int N,K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   //수빈이의 위치
        K = sc.nextInt(); // 동생의 위치
        check = new int[100002];

        System.out.println(bfs()-1);
//        System.out.println(Arrays.toString(check));
    }

    static int bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        check[N] = 1;
        while(!q.isEmpty()){
            int x = q.poll();

            if(x == K)  return check[K];
            if((Math.abs(K - x*2) == 1 ||x*2 <= K) && check[x*2] == 0 ){ //x*2가 K+1 혹은
                q.offer(x*2);
                check[x*2] = check[x] + 1;
            }
            if(x - 1 >= 0 && check[x-1] == 0 ){
                q.offer(x-1);
                check[x-1] = check[x] + 1;
            }
            if(x + 1 < check.length && check[x+1] == 0){
                q.offer(x+1);
                check[x+1] = check[x] + 1;
            }

        }
        return check[K];
    }
}
