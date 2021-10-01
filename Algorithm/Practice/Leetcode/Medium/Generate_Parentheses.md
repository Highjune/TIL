# Generate_Parentheses

- [문제](https://leetcode.com/problems/generate-parentheses/)
- 일부러 Sort 알고리즘 종류로 다 풀어보기
- 풀이
    - 2021.09.30 ~ 2021.10.01

# 내 풀이
- 푸는 중. 마무리에서 덜 됨
```
import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        list.add('-');
        for (int i = 0 ; i < n ; i++) {
            list.add('(');
            list.add(')');
        }

        // 720 개
        int numAllKindsOfString = 1;
        int separatedNum = 1;
        for (int i = 2*n ; i > 0 ; i--) {
            numAllKindsOfString *= i;
        }
        for (int i = n ; i > 0 ; i--) {
            separatedNum *= i;
        }
        numAllKindsOfString = numAllKindsOfString / (separatedNum * separatedNum);

        Set<String> bigSet = new HashSet<>();
        Set<Integer> miniSet = new HashSet<>();
        while (bigSet.size() != numAllKindsOfString) { // 6 채울때까지

            StringBuilder sb = new StringBuilder(); // 매번 새로 생성
            while (miniSet.size() != 2*n) { // 1개 만드는 것 (()) 로
                int ranNum = (int)(Math.random() * 2*n) + 1;
                if (miniSet.contains(ranNum)) continue;
                miniSet.add(ranNum);
                sb.append(list.get(ranNum));
            }
            bigSet.add(sb.toString());  // 1개 추가
            miniSet.clear(); // 리셋
        }

        // set에 담은 걸 bigSet에 옮김
        List<String> allPool = new ArrayList<>(); // 모든 가능한 720개 들어있는 풀을 넣을 list
        for (String s : bigSet) {
            allPool.add(s); //
        }

        // 검증(가능한 것들만 체크)
        Stack<Character> stack = new Stack<>();
        for (String s : allPool) { // 전체 풀에 있는 모든 문자형태 검사
            char[] charArr = s.toCharArray();

            for (Character c : charArr) {
                if (c == '(') {
                    stack.push(')');
                    continue;
                } else if (stack.isEmpty() || stack.pop() != c) {
                    break;
                }

                if (stack.isEmpty()) {
                    resultList.add(s);
                    stack.clear();
                } else {
                    stack.clear();
                    break;
                }

            } // 안쪽 for문 끝
        } // 바깥족 for문 끝

        return resultList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = s.generateParenthesis(2);
        for (String str : list) {
            System.out.println(str);
        }
    }

}
```


# 정답1
- https://www.youtube.com/watch?v=Bt11jaoqt_Y&list=PL2mzT_U4XxDm7p6g1o3KeQMsyRLfzSaVW