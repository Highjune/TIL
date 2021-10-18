# Maximum_Depth_of_N-ary_Tree
- [문제](https://leetcode.com/problems/maximum-depth-of-n-ary-tree/)
- 풀이
    - 2021.10.15(실패)

# 내 풀이
- 실패. 아쉽다

# 타인 풀이
- https://www.youtube.com/watch?v=t1NkSkVHcnA&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=41
```
class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {
            depth++;
            int size = q.size();
            for (int i = 0 ; i < size ; i++) {
                Node node = q.poll();
                for (Node children : node.children) {
                    q.offer(children);
                }
            }
        }
        return depth;
    }
}
```