import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Card2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<n;i++){   //queue 값 채워넣기
            queue.add(i+1);
        }

        while(queue.size() > 1){    //queue의 size가 1이 될 때까지
            queue.remove();
            int num = queue.peek();
            queue.remove();
            queue.add(num);
        }
        System.out.println(queue.peek());
    }
}
