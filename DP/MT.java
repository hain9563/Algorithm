import java.util.ArrayList;
import java.util.Scanner;

//https://www.youtube.com/watch?v=DBgcB9Se5S4

public class MT {
    static int[] choice;
    static int[] check;
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();   //버스에 태울 수 있는 사람수
        ArrayList<Integer> cycle = new ArrayList<>();

        choice = new int[n+1];
        check = new int[n+1];
        visited = new int[n+1];

        for(int i=1;i<n+1;i++){
            choice[i] = sc.nextInt();
        }

        for(int i=1;i<n+1;i++){
            if(check[i] == 0){
                cycle.add(dfs(i,1,i));
            }
        }
        System.out.println(cycle);
    }

    static int dfs(int x,int cnt, int start) {
        if(check[x] != 0){
            if(start != visited[x]) return 0;
            return cnt - check[x];
        }
        check[x] = cnt;
        visited[x] = start;
        return dfs(choice[x], cnt+1, start);
    }
}
