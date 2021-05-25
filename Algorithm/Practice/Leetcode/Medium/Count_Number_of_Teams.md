# Count_Number_of_Teams
- [문제](https://leetcode.com/problems/count-number-of-teams/)


# 내 풀이1
- 큰 for문을 1번만 돌았어도 됐었네??..
```
class Solution {
    public int numTeams(int[] rating) {        
        int sum = 0;
        
        for (int m = 1 ; m < rating.length - 1 ; m++) {
            int left = 0;
            int right = 0;
            for (int l = 0 ; l < m ; l++) {
                if (rating[l] < rating[m]) {
                    left++;
                }
            }
            
            for (int r = m + 1 ; r < rating.length ; r++) {
                if (rating[m] < rating[r]) {
                    right++;
                }
            }
            
            sum += left * right;
        }
        
        
        for (int m = 1 ; m < rating.length - 1 ; m++) {
            int left = 0;
            int right = 0;
            for (int l = 0 ; l < m ; l++) {
                if (rating[l] > rating[m]) {
                    left++;
                }
            }
            
            for (int r = m + 1 ; r < rating.length ; r++) {
                if (rating[m] > rating[r]) {
                    right++;
                }
            }
            
            sum += left * right;
        }
        
        return sum;
    }
}
```

# 내 풀이2
- 답 보고 다시 풀어봄
```
class Solution {
    public int numTeams(int[] rating) {        
        int sum = 0;
        int len = rating.length;
        
        for (int m = 1 ; m < len - 1 ; m++) {
            int leftSmaller = 0;
            int leftLarger = 0;
            int rightSmaller = 0;
            int rightLarger = 0;
            
            for (int l = 0 ; l < m ; l++) {
                if (rating[l] < rating[m]) {
                    leftSmaller++;
                } else if (rating[l] > rating[m]) {
                    leftLarger++;
                }
            }
            
            for (int r = m + 1 ; r < len ; r++) {
                if (rating[m] < rating[r]) {
                    rightLarger++;
                } else if (rating[m] > rating[r]) {
                    rightSmaller++;
                }
                    
            }
            
            sum += leftSmaller * rightLarger + leftLarger * rightSmaller;
        }
        
        return sum;
    }
}
```

# 타인 풀이
- https://leetcode.com/problems/count-number-of-teams/discuss/555441/JavaC%2B%2B-100-O(N2)-Easy-To-Understand-With-Explanation
```
public int numTeams(int[] arr) {
    int count = 0;
    int len = arr.length;
    for (int j = 0; j < len; j++) {
        int leftSmaller = 0, rightLarger = 0;
        int leftLarger = 0, rightSmaller = 0;
        for (int i = 0; i < j; i++) {
            if (arr[i] < arr[j]) {
                leftSmaller++;
            } else if (arr[i] > arr[j]) {
                leftLarger++;
            }
        }
        for (int k = j + 1; k < len; k++) {
            if (arr[j] < arr[k]) {
                rightLarger++;
            } else if (arr[j] > arr[k]) {
                rightSmaller++;
            }
        }
        count += leftSmaller * rightLarger + leftLarger * rightSmaller;
    }
    
    return count;
}
```
