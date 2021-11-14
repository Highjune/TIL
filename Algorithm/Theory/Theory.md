# 알고리즘 이론 정리
- 카데인 알고리즘
    - https://sustainable-dev.tistory.com/23?category=809125
    - [연습문제](https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/)

- external sort
    - [연습문제](https://leetcode.com/problems/merge-k-sorted-lists/description/)


- Tree BFS의 boilerplate
    - https://www.youtube.com/watch?v=o_MVBFqazfE&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=18
    - [연습문제](https://leetcode.com/problems/binary-tree-right-side-view/submissions/)
```
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0 ; i < size ; i++) {
                TreeNode cur = q.poll();
                if (i == size - 1) ret.add(cur.val); // 이것 빼고 나머지는 다 boilerplate
                if (cur.left != null) q.offer(cur.left); // 왼쪽을 먼저 넣어야지 오른쪽이 늦게 나온다. (자료구조 Queue 특성)
                if (cur.right != null) q.offer(cur.right);
            }
        }
        
        return ret;
    }
    
}
```

- Boyer-Moore 알고리즘 (과반수 알고리즘)
    - [연습문제](https://leetcode.com/problems/majority-element/submissions/)


# 좋은 개념글 링크
- [Big-O 노테이션 쉽게 이해하기](https://joshuajangblog.wordpress.com/2016/09/21/time_complexity_big_o_in_easy_explanation/)
- [이진 탐색과 시간 복잡도 분석 (Binary Search and its Time Complexity Analysis)](https://jwoop.tistory.com/9)