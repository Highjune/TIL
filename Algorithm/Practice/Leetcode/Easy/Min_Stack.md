# Min Stack
- https://leetcode.com/problems/min-stack/


# 내 풀이
- 정확성 100%, 
- 120ms, 효율성 faster than 7.32% Others. ㅠㅠ
- 그래도 구현한 것에 의의를 두자.
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
# 타인 풀이
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