# Recursion 응용 - N Queens Problem

- 가로 세로 크기가 n인 2차원 체스보드 위에 n개의 말을 놓을 때,
- 각 말의 상하좌우 대각선의 연장선 위에 어떠한 말도 없도록 말을 놓는 문제

![chess](https://user-images.githubusercontent.com/57219160/103794388-008dcf00-5088-11eb-84fd-477f157632cc.png)

## 상대공간 트리
![tree](https://user-images.githubusercontent.com/57219160/103794394-01befc00-5088-11eb-9da3-c8b51a24652c.png)
- 위 사진에서 번호들은 4x4칸의 좌표에 말 놓는 위치
- 상대공간 트리란 찾는 해를 포함하는 트리.(모든 가능한 경우를 다 나타낸 트리이므로)
- 즉 해가 존재한다면 그것은 반드시 이 트리의 어떤 한 노드에 해당한다. 따라서 이 트리를 체계적으로 탐색하면 해를 구할수 있다.
- 하지만 모든 노드를 탐색해야 하는 것은 아니다
    - 해가 될 수 있는 요건을 충족하지 않는 infeasible(실행불가능한) 한 노드들의 하위 노드는 탐색할 필요가 없다.

## Backtracking(되추적 기법)
- 상태공간 트리를 `깊이 우선 방식`으로 탐색하여 해를 찾는 알고리즘. (처음부터 하나하나 다 찾아가서 확인)
- Recursion을 사용하거나 Stack(자료구조 이용)을 사용할 수 있지만, 대부분 recursion으로 구현하는 것이 쉽고 분명

## Design Recursion
- 내가 도착한 노드(파라미터)가 어떤 노드인지 판단하고 그에 따라 행동하는 것
```
return-type queens( arguments) // 매개변수는 내가 현재 트리의 어떤 노드에 있는지를 지정해야 한다.
{
  if non-promising(꽝) // 즉, infeasible하느냐? - 다른 말들이랑 충돌이 일어나서 가능성이 없다면 그 노드의 밑으로는 내려가보지 않아도 된다.
    report failure and return;
  else if success
    report answer and return;
  else
    visit children recursively; // 지금 위치하고 있는 노드의 자식 노드를 다 확인
}
```
- 매개변수 level은 현재 노드의 위치를 표현하고, 1번에서 level(1)의 말이 어디에 놓였는지는 전역변수 배열 cols로 표현한다.
    - cols[1] : 1번말이 놓인 열번호
    - cols[2] : 2번말이 놓인 열번호
    - cols[level] : level번말이 놓인 열번호
- level은 노드트리를 가로로 잘랐을 때의 층이다. 제일 꼭대기(start)지점이 level(0)이고 1.1, 1.2, 1.3, 1.4 는 level(1)임
- level은 1~level번째 말이 이미 다 놓였다는 것을 의미(행을 알 수 있다)하며 cols[n]의 값을 통해서(열을 알 수 있다) 가장 최근에 놓은 말의 위치를 알 수 있다.
- promising 테스트를 통과했다는 가정하에 level==N이면 모든 말이 놓였다는 의미이고 따라서 성공이다.
```
int[] cols = new int [N+1];
boolean queens( int level )  // 전역변수 cols와 매개변수 level로 노드의 현재 위치를 제공한다.
{
  if (!promising(level)) 
    return false;
  else if (level == N) {
    for (int i=1; i<=N; i++)
      System.out.println("(" + i + ", " + cols[i] + ")"); // success일 경우에 실제 말들의 위치 출력
    return true;
  }
  //level번째 말이 다 놓여진 상태
  for (int i=1; i<=N; i++) { // (level+1)번째 말을 n개의 경우의 수(열) 중에 어디에 놓을 것인가.
    cols[level+1] = i; // (level+1)번째 말을 i번째 열에 놓는 것
    if (queens(level+1)) 
      return true;
  }
  return false;
}
```
## Promising Test
![promisnigtest](https://user-images.githubusercontent.com/57219160/103794400-02f02900-5088-11eb-9c83-1fab7407d9ae.png)
- 놓여진 말들이 충돌이 있느냐
- 현재 level값 이전의 것들은 이미 충돌이 없음이 보장되어 있다. 
- 따라서 마지막에 놓인 이 말이(level번째) 이전에 놓인 말들과 충돌하는지 검사하는 것으로 충분
```
boolean promising( int level)
{
  // i는 이미 놓여진 말
  for (int i=1; i<level; i++) { // level-1까지 검사
    if (cols[i]==cols[level]) // 같은 열에 놓였는지 검사
      return false;
    else if (level-i == math.abs(cols[level]-cols[i]) // 같은 대각선에 놓였는지 검사
      return false;
  }
  return true;
}
```
- 대각선 놓였는지 검사
![diagonal](https://user-images.githubusercontent.com/57219160/103794406-04215600-5088-11eb-9c9a-69d64a4373f6.png)