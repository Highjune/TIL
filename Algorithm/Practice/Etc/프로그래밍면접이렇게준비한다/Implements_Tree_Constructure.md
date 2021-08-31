# 트리구조 구현하기
- 프로그래밍 면접 이렇게 구현한다 p152
- 트리는 0개 이상의 다른 노드에 대한 레퍼런스(또는 포인터)가 들어 있는 노드(데이터 원소)로 구성된다. 한 노드를 참조하는 노드는 하나뿐이다(부모노드가 반드시 1개).
- 노드는 구조데 또는 클래스로 표현되며, 트리는 포인터 또는 레퍼런스만 있다면 어떤 언어로든 구현할 수 있다.
- 객체지향 언어에서는 보통 노드의 공통적인 부분을 하나의 클래스로 정의하고, 노드에 들어가는 데이터를 위해 서브클래스를 사용한다.

# 책 풀이
- 이 노드에서 참조하는 모든 노드를 children 이라는 배열에 저장한다. 
- 편의상 children을 그냥 공개 데이터 멤버로 선언(실제에서는 children은 비공개private로 선언하고 그 배열을 건드리기 위한 메서드만 공개하는 방법을 써야 할 것이다)
```
public abstract class Node {
    private Node[] children;

    public Node(Node[] children) {
        this.children = children;
    }

    public int getNumChildren() {
        return children.length;
    }

    public Node getChild(int index) {
        return children[index];
    }
}

class IntNode extends Node {
    private int value;

    public IntNode(Node[] children, int value) {
        super(children);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

```