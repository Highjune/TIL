# Generate_Parentheses

- [문제](https://leetcode.com/problems/generate-parentheses/)
- 일부러 Sort 알고리즘 종류로 다 풀어보기
- 풀이
    - 2021.09.30 ~ 2021.10.01

# 내 풀이
- 실패
- 엄청 오래걸려서 비효율적으로 풀었지만, 다른 테스트 케이스 통과 못함
- 그래서 의미가 매우 있었다
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
            boolean b = isValid(s);
            if (b) {
                resultList.add(s);
            } else {
                continue;
            }

        } // 바깥족 for문 끝

        return resultList;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        if (s.length() % 2 == 1) {
            return false;
        }

        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = s.generateParenthesis(4);
        for (String str : list) {
            System.out.println(str);
        }
    }

}
```


# 정답
- https://www.youtube.com/watch?v=Bt11jaoqt_Y&list=PL2mzT_U4XxDm7p6g1o3KeQMsyRLfzSaVW
- recursive는 아직도 익숙치가 않다. 이해하면 쉬운 문제
```
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        process(n, 0, 0, "", ret); // recurse
        return ret;
    }

    // numOpen < numClosed -> inValid
    public void process(int n, int numOpen, int numClosed, String str, List<String> ret){

        //termination check
        if (numOpen == n && numClosed == n) {
            ret.add(str);
            return;
        }

        // recurse next
        if (numOpen < n) {
            process(n, numOpen + 1, numClosed, str + "(", ret); // add open bracket
        }
        if (numOpen > numClosed) {
            process(n, numOpen, numClosed + 1, str + ")", ret); // add closed bracket
        }

    }
```