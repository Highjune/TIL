# N-ary_Tree_Preorder_Traversal
- [문제](https://leetcode.com/problems/n-ary-tree-preorder-traversal/)
- 풀이
    - 2021.10.06 (실패)


# 내 풀이
- 실패한 내 풀이
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList();
        process(list, root);
        return list;
    }
    
    public void process(List<Integer> list, Node root) {
        if (root != null) {
            list.add(root.val);
            process(list, root); 
        } else {
            return;
}
- 정답1을 보고 다시 풀어본 내 풀이
```
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList();
        process(list, root);
        return list;
    }
    
    public void process(List<Integer> list, Node root) {
        if (root != null) {
            list.add(root.val);
            for (Node node : root.children) { // 이 for문만 추가해줬으면 됐었다.
                process(list, node);    
            }
        } else {
            return;
    }
    
```
    


# 정답1
- recursive 
- https://www.youtube.com/watch?v=jHSoaw0pFe4&list=PL2mzT_U4XxDm7p6g1o3KeQMsyRLfzSaVW&index=7
- preOrder
    - self -> children
- postOrder
    - children -> self
- 재귀구현시, 항상 base case를 어떻게 처리할지 고민해야 한다.
```
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList();
        traverse(root, ret);
        return ret;
    }
    
    public void traverse(Node root, List<Integer> ret) {
        if (root == null) return;
        ret.add(root.val);
        for (Node child : root.children) {
            traverse(child, ret);
        }
    }
}

```

# 정답2
- Iterative
- https://leetcode.com/problems/n-ary-tree-preorder-traversal/discuss/147955/Java-Iterative-and-Recursive-Solutions
```
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        
        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--)
                stack.add(root.children.get(i));
        }
        
        return list;
    }
}
```