# Symmetric_tree


# 내 풀이
- 실패
- recursive로 할 것 같았는데 또 node, recursive 문제를 틀렸다. 더 많이 풀어봐야 할듯하다


# 타인 풀이1
- recursive
```
public boolean isSymmetric(TreeNode root) {
    return root==null || isSymmetricHelp(root.left, root.right);
}

private boolean isSymmetricHelp(TreeNode left, TreeNode right){
    if(left==null || right==null)
        return left==right;
    if(left.val!=right.val)
        return false;
    return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
}
```
