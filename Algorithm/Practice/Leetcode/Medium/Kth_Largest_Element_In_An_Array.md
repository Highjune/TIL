# Kth_Largest_Element_In_An_Array
- [문제](https://leetcode.com/problems/kth-largest-element-in-an-array/description/)
- 우선순위 큐
- 풀이
    1. 2021.10.29 (성공)

# 내 풀이
- 그런데 아래처럼 풀면 안되려나??
```
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - 1 -(k-1)];
    }
}
```



# 타인 풀이
- https://www.youtube.com/watch?v=ifGUwB_PCt4&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=19
- 좋은 발상!
- 우선순위 큐에 대해서 조금 더 알게 되었다.
- 우선순위 큐 : offer poll peek
    - 자바 : natural ordering, integer 같은 경우는 오름차순 정렬이 기본
    - offer : 3 2 1 5 4 -> poll : 1 2 3 4 5 시간복잡도 offer/poll O(logn)
- 문제 풀이 전략
    - 큐에는 k개의 원소를 보관
    - 이제껏 본 원소중 가장 큰 k개
    - 큐의 맨 앞에는 k개 중 가장 작은 것이 있다.
```
class Solution {
    
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public int findKthLargest(int[] nums, int k) {
        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);
            } else {
                if (num > pq.peek()) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
        return pq.peek();
    }
}
```