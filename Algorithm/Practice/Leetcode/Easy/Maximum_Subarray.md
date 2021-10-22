# Maximum_Subarray
- [문제](https://leetcode.com/problems/maximum-subarray/)
- 풀이
    - 2021.5.18(성공, 그런데 카데인 알고리즘으로는 못 풀었음, brute force로 풀었음)
    - 2021.10.22



# 내 풀이1
- 2021.5.18
- Best_Time_to_Buy_and_Sell_Stock 와 유사한 문제
- [카데인 알고리즘](https://sustainable-dev.tistory.com/23)


# 내 풀이2
- 2021.10.22
- 예전에 정답1을 보고 풀었던 기억이 있었어서 풀어봄
```
class Solution {
    public int maxSubArray(int[] nums) {
        int localMax = nums[0];
        int globalMax = nums[0];
        
        for (int i = 1 ; i < nums.length ; i++) {
            localMax = Math.max(nums[i], localMax + nums[i]);
            
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }
        
        return globalMax;
    }
}
```

# 내 풀이3
- https://www.youtube.com/watch?v=E5r1cQ-vLgM&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=11
- 유투버 승지니어님이 자주 푸시는 방법 d배열을 따로 둬서 하는 것처럼 한번 풀어봄(승지니어님이 이 문제 푸는 영상 보기 전에 풀었음)
```
class Solution {
    public int maxSubArray(int[] nums) {
        int[] d = new int[nums.length]; 
        
        d[0] = nums[0];
    
        int max = nums[0];
        for (int i = 1 ; i < nums.length ; i++) {
            d[i] = Math.max(nums[i], d[i-1] + nums[i]);
            if (d[i] > max) {
                max = d[i];
            }
        }
        
        return max;
    }
}
```


# 정답1
- O(n)
```
class Solution {
    public int maxSubArray(int[] nums) {

        int localMaxSum = nums[0];
        int finalMaxSum = nums[0];

        for (int i = 1 ; i < nums.length ; i++) {
            localMaxSum = Math.max(nums[i], localMaxSum + nums[i]);

            if (localMaxSum > finalMaxSum) {
                finalMaxSum = localMaxSum;
            }
        }
        
        return finalMaxSum;
    }
}
```



# 정답2
- https://www.youtube.com/watch?v=E5r1cQ-vLgM&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=11
```
class Solution {
    public int maxSubArray(int[] nums) {
        // d[i] : i번째 원소가 마지막 원소인 부분배열의 합 중 최대값
        // d[2] : max(nums[2], nums[1] + nums[2], nums[0] + nums[1] + nums[2]);
        int[] d = new int[nums.length];
        d[0] = nums[0];
        
        for (int i = 1 ; i < nums.length ; i++) {
            // update d[i]
            d[i] = Math.max(nums[i], d[i-1] + nums[i]);
        }
        
        int max = d[0];
        for (int num : d ) {
            if (num > max) {
                max = num;
            }
        }
        
        return max;
    }
}
```