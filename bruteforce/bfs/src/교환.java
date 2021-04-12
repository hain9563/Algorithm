import java.util.*;

public class 교환 {
    static Map<Integer, Integer> m = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int max = -1;
        int value_max = -1;

        bfs(n,k);
        for(Integer key : m.keySet()){
            Integer value = m.get(key);
            System.out.println(key+" : "+value);

        }

        for(Integer key : m.keySet()){
            value_max = Math.max(value_max, m.get(key));
        }
        for(Integer key : m.keySet()){
            if(value_max == 0)  break;
            if(m.get(key) == k){
                max = Math.max(max, key);
            }
        }
        if(value_max == 0)  System.out.println(-1);
        else    System.out.println(max);
    }

    public static void bfs(int n, int k){
        Queue<Integer> q = new LinkedList<>();
        int digits = (int) Math.log10(n)+1;
        q.offer(n);
        m.put(n, 0);
        while(!q.isEmpty()){
            int x = q.poll();
            if(m.get(x) == k)   return;
            for(int i=0;i<digits;i++){
                for(int j=i+1;j<digits;j++){
                    StringBuilder after = new StringBuilder(Integer.toString(x));
                    char temp = after.charAt(j);
                    after.setCharAt(j, after.charAt(i));
                    after.setCharAt(i, temp);
                    int after_num = Integer.parseInt(after.toString());
                    if(after.charAt(0) == '0')  continue;   //첫번째 자리가 0인 경우
//                    if(m.containsKey(after_num)) continue;
                    q.offer(after_num);
                    System.out.println(after_num);
                    m.put(after_num, m.get(x)+1);
                }
            }
        }
    }
}
