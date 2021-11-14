# Copy_List_With_Random_Pointer
- [문제](https://leetcode.com/problems/copy-list-with-random-pointer/)
- 해시맵
- 풀이
    1. 2021.11.14 (실패)
 
# 내 풀이
- 처음에는 문제 뜻을 잘 이해하지 못하였다. 
- 문제의 요지는 새로운 Linked List를 반환하되 포인터를 2개(next, random)를 어떻게 처리할 것인가! 

# 타인 풀이
- https://www.youtube.com/watch?v=S9mNjtoyWKw&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=22
```
// map : 오리지널 노드 -> 카피노드
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        Node cur = newHead;
        map.put(head, newHead);
        
        while (head != null) {
            // next
            if (head.next != null) {
                if (!map.containsKey(head.next)) {
                    map.put(head.next, new Node(head.next.val));
                }
                cur.next = map.get(head.next);
            }
        
            // random
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new Node(head.random.val));
                }
                cur.random = map.get(head.random);
            }
            
            // move pointer
            head = head.next;
            cur = cur.next;
                
        }
        return newHead;
    }
}

```
