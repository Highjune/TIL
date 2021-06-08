# Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box
- [문제](https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/)


# 내 풀이
- 그냥 O(N^2)...틀린 답
```
class Solution {
    public int[] minOperations(String boxes) {
        char[] charBoxes = boxes.toCharArray();
        int[] resultArr = new int[boxes.length()];

        for (int i = 0 ; i < charBoxes.length ; i++) {
            int sum = 0;
            for (int j = 0 ; j < charBoxes.length ; j++) {
                if (charBoxes[j] == '1') {
                    int gap = Math.abs(i - j);
                    sum += gap;
                }
            }
            resultArr[i] = sum;
        }
        
        return resultArr;
    }
}
```


# 타인 풀이
- 각 자리 기준으로, 왼쪽->오른쪽으로 가는 모든 이동횟수 다 더하고, 왼쪽<-오른쪽 반대방향으로도 마찬가지로 더해줌
- 예전에 비슷한 문제 풀었었던 것 같았는데 못 품..
- https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/discuss/1075474/C%2B%2BJava-O(n)-LTR-%2B-RTL
```
public int[] minOperations(String boxes) {
    int[] res = new int[boxes.length()];
    for (int i = 0, ops = 0, cnt = 0; i < boxes.length(); ++i) {
       res[i] += ops;
       cnt += boxes.charAt(i) == '1' ? 1 : 0;
       ops += cnt;
    }    
    for (int i = boxes.length() - 1, ops = 0, cnt = 0; i >= 0; --i) {
        res[i] += ops;
        cnt += boxes.charAt(i) == '1' ? 1 : 0;
        ops += cnt;
    }
    return res;
}
```