# Designing Recursion(순환 알고리즘의 설계)
- Recursion의 조건
	- 적어도 하나의 base case, 즉 순환되지 않고 종료되는 case가 있어야 한다.
	- 모든 case는 결국 base case로 수렴해야 함.
- 암시적(imnplicit) 매개변수를 **명시적(explicit) 매개변수**로 바꾸어라.


## 순차 탐색(Sequential Search)
```
int search(int [] data, int n, int target) { //n은 저장된 데이터의 갯수
  for (int i=0; i<n; i++)
    if (data[i]==target)
      return i;
  return -1; // 찾고자 하는 값이 없는 경우
}
```
- 이 함수의 미션은 data[0]에서 data[n-1] 사이에서 target을 검색하는 것이다. 하지만 검색 구간의 시작 인덱스 0은 보통 생략한다. 즉 암시적 매개변수이다.
- [0, n-1] 에서의 끝인 n-1은 매개변수로 들어오는 n에 의해서 **명시적으로 표현이 되었다.** 라고 할 수 있다.(물론 n과 n-1은 같진 않지만 n개를 표현함에 있어서 당연히 n-1까지라고 표현하기 때문에)
- 하지만 [0, n-1] 에서의 시작인 0은 표현되지 않고 **암시된 것.** 배열의 데이터가 n개이므로 인덱스가 0부터 시작되는 것이라고 암묵적으로 생각할 뿐, 데이터가 저장되어 있는 곳의 시작지점이 명시적으로 함수상에 표현이 되어있지 않음
- 매개변수가 많은 것은 좋지 않으므로, 암시적으로 생략하는 것이 코드를 간결하게 만들 수 있다. 하지만 일반적으로는 이렇게 하지 않는다. 즉 아래처럼 **명시적**으로 표현해줘야 한다. (recursion의 중요한 조건)

## 매개변수를 명시화한 순차 탐색
```
int search(int [] data, int begin, int end, int target) {
  if (begin > end) // base case. 검색할 데이터의 갯수가 0개일 경우임. (만약 begin==end라면 데이터의 갯수가 1개란 말)
    return -1;
  else if (target == data[begin])
    return begin;
  else
    return search(data, begin+1, end, target);
}
```
- 이 함수의 미션은 data[begin]에서 data[end] 사이의 target을 검색한다. 즉, 검색구간의 시작점을 명시적(explicit)으로 지정한다. begin의 앞쪽과 end의 뒤쪽은 검색 영역에 속하지 않는다.
- 이 함수를 search(data, 0, n-1, target)으로 호출한다면 위의 순차탐색에 있는 함수와 완전히 동일한 일을 한다.
- 하지만 시작점이 0가 되면 Recursion을 사용할 수 없기 때문에 설계할 때 부터 0이 아닌 begin으로 설계한다.그래서 매개변수로 시작지점을 명시해줘야 한다.


## 순차탐색 다른 버전 1
- 뒤에서 앞으로 찾는다.
```
int search(int [] data, int begin, int end, int target) {
  if (begin > end)
    return -1;
  else if (target == data[end])
    return end;
  else
    return search(data, begin, end-1, target);
}
```
- 이 함수의 미션은 data[begin]에서 data[end] 사이에서 target을 검색한다.
즉, 검색구간의 시작점을 명시적(explicit)으로 지정한다.

## 순차탐색 다른 버전 2
- 가운데 나누어서 찾기 (binary search와는 다르다)
- 반(A/B)을 나누어서 중간값을 확인해보고 나서, 앞의 반(A)에서 다 찾은 후 없으면 그 뒤에 반(B)에서 찾는다.
- 만약 B에서도 없다면 찾는 값은 없는 것
```
int search(int[] data, int begin, int end, int target) {
  if (begin > end)
    return -1;
  else {
    int middle = (begin+end)/2; //데이터의 갯수가 짝수개면 정확한 중간값이 아닐수도 있다.
    if (data[middle] == target)
      return middle;
    int index = search(data, begin, middle-1, target);
    if (index != -1)
      return index;
    else
      return search(data, middle+1, end, target);
  }
}
```

## 매개변수의 명시화 : 최대값 찾기
- 이 함수의 미션은 data[begin]에서 data[end] 사이에서 최대값을 찾아 반환한다. begin<=end 라고 가정한다.
```
int findMax(int [] data, int begin, int end) {
  if (begin==end)
    return data[begin];
  else
    return Math.max(data[begin], findMax(data, begin+1, end));
}
```
- 최대값 찾기 다른버전
  - 반으로 나누어서 앞쪽의 최대값과 뒤쪽의 최대값을 비교
```
int findMax( int [] data, int begin, int end) {
  if (begin==end)
    return data[begin]
  else {
    int middle = (begin+end)/2;
    int max1 = findMax(data, begin, middle);
    int max2 = findMax(data, middel+1, end);
    return Math.max(max1,max2);
}
```


## Binary Search
- items[begin]에서 items[end] 사이에서 target을 검색한다.
- 이진검색을 recursion으로.
- 이진검색은 데이터가 크기순으로 정렬되어 있을 때만 사용 가능하다.
```
public static int binarySearch(String[] items, String target, int begin, int end) {
  if (begin>end)
    return -1;
  else {
    int middle = (begin+end)/2;
    int compResult = target.compareTo(items[middle]); // 기준값이 비교대상 보다 크면 양수, 작으면 음수, 같으면 0
    if (compResult == 0)
      return middle;
    else if (compResult<0)
      return binarySearch(items, target, begin, middel-1);
    else
      return binarySearch(items, target, middle+1, end);
  }
}
```