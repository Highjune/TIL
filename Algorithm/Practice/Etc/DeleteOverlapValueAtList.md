# 중복 삭제 
- 프로그래밍 면접 이렇게 준비한다 p72

# 내 풀이1
- 우선 단순하게 리스트 1개를 복사한 후, 다음 어떤 값이 이미 들어 있는지 검색하고 있는지 검색하고 없으면 그 두 번째 리스트에 집어 넣는 방법
```
class Solution {
    public ArrayList<Integer> solution(ArrayList list) {
        ArrayList<Integer> ansList = new ArrayList<>();

        for (int i = 0 ; i < list.size() ; i++) {
            int num = (int)list.get(i);
            if (!ansList.contains(num)) {
                ansList.add(num);
            }
        }
        return ansList;
    }
}
```

# 내 풀이2
- Set 으로 중복제거인데 풀이1과 거의 동일
```
class Solution {
    public ArrayList<Integer> solution(ArrayList list) {
        Set<Integer> box = new HashSet<>();
        ArrayList<Integer> ansList = new ArrayList<>();

        for (int i = 0 ; i < list.size() ; i++) {
            int num = (int)list.get(i);
            box.add(num);
        }

        for (int k : box) {
            ansList.add(k);
        }

        return ansList;
    }
}
```

# 내 풀이3
- 정렬 후에 바로 직전의 값이랑 비교해서.
- Collections.sort(list); 의 시간복잡도는? Array.sort(arr) 보다 더 늦다.
    - 참조 지역성의 원리 때문 
    - 참고할 링크 : https://sabarada.tistory.com/138
```
class Solution {
    public ArrayList<Integer> solution(ArrayList list) {
        Collections.sort(list);
        ArrayList<Integer> ansList = new ArrayList<>();
        ansList.add((int)list.get(0));

        for (int i = 1 ; i < list.size() ; i++) {
            if (list.get(i-1) == list.get(i)) {
                continue;
            } else {
                ansList.add((int)list.get(i));
            }
        }

        return ansList;
    }
}
```