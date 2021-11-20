# Min Stack
- https://leetcode.com/problems/min-stack/
- 풀이
    1. 21.8.25 (성공)
    2. 21.11.19 (성공)


# 내 풀이1
- 21.8.25
- 정확성 100%, 
- 120ms, 효율성 faster than 7.32% Others. ㅠㅠ
- 그래도 구현한 것에 의의를 두자. 
- (11.19) `그런데 생각해보니 stack을 구현하는데 stack을 쓰면 안될 것 같음`...;;
```
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class MinStack {

    Stack<Integer> minStack;
    List<Integer> minList;

    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<Integer>();
        minList = new ArrayList<Integer>();
    }

    public void push(int val) {
        minStack.push(val);
        minList.add(val);
        Collections.sort(minList);
    }

    public void pop() {
        int k = minStack.pop();
        for (int i = 0 ; i < minList.size() ; i++) {
            if (k == minList.get(i)) {
                minList.remove(i);
            }
        }
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return minList.get(0);
    }

}
```

# 내 풀이2
- 21.11.19
- 정확도 100%
- Stack을 사용하지 않고 풀긴 풀었음
- faster than 51.27%
```
public class MinStack {

    List<Integer> list;
    int globalMin = Integer.MAX_VALUE;

    public MinStack() {
         list = new ArrayList<>();
    }

    public void push(int val) {
        list.add(val);
        if (globalMin > val) globalMin = val;
    }

    public void pop() {
        list.remove(list.size() - 1);
        int localMin = Integer.MAX_VALUE;
        for (int k : list) {
            if (localMin > k) localMin = k;
        }
        globalMin = localMin;
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return globalMin;
    }

}
```

# 내 풀이3
- 21.11.20
- 타인 풀이1 보고 따라 풀어봤음
- 대신 MinStack() {} 초기화 메서드에도 초기화 기능 넣었음
```
class MinStack {
    
    Node head;

    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(head.min, val), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
    
    private class Node {
        int min;
        int val;
        Node next;
        
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
        
    }
}

```


# 타인 풀이1
- https://leetcode.com/problems/min-stack/discuss/49010/Clean-6ms-Java-solution
- 효율 6ms 
- 아직도 노드가 익숙치 않은데 잘 활용하면 이렇게 잘 쓸 수 있구나! 
- 헤더의 시작부분에 계속 새로운 헤더를 붙이고 그 곳에 항상 최소값을 저장한다.
```
class MinStack {
	private Node head;
        
    public void push(int x) {
        if (head == null) 
            head = new Node(x, x, null);
        else 
            head = new Node(x, Math.min(x, head.min), head);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }   
        
    private class Node {
        int val;
        int min;
        Node next;
            
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
```

## 타인 풀이2
- https://www.youtube.com/watch?v=5MnhCfeLyhg&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=27
```
class MinStack {
    
    Stack<Node> s = new Stack<>();
    
    class Node {
        int val;
        int min;
        
        Node (int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    public MinStack() {
        
    }
    
    public void push(int val) {
        Node node = null;
        if (s.isEmpty()) {
            node = new Node(val, val);
        } else{
            node = new Node(val, val > s.peek().val ? s.peek().val : val);
        }
        
        s.push(node);
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().val;
    }
    
    public int getMin() {
        return s.peek().min;
    }
    
}
```