# Recursion 응용 - 미로찾기

## 1. Recursive Thinking
- 현재 위치에서 출구까지 가는 경로가 있으려면
    1. 현재 위치가 출구이거나(=이미 출구이거나)
    2. 이웃한 셀들 중(동서남북 중 아무거나 1개 - 최대4개) 적어도 하나에서 현재 위치를 지나지 않고 출구까지 가는 경로가 있거나

## 2. Pseudo Code (Decision Problem (답이 yes/no인 문제))
- 출구가 있느냐 없느냐?(yes/no)
```
boolean findPath(x,y)
  if (x,y) is the exit
    return true;
  else
    for each neighbouring cell (x',y') of (x,y) do // neighbouring cell은 최대 4개
      if (x', y') is on the Pathway //이웃한 셀이 벽이 아니라 통로라면.
        if findePath(x',y')
          return true;
    return false;
```
- 위의 코드는 무한루프에 빠질 수 있으므로 아래와 같이 작성한다.(recursion은 항상 무한루프에 빠질 가능성이 많이 존재하므로 조심해야 한다.)
    - 왜 무한 루프 가능성? 왜냐하면 (x, y)의 인접한 셀인 (x', y')입장에서 보면 (x, y) 역시 (x', y')의 인접한 셀이 되므로. (x, y)와 (x', y')가 서로 계속 왔다갔다 할 수 있다.

```
boolean findPath(x,y)
  if (x,y) is the exit
    return true;
  else
    mark (x,y) as a visited cell; // 이미 위치(vistsed)한 곳이라고 표시
    for each neighbouring cell (x',y') of (x,y) do
      if (x', y') is on the Pathway and not visited
        if findePath(x',y')
          return true;
    return false;

```
- 위처럼 이미 지나온 곳은 돌아가지 않도록.(무한루프에 안 빠질 수 있다.)
- 아래와 같이 현재 위치를 먼저 확인할 수 있다. 위의 코드와 동일하다고 볼 수 있다.(취향차이)
    - 아래 코드는 위 코드에 비해 코드는 간결, recursion 호출횟수는 더 많음
```
boolean findPath(x,y)
  if (x,y) is either on the wall or a visited cell //현재 위치가 벽이거나 이미 방문한 곳이라면 바로 false
    return false;
  else if (x,y) is the exit
    return true;
  else
    mark (x,y) as a visited cell;
    for each neighbouring cell (x',y') of (x,y) do
      if findPath(x',y') 
          return true;
    return false;
```

## 3. Class Maze
![maze](https://user-images.githubusercontent.com/57219160/103659087-5f334a00-4faf-11eb-8f0b-0ff302845b54.png)

```
public class Maze {
  private static int N=8;
  private static int [][] maze = { // 0은 통로, 1은 벽
        {0,0,0,0,0,0,0,1},
        {0,1,1,0,1,1,0,1},
        {0,0,0,1,0,0,0,1},
        {0,1,0,0,1,1,0,0},
        {0,1,1,1,0,0,1,1},
        {0,1,0,0,0,1,0,1},
        {0,0,0,1,0,0,0,1},
        {0,1,1,1,0,1,0,0},
  };
  
  private static final int PATHWAY_COLOUR = 0;  //white(통로)
  private static final int WALL_COLOUR = 1;     //blue(벽)
  private static final int BLOCKED_COLOUR = 2;  //red(visted이며 출구까지의 경로상에 있지 않음이 밝혀진 cell)
  private static final int PATH_COLOUR = 3;     //green(visted이며 아직 출구로 가는 경로가 될 가능성이 있는 cell)


  public static boolean findMazePath(int x, int y) { //(x, y)로부터 출구까지 가는 길이 있는지 확인
    if (x<0 || y<0 || x>=N || y>=N) // (x, y)가 유효한 범위인가 먼저 체크, 길 크기가 NxN 이므로 유효한 좌표는 0~(N-1)임
      return false;
    else if (maze[x][y] != PATHWAY_COLOUR) // blue or red or green
      return false;
    else if (x==N-1 && y==N-1) { //출구
      maze[x][y] = PATH_COLOUR; //방문한 위치이므로 녹색 색칠함
      return true;
    }
    else { 
      maze[x][y] = PATH_COLOUR; // (x, y)를 방문했으므로 녹색으로
      if (findMazePath(x-1,y) || findMazePath(x,y+1) //if문은 (x, y)에 인접한 동서남북 4가지
          || findMazePath(x+1,y) || findMazePath(x,y-1) {
          return true;
      }
      maze[x][y] = BLOCKED_COLOUR;  //dead end
      return false;
    }
  }

  public static void main(String[] args) {
    printMaze();
    findMazePath(0,0);
    printMaze();
  }

}
```

