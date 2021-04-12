import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSLR {
    static String check[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            int A = sc.nextInt();   //before
            int B = sc.nextInt();   //after
            check = new String[10001];
            Arrays.fill(check, "");
            bfs(A,B);
            sc.nextLine();
        }

    }

    static void bfs(int A, int B){
        Queue<Integer> q = new LinkedList<>();
        q.offer(A);
        check[A] = "C";
        int digits = Math.max((int)(Math.log10(A)), (int)(Math.log10(B)));
        while(!q.isEmpty()){
            int x = q.poll();
            int D_num = x*2 % 10000;
            int L_num = L_rotate(x, digits);
            int R_num = R_rotate(x, digits);
            if(x == B)  System.out.println(check[B].substring(1,check[B].length()));
            if(check[D_num].equals("")){
                q.offer(D_num);
                check[D_num] = check[x] + "D";
            }
            if(x == 0) {
                q.offer(9999);
                check[9999] = check[x] + "S";
            }
            else{
                if (x - 1 >= 0 && x - 1 < 10000 && check[x - 1].equals("")) {
                    q.offer(x - 1);
                    check[x - 1] = check[x] + "S";
                }
            }
            if(check[L_num].equals("")){
                q.offer(L_num);
                check[L_num] = check[x] + "L";
            }
            if(check[R_num].equals("")){
                q.offer(R_num);
                check[R_num] = check[x] + "R";
            }

        }
    }

    static int L_rotate(int x, int digits){
        return x/(int) Math.pow(10,digits)+ (x % (int) Math.pow(10, digits)) * 10;
    }

    static int R_rotate(int x, int digits){
        return x/10 + (int) Math.pow(10,digits) * (x%10);
    }


}
