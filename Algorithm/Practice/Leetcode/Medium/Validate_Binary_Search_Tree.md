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
- 주어진 문제에 대해서 100% 이해하지 못하고 풀었다.
    - 즉, Example2에서 [5, 1, 4, null, null, 3, 6] 이 주어졌을 때, 5의 오른쪽에 달려있는 모든 속성들은 다 5보다 커야 한다. 해설에는 단순히 4가 있어서 틀렸다고 하지만 사실 3도 그 조건에 위배된다. 나는 오른쪽 직접 연결된 자식만 조건에 맞으면 되는 줄 알았는데 아니었다.
    - 그래서 Example2에서 3의 위치에 있는 노드는 5보다는 커야 되고 4보다는 작아야 한다.
```
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, false, false, 0, 0);
    }
    
    public boolean isValidBST(TreeNode root, boolean lowerBoundExist, boolean upperBoundExist, int lowerBound, int upperBound) {
        
        if (root == null) return true;
        // 베이스케이스 체크
        // 현재 노드가 lowerBound / upperBound를 침범하지 않는가.
        if (lowerBoundExist && root.val <= lowerBound) {
            return false;
        }
        
        if (upperBoundExist && root.val >= upperBound) {
            return false;
        }
        
        // 그렇지 않다면 재귀적으로 또 확인
        return isValidBST(root.left, lowerBoundExist, true, lowerBound, root.val)
                && isValidBST(root.right, true, upperBoundExist, root.val, upperBound);
    }
}
```