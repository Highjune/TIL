# Merge Two Sorted Lists
- https://leetcode.com/problems/merge-two-sorted-lists/

# 내 풀이
- 실패
- 되풀이되는 노드같은 경우에는 recursion 을 떠올려보자


# 타인 풀이1
- https://leetcode.com/problems/merge-two-sorted-lists/discuss/9715/Java-1-ms-4-lines-codes-using-recursion
- recursion 를 매번 흐름 따라가기가 은근 까다롭다.
    - 시작, 시작의 다음 것, 마지막 리턴만 제대로 생각해보기!
    - 디버그 모드로 하나하나 따라가보면 재미있다!(아직도 좀 생소하지만!)
- 하지만 `Although this could be a beautiful solution, I think I won't use recursion for a O(n) solution. This solution will result into Stack overflow error with some-thousand elements input. It's nice but impractical.` 라는 커멘트가 있음
```
public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
}
```

# 타인 풀이2
- recursion 없이
- 메모리 값에 대한 이해가 더 명확
- 이 부분은 자주 쓰이니까 기억하기
    - dummy는 시작값, 그 다음의 값을 계속 기억하고 있는 것. 리턴하기 위해서
    - curr의 값은 현재의 포인터 위치
    ```
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    ..(중략)..

    return dummy.next;
    ```
- 답
```
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null) return l2;
    else if(l2 == null) return l1;

    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while(l1 != null && l2!= null){
        if(l1.val <= l2.val){
            curr.next = l1;
            l1 = l1.next;
        }else {
            curr.next = l2;
            l2 = l2.next;
        }
        curr = curr.next;
    }
    curr.next = l1 == null? l2:l1;
    return dummy.next;
}
```
