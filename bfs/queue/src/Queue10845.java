import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Queuee <T>{
    class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
        }
    }
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public void push(T item){
        Node<T> t = new Node<T>(item);

        if(last != null){
            last.next = t;
        }
        last = t;
        if(first == null){  //queue가 비어있다면
            first = last;
        }
        size++;
    }

    public T pop(){
        if(first == null){
            return null;
        }
        T data = first.data;
        first = first.next;
        if(first == null){
            last = null;
        }
        size--;
        return data;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public T peek_front(){
        if(first == null){
            return null;
        }
        return first.data;
    }

    public T peek_back(){
        if(first == null){
            return null;
        }
        return last.data;
    }

    public int size(){
        return size;
    }
}

public class Queue10845 {
    public static void main(String[] args) throws IOException {
        Queuee <Integer> q = new Queuee<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        String[] cmd = new String[n];

        for(int i=0;i<n;i++){
            String s = br.readLine();
            cmd[i] = s;
        }

        for(int i=0;i<n;i++){

            if(cmd[i].substring(0,2).equals("pu")){
                String[] temp = cmd[i].split(" ");
                q.push(Integer.parseInt(temp[1]));
            }
            else if(cmd[i].equals("pop")){
                if(q.pop() == null){
                    System.out.println("-1");
                }else{
                    System.out.println(q.pop());
                }
            }
            else if(cmd[i].equals("size")){
                System.out.println(q.size());
            }
            else if(cmd[i].equals("empty")){
                System.out.println(q.isEmpty()? 1:0);
            }
            else if(cmd[i].equals("front")){
                if(q.peek_front() == null){
                    System.out.println("-1");
                }else{
                    System.out.println(q.peek_front());
                }
            }
            else if(cmd[i].equals("back")){
                if(q.peek_back() == null){
                    System.out.println("-1");
                }else{
                    System.out.println(q.peek_back());
                }
            }
        }
    }
}
