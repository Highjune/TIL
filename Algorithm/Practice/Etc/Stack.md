# 타인 풀이
- https://youtu.be/whVUYv0Leg0
```
import java.util.EmptyStackException;
import java.util.Stack;

class Stack<T> { // 특정한 T타입
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
    // stack은 맨 위에 올라가 있는 주소만 알고 있으면 된다.
    public Node<T> top;

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        Node<T> t = new Node<T>(item); // push 할 item 으로 Node생성
        t.next = top; // 생성한 Node를 top 앞에 위치
        top = t; // 그 Node가 top이 된다.
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class Test {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());

    }
}




```