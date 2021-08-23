# Add Two Numbers

- [문제](https://leetcode.com/problems/add-two-numbers/)

## 내 풀이
- 실패
- 노드는 아직도 익숙치 않다.
```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
    }
}
```

## 타인 풀이
- https://leetcode.com/problems/add-two-numbers/discuss/1010/Is-this-Algorithm-optimal-or-what
- 아래 부분에서 은근 헤맸다..
    - 메모리의 주소 이해하기!!
    ```
    ListNode sentinel = new ListNode(0);
    ListNode d = sentinel;
    ..(중략)..

    return sentinel.next;
    ```
```
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }
}
```
- 메인함수 넣어서 테스트
```
import java.util.List;

public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
      public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode c1 = l1;
            ListNode c2 = l2;
            ListNode sentinel = new ListNode(0);
            ListNode d = sentinel;
            int sum = 0;

            while (c1 != null || c2 != null) {
                  sum /= 10;
                  if (c1 != null) {
                        sum += c1.val;
                        c1 = c1.next;
                  }
                  if (c2 != null) {
                        sum += c2.val;
                        c2 = c2.next;
                  }
                  d.next = new ListNode(sum % 10);
                  d = d.next;
            }
            if (sum / 10 == 1)
                  d.next = new ListNode(1);
            return sentinel.next;
      }

      public static void main(String[] args) {
            ListNode l1 = new ListNode(2);
            l1.next = new ListNode(4);
            l1.next.next = new ListNode(3);

            ListNode l2 = new ListNode(5);
            l2.next = new ListNode(6);
            l2.next.next = new ListNode(4);

            Solution s = new Solution();
            ListNode result = s.addTwoNumbers(l1, l2);
//            System.out.println(result);

            System.out.println(result.val);
            System.out.println(result.next.val);
            System.out.println(result.next.next.val);

      }
}
```