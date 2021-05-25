# Seat Reservation Manager
- [문제](https://leetcode.com/problems/seat-reservation-manager/)


# 내 풀이
- 시간 초과에러.
```
class SeatManager {
    int[] seatArr;

    public SeatManager(int n) {
        seatArr = new int[n];
    }

    public int reserve() {
        int k = -1;
        for (int i = 0 ; i < seatArr.length ; i++) {
            if (seatArr[i] == 0) {
                seatArr[i] = 1;
                k = i;
                break;
            }
        }

        return k + 1;
    }

    public void unreserve(int seatNumber) {
        seatArr[seatNumber - 1] = 0;

    }
}
```


# 타인 풀이1
- TreeMap 활용
```
class SeatManager {
	TreeMap<Integer,Boolean> map;
    public SeatManager(int n) {
        map = new TreeMap<>();
        for(int i = 1;i<=n;i++)
            map.put(i,true);
    }

    public int reserve() {
        return map.pollFirstEntry().getKey();
    }

    public void unreserve(int seatNumber) {
        map.put(seatNumber,true);
}
}
```


# 타인 풀이2
- PriorityQueue 활용
```
class SeatManager {
    PriorityQueue<Integer> pq;

    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++)
            pq.add(i);
    }
    
    public int reserve() {
        return pq.poll();
    }
    
    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}
```

