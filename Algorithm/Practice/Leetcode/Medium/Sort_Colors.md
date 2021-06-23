# Sort Colors

- [문제](https://leetcode.com/problems/sort-colors/)
- 일부러 Sort 알고리즘 종류로 다 풀어보기

# 내 풀이1(Bubble Sort)
- 시간복잡도 O(N^2)
```
class Solution {
    public void sortColors(int[] nums) {
        // first. bubble Sort
        for (int i = 0 ; i < nums.length - 1 ; i++) {
            for (int j = i + 1 ; j < nums.length ; j++) {
                if (nums[j] < nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
```


# 내 풀이2(Selection Sort)
- 시간복잡도 O(N^2)
```
class Solution {
    public void sortColors(int[] nums) {
        // second. Selection Sort
        for (int i = 0 ; i < nums.length - 1 ; i++) {
            int min = nums[i];
            int minPlace = i;
            for (int j = i + 1 ; j < nums.length ; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minPlace = j;
                }
            }
            nums[minPlace] = nums[i];
            nums[i] = min;            
        }
    }
}
```


# 내 풀이3(Insertion Sort)
- 시간복잡도 O(N^2)
```


```