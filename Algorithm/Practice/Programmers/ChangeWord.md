# ChangeWord(단어 변환)
- https://programmers.co.kr/learn/courses/30/lessons/43163

## 내 풀이
- 실패
- 시간이 무한으로 있다면 풀 수도 있겠지만, 곧 있을 코딩테스트를 생각해서 시간을 제한해서 풀었다.
- DFS, BFS에 익숙치 않아 이전에는 손도 못 댄 것에 비해 그래도 많은 성과다...
- 하지만 못 푼것은 마찬가지^^;;;
- String의 각 요소들을 비교할 때는 굳이 string.toCharArray(); 로 char[]을 만들 필요 없고 string.charAt(i); 로 비교하면 된다.
```
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] chk = new boolean[words.length];
        answer = dfs(begin, target, chk, 0, words);
        return answer;
    }
    
    int dfs(String begin, String target, boolean[] chk, int start, String[] words) {
        boolean[start] = true;
        int ans = 0;
        char[] beginArr = begin.toCharArray();
        char[] nextArr = words[start].toCharArray();
        for (int i = 0 ; i < nextArr.length ; i++) {
            if (beginArr[i] == nextArr[i]) {
                ans++;
            }
        }
        
        if (ans == 3) {
            return 1;
        } else (ans == 2) {
            begin = words[start].toCharArray();
        } 
           
        start++;
        return 0;
    }
}

```


## 타인 풀이
- https://programmers.co.kr/learn/courses/30/lessons/43163/solution_groups?language=java
```
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static class Node {
        String next;
        int edge;

        public Node(String next, int edge) {
            this.next = next;
            this.edge = edge;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int n = words.length, ans = 0;

        // for (int i=0; i<n; i++)
        //  if (words[i] != target && i == n-1) return 0;

        Queue<Node> q = new LinkedList<>();


        boolean[] visit = new boolean[n];
        q.add(new Node(begin, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.next.equals(target)) {
                ans = cur.edge;
                break;
            }

            for (int i=0; i<n; i++) {
                if (!visit[i] && isNext(cur.next, words[i])) {
                    visit[i] = true;
                    q.add(new Node(words[i], cur.edge + 1));
                }
            }
        }

        return ans;
    }

    static boolean isNext(String cur, String n) {
        int cnt = 0;
        for (int i=0; i<n.length(); i++) {
            if (cur.charAt(i) != n.charAt(i)) {
                if (++ cnt > 1) return false;
            }
        }

        return true;
    }    
}

```