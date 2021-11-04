# Validate_Binary_Search_Tree
- [문제](https://leetcode.com/problems/validate-binary-search-tree/description/)
- 풀이
    1. 2021.11.04 (실패)

# 내 풀이
- BST를 잘못 이해했었다. 테스트 케이스 80개 중에 72개밖에 통과를 못했다.
- `[5,4,6,null,null,3,7]` 가 왜 false인지 이해를 못했었다
- 아래는 잘못 코딩한 코드
```
class Solution {
    public boolean isValidBST(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return true; // 체크 필요
        q.offer(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0 ; i < size ; i++) {
                TreeNode cur = q.poll();
                int curVal = cur.val;   
                if (cur.left != null) {
                    if (cur.left.val >= curVal) return false;
                    q.offer(cur.left);
                } 
                if (cur.right != null) {
                    if (cur.right.val <= curVal) return false;
                    q.offer(cur.right);
                }
            }
        }
        
        return true;
    }
}
```

# 타인 풀이
- https://www.youtube.com/watch?v=NTYNtdJQU88&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=20
