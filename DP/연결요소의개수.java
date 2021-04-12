import java.util.Scanner;

public class 연결요소의개수 {
    static int[] check;
    static int[][] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new int[n+1][n+1];
        check = new int[n+1];

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        int count = 0;
        for(int i=1;i<check.length;i++){
            if(check[i] == 1)   continue;
            dfs(i);
            count++;
        }
        System.out.println(count);
    }

    static void dfs(int start){
        if(check[start] == 1)   return;
        check[start] = 1;
//        System.out.println(start + " ");
        for(int i=1;i<graph.length;i++){
            if(graph[start][i] == 1){
                dfs(i);
            }
        }
    }
}
