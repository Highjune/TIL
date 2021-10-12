# Binary_Tree_Level_Order_TraversalII
- [문제](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/)
- 풀이
    - 2021.10.12(?)

# 내 풀이
- 실패
- 또 recursive인줄 알았는데 노드는 Queue를 사용해도 된다는 것!


# 타인 풀이
- https://www.youtube.com/watch?v=3InqyEPZsw0&list=PL2mzT_U4XxDm7p6g1o3KeQMsyRLfzSaVW&index=11
- 명확
```
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for (int i = 0 ; i < size ; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            
            ret.add(0, level);
        }
        
        return ret;
        
    }
}
```