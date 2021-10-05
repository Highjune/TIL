# Minimum_Absolute_Difference_in_BST
- [문제](https://leetcode.com/problems/minimum-absolute-difference-in-bst/)
- 풀이
    - 2021.10.05 (실패)

# 내 풀이
- 1시간동안해서 실패



# 타인 풀이
- https://www.youtube.com/watch?v=KLX44z_NnYc&list=PL2mzT_U4XxDm7p6g1o3KeQMsyRLfzSaVW&index=2
- 트리 순회(재귀)
    - preorder : self left right
    - inorder : left self right
    - postorder : left right self
    - 이진검색트리 성질 -> inorder 순회하면 -> 오름차순 정렬이 됨! (이 성질을 이용)
        - 왼쪽 subtree는 다 self보다 적음. 오른쪽 subtree는 다 self보다 큼. self보다 작은 애들을 처리, 큰 애들을 또 처리를 재귀적으로 하면 오름차순 정렬이 된다.
        - 그냥 트리를 순회하는 방법이 DFS, BFS가 있는데 그 중에서 DFS에서는 위의 3가지 방법이 있다. 그런데 Binary Search Tree, 즉 규칙을 가지고 있는(left는 root보다 작고 right는 root보다 크다) BFS를 inorder로 순회하게 되면 오름차순 정렬값을 얻을 수 있다.
```
public class Solution {

    boolean init;
    int min;
    int prev;

    public int getMinimumDifference(TreeNode root) {
        init = false;
        min = Integer.MAX_VALUE;
        inorder(root);
        return min;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);

        // self
        if (!init) {
            init = true;
        } else {
            min = Math.min(min, root.val - prev);
        }

        prev = root.val;
        inorder(root.right);
    }
}
```