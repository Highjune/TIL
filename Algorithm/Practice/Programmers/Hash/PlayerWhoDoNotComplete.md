# 

## 내 풀이
- 깔끔쓰
```
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            int val = map.get(s);
            val -= 1;
            map.put(s, val);
        }

        for (int i = 0 ; i < participant.length ; i++) {
            if (map.get(participant[i]) == 1) {
                answer = participant[i];
            }
        }

        return answer;
    }
}
```

## 타인 풀이
- 나랑 동일
- 좀 더 깔끔
```
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}
```