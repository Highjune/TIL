# Binary Tree Inorder Traversal
- [문제](https://leetcode.com/problems/binary-tree-inorder-traversal/)


# 내 풀이
- 실패, 풀이 2가지 방법보고 혼자 다시 풀어봄
=

# 타인풀이1
- recursive
- https://leetcode.com/problems/binary-tree-inorder-traversal/solution/
```
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }
    
    public void helper(TreeNode root, List<Integer> list) {
        
        if (root != null) {
            if (root.left != null) {
                helper(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                helper(root.right, list);   
            }
        }
        
    }
}
```


# 타인풀이2
- Stack 활용
- https://leetcode.com/problems/binary-tree-inorder-traversal/solution/
```
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}
```

