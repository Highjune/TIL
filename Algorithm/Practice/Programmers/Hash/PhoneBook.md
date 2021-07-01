# PhoneBook
- https://programmers.co.kr/learn/courses/30/lessons/42577

## 내 풀이
- 시간 초과 에러
- 그래도 str1.startsWith("str2"), str1.endsWith("str2") 메서드를 처음으로 사용해봤음
```
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        for (int i = 0 ; i < phone_book.length - 1 ; i++) {
            for (int j = i + 1 ; j < phone_book.length ; j++) {
                if (phone_book[i].startsWith(phone_book[j]) || phone_book[j].startsWith(phone_book[i])) {
                    answer = false;
                    return answer;
                }
            }       
        }
        return answer;
    }
}

```

## 타인 풀이1
- 정렬 후 앞 뒤의 것만 비교하기
```     
import java.util.Arrays;

class Solution {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        boolean result = true;
        for (int i=0; i<phoneBook.length-1; i++) {
            if (phoneBook[i+1].startsWith(phoneBook[i])) {
                result = false;
                break;
            }
        }
        return result;
    }
}
```

## 타인 풀이2
- Hash로 푸는 것
```
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean solution(String[] phoneBook) {
        boolean answer = true;

            Map<String, Integer> map = new HashMap<>();

            for(int i = 0; i < phoneBook.length; i++) {
                map.put(phoneBook[i], i);
            }

            for(int i = 0; i < phoneBook.length; i++) {
                for(int j = 0; j < phoneBook[i].length(); j++) {
                    if(map.containsKey(phoneBook[i].substring(0,j))) {
                        answer = false;
                        return answer;
                    }
                }
            }

            return answer;
    }
}
```

