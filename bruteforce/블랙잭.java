import java.util.ArrayList;
import java.util.Scanner;

public class 블랙잭 {
//    static ArrayList<Integer> sum_arr = new ArrayList<>();
    static int answer = 0;
    static int m = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();
        int[] card = new int[n];
        boolean[] visit = new boolean[n];
        for(int i=0;i<n;i++){
            card[i] = sc.nextInt();
        }
        comb(card, n, 3, 0, visit);
        System.out.println(answer);
    }

    static void comb (int[] cards, int n, int r , int start, boolean[] visit){
        if(r==0){
            int sum = 0;
            for(int i=0;i<cards.length;i++){
                if(visit[i]){
                    sum += cards[i];
                }
            }
            if(sum <= m){
                if(sum > answer){
                    answer = sum;
                }
            }
            return;
        }

        for(int i = start;i<cards.length;i++){
            visit[i] = true;
            comb(cards, n, r-1, i+1, visit);
            visit[i] = false;
        }
    }
}
