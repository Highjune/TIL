- 이름(name) 순으로 정렬. `Comparable`

```
public class Fruit implements Comparable<Fruit> {
    public String name;
    public int quantity;
    public Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public int compareTo(Fruit other){
        return name.compareTo(other.name);
    }
}

//somewhere Code. 
Fruit[] fruits = new Fruit[4];
fruit[0] = new Fruit("PiineApple", 70);
fruit[1] = new Fruit("Apple", 100);
fruit[2] = new Fruit("Orange", 80);
fruit[3] = new Fruit("Banana", 90);

Arrays.sort(fruits); // 이름 순으로 정렬된다(Apple, Banana ...)
```

- 재고수량(quantity) 으로 정렬. `Comparable`

```
public class Fruit implements Comparable<Fruit> {
    public String name;
    public int quantity;
    public Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public int compareTo(Fruit other){
        return quantity - other.quantity;
    }
}

//somewhere Code.
Fruit[] fruits = new Fruit[4];
fruit[0] = new Fruit("PiineApple", 70);
fruit[1] = new Fruit("Apple", 100);
fruit[2] = new Fruit("Orange", 80);
fruit[3] = new Fruit("Banana", 90);

Arrays.sort(fruits); // 재고수량 순으로 정렬된다(70->80->90->100)
```

- 두 가지 기준을 동시에 적용하려면? `Comparator` 을 사용
    - 데이터 객체의 static member로 둔다. 
    - Comparator 인터페이스를 extends하며 compare 메서드를 overriding하는 새로운 이름 없는 클래스를 정의한 후 그 클래스의 객체를 하나 생성한다. 
```
public class Fruit {
    public String name;
    public int quantity;
    public Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public static Comparator<Fruit> nameComparator = new Comparator<Fruit>() {
        public int compare(Fruit fruit1, Fruit fruit2) { 
            return fruit1.name.compareTo(fruit2.name);
        }
    };

    public static Comparator<Fruit> quantComparator = new Comparator<Fruit>() {
        public int compare(Fruit fruit1, Fruit Fruit2) {
            return fruit1.quantity - fruit2.quantity;
        }
    };
}

//somewhere Code.
Fruit[] fruits = new Fruit[4];
fruit[0] = new Fruit("PiineApple", 70);
fruit[1] = new Fruit("Apple", 100);
fruit[2] = new Fruit("Orange", 80);
fruit[3] = new Fruit("Banana", 90);

Arrays.sort(fruits, Fruit.nameComparator); // 이름 순으로 정렬
Arrays.sort(fruits, Fruit.quantComparator); // 재고 순으로 정렬
```

    