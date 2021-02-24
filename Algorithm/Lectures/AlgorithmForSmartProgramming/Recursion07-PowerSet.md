# Recursion 응용 - 멱집합 (Powerset)
## 멱집합 : 어떤 집합의 모든 부분집합의 집합

멱집합 : 어떤 집합의 모든 부분집합의 집합

- {a,b,c,d,e,f}의 모든 부분집합을 나열하려면? (총 2^6개)
    - a를 제외한 {b,c,d,e,f}의 모든 부분집합들을 나열하고(총 2^5개)
    - {b,c,d,e,f}의 모든 부분집합에 {a}를 추가한 집합들을 나열하는데(총 2^5개) 그럴려면
        - {c,d,e,f}의 모든 부분집합에 {a}를 추가한 집합들을 나열하고
        - {c,d,e,f}의 모든 부분집합(S집합-k번쨰부터 마지막 원소까지 연속된 원소들)에 {a,b}를 추가한 집합들(P집합-처음부터 k-1번째 원소들 중 일부.)을 나열한다. 그럴려면 또 반복
            - {d, e, f}의 모든 부분집합들에 {a}를 추가한 집합들을 나열하고
            - {d, e, f}의 모든 부분집합에 {a, c}를 추가한 집합들을 나열한다.

## Powerset
- S는 집합
- recursion 함수가 두 개의 집합을 매개변수로 받도록 설계해야 한다는 의미. 두 번째 집합의 모든 부분집합들에 첫번째 집합을 합집합하여 출력한다.
- 제일 처음에 호출할 때는 powerSet(공집합, data); (전체 집합인 data의 집합을 구하여 출력하는 것)
```
powerSet(P,S) // Mission: S의 멱집합을 구한 후 각가에 집합 P를 합집합하여 출력하라
if S is an empty set
  print P;
else
  let t be the first element of S;
  powerSet(P, S-{t}); // t 포함 X
  powerSet(P U {t}, S-{t});  // t 포함
```

![powerset](https://user-images.githubusercontent.com/57219160/104116043-821b8080-5358-11eb-98a1-ac7fa62bc127.png)

```
private static char data[] = {'a','b','c','d','e','f'};
private static int n=data.length;
private static boolean [] include = new boolean [n];

public static void powerSet(int k) {
  if (k==n) { // S집합이 공집합이란 말. 
    for (int i=0; i<n; i++)
      if (include[i]) System.out.print(data[i] + " ");
    System.out.println();
    return;
  }
  //data[k]를 포함X 경우
  include[k]=false;
  powerSet(k+1);
  //data[k]를 포함O 경우
  include[k]= true;
  powerSet(k+1);
} 
```
- data[k], ... data[n-1]의 멱집합을 구한 후 각각에 incldue[i]=true, i=0, ... , k-1, 인 원소를 추가하여 출력하라.
- 처음 이 함수를 호출할 떄는 powerSet(0)으로 호출한다. 즉 P는 공집합이고 S는 전체집합이다.

- 상태공간트리(state space tree)
    - 해를 찾기 위해 탐색할 필요가 있는 모든 후보들을 포함하는 트리
    - 트리의 모든 노드들을 방문하면 해를 찾을 수 있다.
    - 루트에서 출발하여 체계으로 
    - 원소 {a, b, c}일 때 멱집합 구하는 과정을 시각화로 참고할 수 있음
    - 아래 트리에서 include <-> exclude로 변경되어야 됨.(ppt 틀림)

![statetree](https://user-images.githubusercontent.com/57219160/104116045-83e54400-5358-11eb-840f-6438d3d7634c.png)

![33](https://user-images.githubusercontent.com/57219160/104116071-b55e0f80-5358-11eb-8924-a12e53307c34.png)