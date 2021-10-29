# Sum_Of_Left_Leaves
- [문제](https://leetcode.com/problems/sum-of-left-leaves/description/)
- DFS
- 풀이
    1. 2021.10.29(실패)

# 내 풀이
- 문제는 왼쪽에 달려있는 것 중에서 제일 마지막 노드들의 합을 구하는 것


- (문제 잘못 이해하고 풀었음) 아래처럼 풀면 모든 트리에 달려있는 왼쪽에 있는 node들의 합
```
class Solution {
    int ret = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root);
        return ret;
    }
    
    public void helper(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            ret += root.left.val;
            helper(root.left);
        }
        if (root.right != null) {
            helper(root.right);
        }
    }
}
```


# 타인 풀이
- https://www.youtube.com/watch?v=g16fLbVcK0U&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=15
- DFS
- 막상 풀이를 보니 쉬웠지만, 처음에 생각하기에는 쉽지 않았다. traverse의 리턴 타입을 boolean으로 설정함으로써 leafNode인지 아닌지 판단하도록 하는 것이 포인트
```
class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root != null) traverse(root);
        return sum;
    }
    
    public boolean traverse(TreeNode root) {
        if (root.left != null) {
            boolean isLeafNode = traverse(root.left);
            if (isLeafNode) sum += root.left.val;            
        }
        if (root.right != null) traverse(root.right);
        return root.left == null && root.right == null;
    }
    
}
```