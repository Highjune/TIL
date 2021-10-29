# Merge_Intervals
- [문제](https://leetcode.com/problems/merge-intervals/description/)
- 풀이
    1. 2021.10.27(실패)

# 내 풀이1
- [타인 풀이](https://www.youtube.com/watch?v=02qcG4D3EqU&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=13) 문제와(List -> `int[][]`) 좀 다름.
- 링크 보고 내 방식대로 풀어봤다.
- overlap 조건 그림 or 손가락 간격으로 해서 생각해보기!
```
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 1) return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1 ; i < intervals.length ; i++) {
            if (intervals[i-1][1] >= intervals[i][0] && intervals[i][1] >= intervals[i-1][0]) { // overlap 되는 조건!!
                intervals[i][0] = Math.min(intervals[i-1][0], intervals[i][0]);
                intervals[i][1] = Math.max(intervals[i-1][1], intervals[i][1]);
            } else {
                map.put(intervals[i-1][0], intervals[i-1][1]);
            }
        }
        map.put(intervals[intervals.length - 1][0], intervals[intervals.length - 1][1]);
        
        int[][] ret = new int[map.size()][2];
        int v = 0;
        for (int k : map.keySet()) {
            ret[v++] = new int[]{k, map.get(k)};
        }

        return ret;
    }

}
```

# 타인 풀이1
- https://www.youtube.com/watch?v=02qcG4D3EqU&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ&index=13
- 문제가 좀 달라서 아래는 list로 풀었음
```
class Solution {
    public List<Integerval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;

        List<Interval> ret = new ArrayList<>();

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        for (int i = 0 ; i < intervals.size() ; i++) {
            Interval a = intervals.get(i-1);
            Interval b = intervals.get(i);
            if (a.end >= b.start && b.end >= a.start) {
                b.start = Math.min(a.start, b.start);
                b.end = Math.max(a.end, b.end);
            } else {
                // a
                ret.add(a);
            }
        }

        ret.add(intervals.get(intervals.size()-1));

        return ret;
    }
}
```

# 타인 풀이2
- https://leetcode.com/problems/merge-intervals/discuss/1545704/Simple-JAVA-Code-with-comments-96-(5-ms)-faster
```
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1,i2)->Integer.compare(i1[0],i2[0])); //Sort the intervals a/c to their starting position
        
        List<int[]> ans=new ArrayList<>(); //result List
        ans.add(intervals[0]);  // adding first interval
        for(int[] in:intervals){
            int[] I=ans.get(ans.size()-1); //fetching last interval from ans list to compare it from current interval
            if(in[0]<=I[1]){ //checking if current interval contains last interval fetched from list 
                ans.add(new int[]{I[0],Math.max(I[1],in[1])});  // we have to take max of both as we have sorted a/c to start but not a/c to end in [start,end] 
                ans.remove(ans.size()-2); //removing interval which was prevoiusly true 
            }
            else{
                ans.add(in); // we simply add the interval in ans
            }
        }
        return ans.toArray(new int[0][]); //converting to int[][]
    }
}
```