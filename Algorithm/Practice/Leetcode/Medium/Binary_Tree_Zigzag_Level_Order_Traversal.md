# Binary_Tree_Zigzag_Level_Order_Traversal
- [문제](https://leetcode.com/problems/Binary_Tree_Zigzag_Level_Order_Traversal/description/)
- 풀이
    1. 2021.11.14 (성공)

# 내 풀이
- 컴파일 에러도 없이 한 번만에 풀었다.
- 트리의 하나의 레벨을 Queue의 사이즈로 매번 제한해서 하는 식으로 풀었다.(승지니어님 방식)
- 그리고 list의 역순은 list.add(0, element) 로 쉽게 적용.
- 한층씩 왼쪽 <--> 오른쪽의 순서 교차는 order를 주어서 적용했다..
```
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> retList = new ArrayList<>();
        if (root == null) return retList; 
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int order = 0;
        while (!q.isEmpty()) {
            order++;
            List<Integer> innerList = new ArrayList<>();
            int size = q.size();
            for (int i = 0 ; i < size ; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                
                if (node.right != null) {
                    q.offer(node.right);
                }
                
                // order 순서에 맞게
                if (order % 2 != 0) { // order가 홀이면 왼쪽 -> 오른쪽
                    innerList.add(node.val);
                } else { // order가 짝이면 오른쪽 -> 왼쪽
                    innerList.add(0, node.val);
                }
                
            }
            
            // retList에 innerList 넣기
            retList.add(innerList);
        }

        return retList;
    }
}
```

# 타인 풀이
- https://www.youtube.com/watch?v=k-UrJmD457Y&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=24
- stack을 사용. 
- 레벨 별 스택 사용
- 플래그 변수 사용, 탐색 방향을 결정
    - true이면 왼쪽 -> 오른쪽 탐색하면서 그대로 넣음. 
    - 그러면 다음 레벨에서는 오른쪽 -> 왼쪽 순서로 뽑히게 됨(stack 구조이므로)
```
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        
        boolean flag = true;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        
        while (!s.isEmpty()) {
            int size = s.size();
            Stack<TreeNode> newStack = new Stack<>();
            List<Integer> level = new ArrayList<>();
            for (int i = 0 ; i < size ; i++) {
                // 현재 레벨 노드들, 그 자손들 처리
                TreeNode node = s.pop();
                level.add(node.val);
                if (flag) {
                    if (node.left != null) newStack.push(node.left);
                    if (node.right != null) newStack.push(node.right);
                } else {
                    if (node.right != null) newStack.push(node.right);
                    if (node.left != null) newStack.push(node.left);
                }

            }
            ret.add(level);
            s = newStack;
            flag = !flag;
        }
        
        return ret;
    }
}
```
