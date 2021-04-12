EquiLeader

> [문제링크](https://app.codility.com/programmers/lessons/8-leader/equi_leader/)

## 타인 풀이, 100%
https://rooted.tistory.com/48
- 나올 때마다 숫자를 세지 않고 같은 크기의 배열로 만들어서 미리 1로 초기화 해서 값을 더함
- 한칸씩 오른쪽으로 갈 때마다, left와 right를 구분하는 방법이 깔끔
```
import java.util.*;

class Solution {
    public int solution(int[] A) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int maxCount = 0;
        int leader = 0;
        
        for(int i=0; i<A.length; i++) {
            if(map.containsKey(A[i])) {
                int count = map.get(A[i]) + 1;
                map.put(A[i],count);
                if(maxCount < count) {
                    maxCount = count;
                    leader = A[i];
                }
            } else {
                map.put(A[i],1);
            }
        }
        
        if(maxCount == 0)
            return 0;
        
        int[] Counter = new int[A.length];
        for(int i=0; i<A.length; i++) {
            if(A[i] == leader)
                Counter[i] = 1;
            else
                Counter[i] = 0;
        }
                
        int result = 0;
        int leftLen = 0;
        int rightLen = A.length;
        int leftCount = 0;
        int rightCount = map.get(leader);
        for(int i=0; i<A.length; i++) {
            leftCount += Counter[i];
            rightCount -= Counter[i];
            leftLen++;
            rightLen--;
            
            if( (leftCount > leftLen/2) && (rightCount > rightLen/2) )
                result++;
        }
        
        return result;
    }
}
```