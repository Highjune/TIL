# Insert_Delete_GetRandom_O(1)
- [문제](https://leetcode.com/problems/insert-delete-getrandom-o1/)
- 풀이
    - 2021.10.18 (반틈 성공)

# 내 풀이
- 성공했지만 문제의도 O(1) 에는 틀린 문제인듯
    - 왜냐하면 contains() 하는 것 자체가 이미 linear complextity 인 듯
- list.remove(index) 와 list.remove(Object) 에서 헤매서 조금 시간 걸림
```
class RandomizedSet {

    List<Integer> list;
    
    public RandomizedSet() {
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (list.contains(val)) {
            return false;
        }
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!list.contains(val)) {
            return false;
        }
        list.remove(new Integer(val));
        return true;
    }
    
    public int getRandom() {
        int size = list.size();
        int ranNum = (int)(Math.random() * size) + 1;
        return list.get(ranNum - 1);
    }
}
```

# 타인 풀이
- https://www.youtube.com/watch?v=dei_SHqRIZ8&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=2
```
class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> list;
    int size;
    Random random;
    
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        size = 0;
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val, size++);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.get(val);
        map.remove(val);
        if (idx != size - 1) {
            // swap & remove
            int swap = list.get(size-1);
            list.set(idx, swap);
            map.put(swap, idx);
        }
        // remove
        list.remove(--size);
        return true;
    }
    
    public int getRandom() {
        int ran = random.nextInt(size);
        return list.get(ran);
    }
}
```