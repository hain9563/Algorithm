import java.util.*;

public class BFS와DFS {
    static int node[][];
    static boolean check[];
    static Queue<Integer> q = new LinkedList<>();
    static void dfs(int start){
        if(check[start])   return;  //이미 방문했으면 종료
        check[start] = true;
        System.out.print(start+" ");
        for(int i=1;i<node.length;i++){
            if(!check[i] && node[start][i] == 1){   //자식노드 방문
                dfs(i);
            }
        }
    }

    static void bfs(int x){
        q.offer(x);
        check[x] = true;
        while(!q.isEmpty()){
            x = q.poll();
            System.out.print(x+" ");
            for(int i=1;i<node.length;i++){
                if(!check[i] && node[x][i] == 1){   //자식노드들 방문
                    q.offer(i);
                    check[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        node = new int[N+1][N+1];
        check = new boolean[N+1];

        int a, b;
        for(int i=0;i<M;i++){
            a = sc.nextInt();
            b = sc.nextInt();
            node[a][b] = 1;
            node[b][a] = 1;
        }

        dfs(V);
        Arrays.fill(check, false);
        System.out.println("");
        bfs(V);
    }
}
