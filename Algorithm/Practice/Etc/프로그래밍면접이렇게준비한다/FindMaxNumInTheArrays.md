# FindMaxNumIntheArrays
- 프로그래밍 면접 이렇게 준비한다 p86
- 음이 아닌 수가 저장된 배열에서 최댓값을 구하는 간단한 함수 만들기


# 내 풀이1
- Arrays.sort() 써서 간단하게
- 이렇게 말고 또는 여러 정렬(BubbleSort, QuickSort 등) 해서 마지막 인자 값 구하는 방법도 있음
```
class Solution {
    public static int CompareToMax(int[] arr) {
            int resNum = 0;

            Arrays.sort(arr);
            resNum = arr[arr.length - 1];

            return resNum;
        }
    }
}
```

# 내 풀이2
- 최대값과 계속 비교해서 가장 큰수를 계속 기록
- 무식한 방법
```
class Solution {
    public static int CompareToMax(int[] arr) {
        int maxNum = 0;

        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] > maxNum) {
                maxNum = arr[i];
            }
        }

        return maxNum;
    }
}
```

# 책 풀이1
- 내 풀이2와 비슷 
