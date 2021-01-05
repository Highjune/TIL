# Recursion 응용 - Counting Cells in a Blob
![counting_cells_in_a_blob](https://user-images.githubusercontent.com/57219160/103664808-03b88a80-4fb6-11eb-935b-0704f9aaf339.png)

- 개요
    - Binary 이미지
    - 각 픽셀은 background pixel(흰색)이거나 혹은 image pixel(파란색)
    - 서로 연결된 image pixel들의 집합을 blob 이라고 부른다.
    - 상하좌우 및 대각 방향으로도 연결된 것으로 간주
- 입력
    - N * N 크기의 2차원 그리드(grid)
    - 하나의 좌표 (x,y)
- 출력
    - 픽셀 (x,y)가 포함된 blob의 크기
    - (x,y)가 어떤 blob에도 속하지 않는 경우에는 0

![blob](https://user-images.githubusercontent.com/57219160/103664875-1763f100-4fb6-11eb-89e0-208604f41eca.png)

## Recursive Thinking
```
현재 픽셀이 속한 blob의 크기를 카운트하려면
  현재 픽셀이 image color가 아니라면
    0을 반환한다.
  현재 픽셀이 image color라면
    먼저 현재 픽셀을 카운트한다 (count=1)
    현재 픽셀이 중복 카운트되는 것을 방지하기 위해 다른 색(image color랑 다른 색, ex-빨강)으로 칠한다.
    현재 픽셀에 이웃한 모든 픽셀들(대각선 포함 총 8개) 각각에 대해서
      그 픽셀이 속한 blob의 크기를 카운트하여 카운터에 더해준다.
    카운터를 반환한다.

```
```
Algorithm for countCells(x, y)
if the pixel(x, y) is outside the grid // 유효하지 않은 위치(x<0 or y<0 or x>=N or y>=N)
    the result is 0;
else if pixel (x, y) is not an image pixel or already counted
    the result is 0;
else
    set the colour of the pixel (x, y) to a red colour; / 이미 카운트되었음을 표시
    the reuslt is 1 plus the number of cells in each piece of
        the blob that includes a nearest neighbour;
```



## 구현
```
private static int BACKGROUND_COLOR = 0;
private static int IMAGE_COLOR = 1;
private static int ALREADY_COUNTED = 2;

public int countCells(int x, int y) {
  int result;
  if (x<0 || x>=N || y<0 || y>=N)
    return 0;
  else if (grid[x][y] != IMAGE_COLOR) // Background Color or already counted
    return 0;
  else {
    grid[x][y] = ALREADY_COUNTED;
    return 1 + countCells(x-1, y+1) + countCells(x, y+1)
             + countCells(x+1, y+1) + countCells(x-1, y)
             + countCells(x+1, y)   + countCells(x-1, y-1)
             + countCells(x, y-1)   + countCells(x+1, y-1);
  }
}

```