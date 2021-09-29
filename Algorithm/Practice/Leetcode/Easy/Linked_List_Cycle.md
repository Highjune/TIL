# Linked List Cycle
- [문제](https://leetcode.com/problems/linked-list-cycle/)
- 풀이
    - 2021.09.29

# 내 풀이
- 실패
- 문제를 무슨 말인지 이해가 안됐음. 정답1 영상 보고 이해함

# 정답1
- https://www.youtube.com/watch?v=3dR3UtADdBQ
- 시간복잡도 : O(N)
- 공간복잡도 : O(1)
- 포인트
    - 사이클이 있으면 둘은 언젠가 만남
    - 사이클이 없으면 러너가 먼저 null에 닿음
```
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        
        while (runner != null) {
            runner = runner.next;
            if (runner != null) {
                runner = runner.next;
                walker = walker.next;                
                if (runner == walker) {
                    break;
                }
            } else {
                break;
            }
        }
        
        if (runner == null) {
            return false;
        } else {
            return true;
        }
    }
}
```

# 정답2
- https://leetcode.com/problems/linked-list-cycle/discuss/44489/O(1)-Space-Solution
```
public boolean hasCycle(ListNode head) {
    if(head==null) return false;
    ListNode walker = head;
    ListNode runner = head;
    while(runner.next!=null && runner.next.next!=null) {
        walker = walker.next;
        runner = runner.next.next;
        if(walker==runner) return true;
    }
    return false;
}
```