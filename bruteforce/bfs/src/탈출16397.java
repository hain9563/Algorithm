import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈출16397 {
    static int n,t,g;
    static int[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   //다섯자리 숫자
        t = sc.nextInt();   //최대 t회 버튼을 누를 수 있음
        g = sc.nextInt();   //최종적으로 만들어야 하는 수
        check = new int[100000];
        bfs();
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        check[n] = 1;
        while(!q.isEmpty()){
            int x = q.poll();
            if(x == g){
                if(check[g]-1 <= t) {
                    System.out.println(check[g] - 1);
                    return;
                }
                else{
                    System.out.println("ANG");
                    return;
                }
            }
            if(x + 1 < 100000 && check[x+1] == 0){
                q.offer(x+1);
                check[x+1] = check[x] + 1;
            }
            if(x != 0 && x*2<100000){
                String a = Integer.toString(x*2);
                String highest = Integer.toString(Integer.parseInt(a.substring(0,1))-1);
                int nx = Integer.parseInt(highest + a.substring(1,a.length()));
                if(nx < 100000 && check[nx] == 0){
                    q.offer(nx);
                    check[nx] = check[x] + 1;
                }
            }

        }
        System.out.println("ANG");
    }
}
