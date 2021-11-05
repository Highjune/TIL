# Binary_Tree_Right_Side_View
- [문제](https://leetcode.com/problems/binary-tree-right-side-view/description/)
- BFS
- 풀이
    1. 2021.11.04 (실패)

# 내 풀이
- 거의 다 풀었는데 실패. 주어진 TestCase는 통과했지만, Input이 [1, 2]일 때, 결과는 [1, 2] 이어야 하는데 계속 [1, 2, 2]가 나왔다.
- BFS인 것도 미리 알았다.
```
class Solution {
    List<Integer> list = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        traverse(root);
        return list;
    }
    
    // BFS 로 제일 오른쪽부터 있는지 확인 후 넣기
    public void traverse(TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        if (root.right != null) {
            traverse(root.right);
        } else {
            if (root.left != null) {
                traverse(root.left);    
            } else {
                return;
            }
            list.add(root.left.val);
        }

    }
}
```



# 타인 풀이
- https://www.youtube.com/watch?v=o_MVBFqazfE&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=18
- Tree BFS
- Queue로 풀었음
    - 층마다 처리.
```
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0 ; i < size ; i++) {
                TreeNode cur = q.poll();
                if (i == size - 1) ret.add(cur.val); // 이것 빼고 나머지는 다 boilerplate
                if (cur.left != null) q.offer(cur.left); // 왼쪽을 먼저 넣어야지 오른쪽이 늦게 나온다. (자료구조 Queue 특성)
                if (cur.right != null) q.offer(cur.right);
            }
        }
        
        return ret;
    }
    
}
```
- 즉 아래는 Tree BFS에서 공통적으로 사용할 수 있는 `boilerplate`이다. 
```
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0 ; i < size ; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) q.offer(cur.left); 
                if (cur.right != null) q.offer(cur.right);
            }
        }
        
        return ret;
    }
    
}
```