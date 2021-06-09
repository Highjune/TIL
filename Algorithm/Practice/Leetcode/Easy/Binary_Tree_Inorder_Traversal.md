# Binary Tree Inorder Traversal
- [문제](https://leetcode.com/problems/binary-tree-inorder-traversal/)


# 내 풀이
- 실패


# 정답1
- recursive
- https://leetcode.com/problems/binary-tree-inorder-traversal/solution/
```
class Solution {
    public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
}
```

# 정답2
- 