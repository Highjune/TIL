# Best Time to Buy and Sell Stock
- [문제](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)


# 내 풀이
- 거의 똑같은 문제를 codility 에서 풀어봤었어서 카데인 알고리즘으로 푸는 거라 생각은 했는데 실패..
- [카데인 알고리즘](https://sustainable-dev.tistory.com/23)
- 카데인 알고리즘은 배열의 특정 부분합의 최대값을 구할 수도 있다.




# 정답1
- O(n)
```
class Solution {
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int i = 0 ; i < prices.length ; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else if (prices[i] - minValue > maxProfit) {
                maxProfit = prices[i] - minValue;
            }
            
        }
        
        return maxProfit;
    }
}
```