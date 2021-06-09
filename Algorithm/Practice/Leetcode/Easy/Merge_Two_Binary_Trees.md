# Merge Two Binary Trees
- [문제](https://leetcode.com/problems/merge-two-binary-trees/)




# 내 풀이
- 못 품
- 정말 쉬운것이지만 아직 트리구조와 recursion에 대해서 약한 상태. 공부해야 됨
- 풀이는 상대적으로 간단한 것 같음


# 타인 풀이1
- recursion으로
- https://leetcode.com/problems/merge-two-binary-trees/discuss/104299/Java-Solution-6-lines-Tree-Traversal
```
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        
        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(val);
        
        newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        
        return newNode;
    }
}
```
또는
```
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        else if(t1 == null) return t2;
        else if(t2 == null) return t1;
        TreeNode n= new TreeNode(t1.val+t2.val);
        n.left=mergeTrees(t1.left, t2.left);
        n.right=mergeTrees(t1.right, t2.right);
        return n;
    }
}
```



# 타인 풀이2
- 