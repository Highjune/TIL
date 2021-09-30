# 이진트리검색(BTS) 구현
- 프로그래밍 면접 이렇게 준비한다 p157
- BST에서는 노드의 왼쪽 자식의 값이 반드시 자신의 값 이하이며, 오른쪽 자식의 값은 반드시 자신의 값 이상이다.
- 어떤 노드의 왼쪽 방향의 자손들은 전부 그 노드 이하의 값을 가지며, 오른쪽 자손들은 모두 그 노드 이상의 값을 가진다.
- 이진 검색 트리의 장점 가운데 하나로 룩업 연산(lookup - 트리에 있는 특정 노드의 위치를 알아내는 연산) 을 빠르고 간단하게 처리할 수 있다는 점을 알 수 있다.
- 이런 장점은 자료를 저장할 ㄷ때 그 위력을 발휘한다.

# 책에서의 알고리즘
```
로트 노드에서 시작
현재 노드가 널이 아닌 동안 반복
    현재 노드의 값이 찾고자 하는 값이면
        현재 노드 리턴
    현재 노드의 값이 찾고자 하는 값보다 작으면
        오른쪽 자식을 현재 노드로 설정
    현재 노드의 값이 찾고자 하는 값보다 크면
        왼쪽 자식을 현재 노드로 설정
반복문 끝
```

# 책에서의 구현(위 알고리즘 구현)
```
class Solution {
    Node findNode(Node root, int value) {
        while (root != null) {
            int currval = root.val;
            if (currval == value) break;
            if (currval < value) {
                root = root.getRight();
            } else { // currval > value
                root = root.getLeft();
            }
        }
        return root;
    }
S3
}
```