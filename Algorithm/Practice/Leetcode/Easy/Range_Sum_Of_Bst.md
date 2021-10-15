# Range_Sum_Of_Bst
- [문제](https://leetcode.com/problems/range-sum-of-bst/)
- 풀이
    - 2021.10.15(성공) - [Binary Tree Inorder Traversal](https://github.com/Highjune/TIL/blob/main/Algorithm/Practice/Leetcode/Easy/Binary_Tree_Inorder_Traversal.md) 풀이 생각나서 둘 다로 풀어봄

# 내 풀이1
- 풀었음
- 노드 문제를 처음으로 제대로 푼 것인듯. 의미있었다.
```
class Solution {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high);
        return sum;
    }
    
    void helper(TreeNode root, int low, int high) {
        if (root == null) return;
        if (low <= root.val && root.val <= high) {
            sum += root.val;    
        }
        
        helper(root.left, low, high);
        helper(root.right, low, high);
    }
}
```

# 내 풀이2
- 더 효율적(내 풀이1보다 속도 더 빠름)
```
class Solution {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high);
        return sum;
    }
    
    void helper(TreeNode root, int low, int high) {
        if (root != null) {
            if (low <= root.val && root.val <= high) {
                sum += root.val;
            }
            if (root.left != null) {
                helper(root.left, low, high);
            }
            if (root.right != null) {
                helper(root.right, low, high);
            }
        }
    }
}
```