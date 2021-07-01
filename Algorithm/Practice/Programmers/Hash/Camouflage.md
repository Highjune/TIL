# Camouflage(위장)
- https://programmers.co.kr/learn/courses/30/lessons/42578

## 내 풀이
- 실패
- 경우의 수 문제를 오랜만에 풀었더니.. 


## 타인 풀이1
- 옷 종류마다 안 입는 경우 1개씩 추가해서 다 곱해준 다음에 마지막에 1(다 안입는 경우) 빼주는 것. 이것만 생각하면 엄청 쉬운 문제. 
- 활용) map.size(), map의 keySet() 뽑아내서 향상된 for문으로 해결
```
import java.util.*;

public class Solution {

    public int solution(String[][] clothes) {
        int answer = clothes.length;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0 ; i < clothes.length ; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        // key가 2개 이상이면
        if (map.size() > 1) {
            int count = 1;

            for (String key : map.keySet()) {
                count *= map.get(key) + 1;
            }
            answer = count - 1;
        }

        return answer;
    }
}
```

## 타인 풀이2
- 람다와 스트림 공부하고 나서 나중에 다시 풀어보기
```
import java.util.*;
import static java.util.stream.Collectors.*;

class Solution {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }
}
```


