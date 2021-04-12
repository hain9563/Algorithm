/*
 front   -------------------  rear
         -------------------
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class DQNode{
    int data;
    DQNode rlink;
    DQNode llink;
}
class DQueue {
    DQNode front;
    DQNode rear;
    int size;

    public DQueue(){
        front = null;
        rear = null;
    }

    public boolean isEmpty(){
        return (front == null);
    }

    public void push_front(int item){
        DQNode newNode = new DQNode();
        newNode.data = item;
        if(isEmpty()){
            front = newNode;
            rear = newNode;
            newNode.rlink = null;
            newNode.llink = null;
        }else{
            front.llink = newNode;
            newNode.rlink = front;
            newNode.llink = null;
            front = newNode;
        }
        size++;
    }

    public void push_back(int item){
        DQNode newNode = new DQNode();
        newNode.data = item;
        if(isEmpty()){
            front = newNode;
            rear = newNode;
            newNode.rlink = null;
            newNode.llink = null;
        } else{
            rear.rlink = newNode;
            newNode.rlink = null;
            newNode.llink = rear;
            rear = newNode;
        }
        size++;
    }

    public int pop_front(){
        if(isEmpty()){
            return -1;
        } else{
            int item = front.data;
            if(front.rlink == null){    //한개만 존재할 경우
                front = null;
                rear = null;
            } else{
                front = front.rlink;
                front.llink = null;
            }
            size--;
            return item;
        }

    }

    public int pop_rear(){
        if(isEmpty()){
            return -1;
        } else{
            int item = rear.data;
            if(rear.llink == null){ //하나 인 경우
                front = null;
                rear = null;
            } else{
                rear = rear.llink;
                rear.rlink = null;
            }
            size--;
            return item;
        }
    }

    public int size(){
        return size;
    }

    public int peek_front(){
        if(isEmpty()){
            return -1;
        }else {
            return front.data;
        }
    }

    public int peek_rear(){
        if(isEmpty()){
            return -1;
        } else{
            return rear.data;
        }
    }
}

public class deque10866 {

    public static void main(String[] args) throws IOException {
        DQueue dq = new DQueue();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for(int i=0;i<n;i++){
            String[] cmd = bf.readLine().split(" ");
            switch(cmd[0]) {
                case "push_back":
                    dq.push_back(Integer.parseInt(cmd[1]));
                    break;
                case "push_front":
                    dq.push_front(Integer.parseInt(cmd[1]));
                    break;
                case "front":
                    System.out.println(dq.peek_front());
                    break;
                case "back":
                    System.out.println(dq.peek_rear());
                    break;
                case "size":
                    System.out.println(dq.size());
                    break;
                case "empty":
                    System.out.println(dq.isEmpty() ? 1: 0);
                    break;
                case "pop_front":
                    System.out.println(dq.pop_front());
                    break;
                case "pop_back":
                    System.out.println(dq.pop_rear());
                    break;
            }

        }

    }
}

