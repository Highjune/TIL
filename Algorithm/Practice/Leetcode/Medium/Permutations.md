# Permutatins.md
- [문제](https://leetcode.com/problems/permutations/description/)
- 백트래킹 문제
- 풀이
    1. 2021.11.13 (실패)



# 내 풀이
- 아래처럼 노가다로 풀려다가 실패
```
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> outerList = new ArrayList<>();
        int innerListSize = nums.length;
        
        int retSize = allPossibleKindsOfNum(innerListSize);
    
        // 결과 outerList의 사이즈
        while (ret.size != retSize) {
            Set<Integer> set = null;
            // 하나의 set 만들기
            while (set.size != innerListSize) {
                set = new HashSet<>();
                int num = (int)Math.random()*innerListSize + 1;
                
                
                // 하나의 set이 완성되면 list로 변환해서 ret.add(list) 넣기

            }
        }
        
        return outerList;
    }
    
    public int allPossibleKindsOfNum(int number) {
        int ret = 1;
        for (int i = number ; i > 0 ; i--) {
            ret *= i;
        }
        
        return ret;
    }
}
```



# 타인 풀이
- https://www.youtube.com/watch?v=wxQmnEKNXAM&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=21
- 백 트래킹 문제. 콜 스택에 대해서 다시 공부할 수 있는 좋은 기회였다. 역시 기본이 가장 중요하며 그것에 충실해야 한다.
- Call 스택에 따른 변화
```
ex input : 1, 2, 3
Call 0 : add 1 // 1
Call 1 : skip 1, add 2 // 1, 2
Call 2 : skip 1, skip 2, add 3 // 1, 2, 3
Call 3 : base case, 1, 2, 3 -> add to ret
Call 2 : remove 3, return // 1, 2
Call 1 : remove 2, add 3 // 1, 3
Call 4 : skip 1, add 2 // 1, 3, 2
Call 5 : base case, 1, 3, 2 -> add to ret
Call 4 : remove 2, skip 3 return // 1, 3 -> // 2, 1, 3...

```
```
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backtrack(nums, ret, tmp);
        return ret;
    }
    
    public void backtrack(int[] nums, List<List<Integer>> ret, List<Integer> tmp) {
        // base case
        if (tmp.size() == nums.length) {
            ret.add(new ArrayList<>(tmp));
            return;
        }
        
        // for 문
        for (int num : nums) {
            if (tmp.contains(num)) continue;
            tmp.add(num);
            backtrack(nums, ret, tmp);
            tmp.remove(tmp.size() - 1);
        }    
                    
    }
}
```