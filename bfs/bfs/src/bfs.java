import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bfs {
    static final int max_int = 10001;
    static int n, m, k, a, b;
    static int[] check = new int[max_int];
    static ArrayList<Integer> v[] = new ArrayList[max_int];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++) {
            check[i] = -1;
            v[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            v[a].add(b);
            v[b].add(a);
        }

        bfs();

        for(int i=1; i<=n; i++){
            System.out.println(check[i]);
        }
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        check[k] = 0;
        q.add(k);

        while(!q.isEmpty()){
            int node = q.poll();

            for(int i=0; i<v[node].size(); i++){
                int next = v[node].get(i);

                if(check[next] == -1){
                    check[next] = check[node] + 1;
                    q.add(next);
                }
            }
        }
    }
}
