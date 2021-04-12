import java.util.*;

public class 퍼즐_2 {
    static int[] check;
    static int puzzle;
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        puzzle = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int a = sc.nextInt();
                if(a == 0)  a = 9;
                puzzle = puzzle*10 + a;
            }
        }
        bfs(puzzle);

        if(map.containsKey(123456789))  System.out.println(map.get(123456789));
        else    System.out.println(-1);
    }

    static void bfs(int puzzle){
        Queue<Integer> q = new LinkedList<>();
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        q.offer(puzzle);
        map.put(puzzle, 0);
        while(!q.isEmpty()) {
            int x = q.poll();
            String now = Integer.toString(x);
            int start = now.indexOf('9');
            int row = start / 3;
            int col = start % 3;

            for(int i=0;i<4;i++){
                int nx = row + dx[i];
                int ny = col + dy[i];

                if(nx < 0 || nx >= 3 || ny < 0 || ny >= 3)    continue;
                //swap
                char temp = now.charAt(nx*3+ny);
                StringBuilder after = new StringBuilder(now);
                after.setCharAt(start, temp);
                after.setCharAt(nx*3+ny, '9');
                int after_num = Integer.parseInt(after.toString());

                if(map.containsKey(after_num))  continue;   //이미 해봤던 방법이면
//                System.out.println(temp);
//                System.out.println(after_num);
                q.offer(after_num);
                map.put(after_num, map.get(x)+1);
            }
        }
    }
}
