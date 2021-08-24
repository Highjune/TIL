## 단일 연결 리스트 구현
- 프로그래밍 면접 이렇게 준비한다 p101


## 자바 지네릭스로 구현하기
```
public class ListElement<T> {
    private T value;
    private ListElement<T> next;

    public ListElement(T value) {
        this.value = value;
    }

    public ListElement<T> next() {
        return next;
    }

    public T value() {
        return value;
    }

    public void setNext(ListElement<T> next) {
        this.next = next;
    }

    public void setValue(T value) {
        this.value = value;
    }

}

```