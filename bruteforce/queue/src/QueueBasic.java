import java.util.NoSuchElementException;
/*
기본적으로 LinkedList 로 구현, 제네릭 타입으로 구현함
                    --------------------------
    remove  <----    first               last    <---- add
                    --------------------------
add(item) : last에서 추가
remove() : first의 item을 제거
peek() : first의 item을 조회
isEmpty() : 큐가 비었는지 확인
 */


class Queue<T>{
    class Node<T>{  //노드 객체는 외부 노출을 막기 위해 private로 선언
        private T data;
        private Node<T> next;   //다음 노드

        public Node(T data){
            this.data = data;
        }
    }

    private Node<T> first;  //앞
    private Node<T> last;   //뒤
    private int size = 0;

    public void add(T item){
        Node<T> t = new Node<T>(item);  // node 생성

        if(last != null){   //마지막 노드가 있다면
            last.next = t;
        }
        last = t;
        if(first == null){  //queue가 비어있다면
            first = last;
        }
        size++;
    }

    public T remove(){
        if(first == null){  //queue가 비어있다면
            throw new NoSuchElementException();
        }

        T data = first.data;    //  front를 비우기 전 비울 front 노드 백업
        first = first.next;     //  다음 node를 front로 만들어줌줌

        if (first == null){     //  이때 비운 후 큐가 텅 비면 last도 null
            last = null;
        }
        size--;
        return data;
    }

    public T peek(){
        if(first == null){
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return first == null;
    }
}

public class QueueBasic {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.size());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.peek());
        System.out.println(q.isEmpty());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
    }

}
