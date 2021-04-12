import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Queueee{
    private int[] queue;
    private int frontIndex = 0;
    private int backIndex = -1;

    Queueee(){

    }

    Queueee(int number){
        queue = new int[number];
    }

    public void push(int x) {
        queue[++backIndex] = x;
    }

    public int size() {
        return backIndex - frontIndex + 1;
    }

    public boolean isEmpty() {
        if (size()==0)
            return true;
        else
            return false;
    }

    public int  pop() {
        if (isEmpty())
            return -1;
        else
            return queue[frontIndex++];
    }

    public int front() {
        if (isEmpty())
            return -1;
        else
            return queue[frontIndex];
    }

    public int back() {
        if (isEmpty())
            return -1;
        else
            return queue[backIndex];
    }
}
public class Queue10845Again {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        Queueee queue = new Queueee(n);

        for(int i = 0; i <n; i++) {
            String[] command = br.readLine().split(" ");
            switch(command[0]) {
                case "push":
                    queue.push(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    System.out.println(queue.pop());
                    break;
                case "empty":
                    if (queue.isEmpty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case "front":
                    System.out.println(queue.front());
                    break;
                case "back":
                    System.out.println(queue.back());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
            }
        }
    }
}
