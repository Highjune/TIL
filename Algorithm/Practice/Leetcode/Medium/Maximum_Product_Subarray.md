# Maximum_Product_Subarray

- [문제](https://leetcode.com/problems/maximum-product-subarray/description/)
- 풀이
    1. 2021.10.22 (실패)
- 동적 프로그래밍, 카데인 알고리즘


# 내 풀이
- 실패
- 카데인 알고리즘은 알고 있었는데, 음수 곱하기가 들어가니 어떻게 해결해야 할지 잘 모르겠다



# 타인 풀이
- https://www.youtube.com/watch?v=MGwd30-ZM6o&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=9
- 최대값, 최대값을 매번 같이 들고 다닌다는 참신한 아이디어.
- 카데인 알고리즘처럼, 다이나믹 프로그래밍으로 푸는 것은 동일했다.
```
class Solution {
    public int maxProduct(int[] nums) {
        //d[i][0] -> +, 0~i, max product
        //d[i][1] -> -, 0~i, min product
        int[][] d = new int[nums.length][2];
        d[0][0] = nums[0]; 
        d[0][1] = nums[0]; 
        
        for (int i = 1 ; i < nums.length ; i++) {
            int c = nums[i];
            d[i][0] = Math.max(c, Math.max(d[i-1][0] * c, d[i-1][1] * c));
            d[i][1] = Math.min(c, Math.min(d[i-1][0] * c, d[i-1][1] * c));
        }
        
        int max = d[0][0];
        for (int i = 0 ; i < nums.length ; i++) {
            if (d[i][0] > max) {
                max = d[i][0];
            }
        }
        
        return max;
    }
}
```