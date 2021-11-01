# Merge_K_Sorted_Lists
- [문제](https://leetcode.com/problems/merge-k-sorted-lists/description/)
- 우선순위 큐
- external sort
- 풀이
    1. 2021.11.01 (실패)

# 내 풀이
- 이진트리 아님. 그냥 Node인데 List로 연결된 것일 뿐. 너무 Node문제를 Tree구조로 되어있는 것을 많이 봐서 헷갈렸다. 기본 클래스 ListNode 멤버변수 잘 살펴보기!. 이것만 알았다면 크게 어렵진 않았을 듯


# 타인 풀이
- https://www.youtube.com/watch?v=DjMLYwtSp08&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=16
- 실용적인 문제라고 함
    - 데이터 베이스 이론에서, 무엇인가를 정렬해야 하는데 그게 한번에 다 메모리에 안 올라갈 떄, 어떻게 정렬할 것인가 할 때 이 개념을 구현
    - K개로 정렬된 파일로 나눠서 늘어뜨린 후, 정렬된 파일을 한 레코드씩 읽어들인다. K개로 나뉜 파일에 커서를 둔 후, 메모리에는 올라가있는 몇 개의 파일 중 다 읽은 파일은 내리고 다시 ~ 뭐 이런 식.
    - external sort 라고 함
- Priority Queue
    - 초기화
    - list.size -> k, priority q에는 각 리스트의 첫번째 원소를 삽입
    - while q is not empty
    - ListNode min = extractMin(q) -> 출력, q.offer(min.next);

```
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        ListNode ret = null;
        ListNode cur = null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,
                                            (a, b) -> a.val - b.val);
        
        for (ListNode node : lists) {
            if (node == null) continue;
            pq.offer(node);
        }
        
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) pq.offer(node.next);
            if (ret == null) {
                ret = node;
                cur = node;
            } else {
                cur.next = node;
                cur = node;
            }
        }
        
        return ret;
    }
}
```