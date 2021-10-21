# Top_K_Frequent_Words

- [문제](https://leetcode.com/problems/top-k-frequent-words/description/)
- 풀이
    1. 2021.10.19 (실패)

# 내 풀이
- 실패


# 타인 풀이
- https://www.youtube.com/watch?v=8XhXg98E1Gg&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=7
```
class Solution {
    public class WordCnt {
        String word;
        int cnt;
        public WordCnt(String word) {
            this.word = word;
            this.cnt = 1;
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, WordCnt> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.get(word).cnt++;
            } else {
                map.put(word, new WordCnt(word));
            }
        }
        
        // min heap, k개 : 항상 top k개 frequent element를 오름차순으로 가지고 있음
        // ex : 3, 4, 5 -> pq, new elem : 6
        // evict : 3, insert : 6
        PriorityQueue<WordCnt> pq = new PriorityQueue<>(k, (a, b) -> a.cnt - b.cnt != 0 ? a.cnt - b.cnt :
                                                            b.word.compareTo(a.word));
        for (WordCnt wordCnt : map.values()) {
            pq.offer(wordCnt);
            if (pq.size() > k) pq.poll();
        }
        
        List<String> ret = new ArrayList<>();
        
        while (!pq.isEmpty()) {
            ret.add(0, pq.poll().word);
        }
        
        return ret;
    }
}
```