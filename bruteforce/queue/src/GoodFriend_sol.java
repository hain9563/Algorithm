import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class GoodFriend_sol {
    public static void main(String[] args) throws Exception{
        List<Integer>[] que = new LinkedList[21];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<que.length; i++)
            que[i] = new LinkedList();

        int N,K;
        String[] line = in.readLine().split("[ ]");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);


        int tmp = 0;
        long answer=0;
        for(int i=0; i<N; i++) {
            tmp = in.readLine().length();       //이름의 길이를 입력받음
            while(!que[tmp].isEmpty()) {
                int t = que[tmp].get(0);
                if(i - t <= K) {        //i는 등수, t는 해당 길이의 첫번째 값    kevins일 때 3 - 1 <= 3 이므로
                    answer+=que[tmp].size();
                    System.out.println("add answer : " + Arrays.toString(que));
                    System.out.println("answer : "+answer);
                    System.out.println("t : "+t+" i : "+ i);
                    break;
                }else {
                    que[tmp].remove(0);
                    System.out.println("remove : " + Arrays.toString(que));
                }
            }
            que[tmp].add(i);       //처음에 비어있으면 등수를 넣어줌
            System.out.println("add" + Arrays.toString(que));
        }
        System.out.println(Arrays.toString(que));
        System.out.println(answer);
        out.write(answer+"\n");
        out.flush();
    }
}