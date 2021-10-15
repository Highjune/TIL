# Maximum_Depth_of_N-ary_Tree
- [문제](https://leetcode.com/problems/maximum-depth-of-n-ary-tree/)
- 풀이
    - 2021.10.15(푸는 중)

# 내 풀이
- 푸는 중
```
class Solution {
    int dep = 0;
    public int maxDepth(Node root) {
        helper(root);
        return dep;
    }
    
    public void helper(Node root) {
        if (root == null) return;
        if (root.children != null) {
            dep++;
            for (int i = 0 ; i < root.children.size() ; i++) {
                helper(root.children.get(i));
            }
        }
    }
}
```