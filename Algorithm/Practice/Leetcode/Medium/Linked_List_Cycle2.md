# Linked List Cycle 2

- [문제](https://leetcode.com/problems/linked-list-cycle-ii/)
- 풀이
    - 2021.09.30 (실패)

# 내 풀이
- 실패

# 정답1
- https://www.youtube.com/watch?v=SPKJz8oPJo4
- walker : 한번에 한칸씩
- runner : 한번에 두칸씩 직진
- 노드 모양 축약(임의)
```
o x O x x
    x   x
    x x X
```
- 위에서 O모양이 루프의 시작. 시작(o)부터 시계방향으로 돈다고 생각
    - A : 시작노드부터 루프의 처음 노드까지 길이(2)
    - B : 루프 전체의 길이(8)
    - X : 루프의 처음노드부터 현재 노드까지의 길이
- 만날때까지의 간 거리
    - walker : A + X
    - runner : A + n*B + X (n은 바퀴수)

- 2*walker = runner
    - (식으로 표현하면) 2A + 2X = A + n*B + X
    - (정리하면) A + X = n*B
- 포인트
    - `A + X = n*B`
    - 이 말은 루프 내에서 walker와 runner가 만난 지점에서 A만큼 더하면 루프의 시작(O)만큼 온다는 말
    - 또한 만난 지점에서 1칸씩 더해서 A만큼 건너와서 루프의 시작지점만큼 올 때, 시작노드(o)에서 한 노드(check)를 둬서 1칸씩 더해서 A만큼 건너온다면 둘은 만난다는 것
```
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;

        while (runner != null) {
            runner = runner.next;
            if (runner != null) {
                walker = walker.next;
                runner = runner.next;
                if (walker == runner) {
                    break;
                }
            } else {
                break;
            }
        }

        if (runner == null) {
            return null;
        }
        // 루프가 있는지 없는지 확인 끝.
        // walker와 runner가 둘 다 만났음

        // 같이 가는 것 체크
        ListNode check = head;
        while (check != walker) { // check != runner 여도 됨
            check = check.next;
            walker = walker.next; // walker = walker.next; 여도 됨
        }

        return check;
    }
}
```


# 정답2
- https://leetcode.com/problems/linked-list-cycle-ii/discuss/44774/Java-O(1)-space-solution-with-detailed-explanation.
- 원리는 정답1과 같다

```
public class Solution {
            public ListNode detectCycle(ListNode head) {
                ListNode slow = head;
                ListNode fast = head;
        
                while (fast!=null && fast.next!=null){
                    fast = fast.next.next;
                    slow = slow.next;
                    
                    if (fast == slow){
                        ListNode slow2 = head; 
                        while (slow2 != slow){
                            slow = slow.next;
                            slow2 = slow2.next;
                        }
                        return slow;
                    }
                }
                return null;
            }
        }
```