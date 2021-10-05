# How_To_Implements_Binary_Tree_Traversal_By_3_ways
- Binary Tree의 3가지 순회방법 구현하기
- 트리 데이터 가져오는 것
- https://www.youtube.com/watch?v=QN1rZYX6QaA

## 이론
- Binary Tree Traversals;
    - Inorder(left, root, right);
    - Preorder(root, left, right);
    - Postorder(left, right, root);
- ex) Tree example
```
       1
     /  |
    2   3
   / | 
  4  5
```
- Inorder 
    - 4 2 5 1 3
- Preorder
    - 1 2 4 5 3
- Postorder
    - 4 5 2 3 1


## 풀이
```
class Node { // binary tree node
    int data;
    Node left;
    Node right;
}

class Tree {
    public Node root; // starting point of tree

    public void setRoot(Node node) {
        this.root = node;
    }

    public Node getRoot() {
        return root;
    }

    public Node makeNode(Node left, int data, Node right) {
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;
        return node;
    }

    public void inorder(Node node) {
        if (node != null) { // recursion until node != null
            inorder(node.left); // left side recursion
            System.out.println(node.data); // after recursion left side
            inorder(node.right); // right side recursion
        }
    }

    public void preorder(Node node) {
        if (node != null) { // recursion until node != null
            System.out.println(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.data);
        }
    }
}

/**
 *        1
 *      /  |
 *     2   3
 *    / |
 *   4  5
 */
public class Test {
    public static void main(String[] args) {
        Tree t = new Tree();
        Node n4 = t.makeNode(null, 4, null);
        Node n5 = t.makeNode(null, 5, null);
        Node n2 = t.makeNode(n4, 2, n5);
        Node n3 = t.makeNode(null, 3, null);
        Node n1 = t.makeNode(n2, 1, n3);
        t.setRoot(n1);
        t.inorder(t.getRoot());
//        t.preorder(t.getRoot());
//        t.postorder(t.getRoot());
    }
}
```