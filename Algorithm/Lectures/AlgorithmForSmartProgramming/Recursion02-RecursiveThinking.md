# Recursive Thinking 순환적으로 사고하기
- 수학함수뿐 아니라 다른 많은 문제들을 recursion으로 해결할 수 있다.

## 문자열의 길이 계산
```
if the string is empty {
		return 0; // Base Case
	} else {
		return 1 plus the length of the string that excluded the first character;
	}
```

```
public static int length(String str) {
		if(str.equals("")) { //문자열의 길이가 0이라면
			return 0;
		} else {
			return 1+length(str.substring(1));
		}
	}
```

## 문자열 프린트
```
public static void printChars(String str) {
		if(str.length()==0) {
			return;
		} else {
			System.out.println(str.charAt(0));
			printChars(str.substring(1));
		}
	}
```

## 문자열을 뒤집어 프린트
- 문자열 프린트와 다른점은 else부분의 두 개의 실행문장의 순서가 바뀐 것
```
public static void printCharsReverse(String str) {
		if(str.length()==0) {
			return;
		} else {
			printCharsReverse(str.substring(1));
			System.out.println(str.charAt(0));
		}
	}
```

## 2진수로 변환하여 출력
- 마지막 비트가 0 = 짝수, 1 = 홀수
- 음이 아닌 정수 n을 이진수로 변환하여 인쇄한다.
```
public void printInBinary(int n) {
		if(n<2) { // Base Case
			System.out.println(n);
		} else {
			printInBinary(n/2); // 먼저 n을 2로 나눈 몫을 먼저 2진수로 변환하여 인쇄한다.
			System.out.println(n%2); // n을 2로 나눈 나머지를 인쇄한다.(제일 마지막 비트)
		}
	}
```

## 배열의 합 구하기
- data[0]에서 data[n-1]까지의 합을 구하여 반환한다.
- 즉, 1~n개의 합은 1~(n-1)개의 합 + n(제일 마지막 것)
```
public static int sum(int n, int [] data) {
		if(n<=0) { //Base Case
			return 0;
		} else {
			return sum(n-1, data) + data[n-1]; // data[0] 에서 data[n-2]까지의 합 + data[n-1]
		}
	}
```

## 데이터파일로부터 n개의 정수 읽어오기
- Scanner는 데이터파일
- Scanner in이 참조하는 파일로부터 n개의 정수를 입력받아 배열 data의 data[0],...,data[n-1]에 저장한다.
- 자주 쓰이진 않는다.
```
public void readFrom(int n, int[] data, Scanner in) {
		if(n==0) {
			return;
		} else {
			readFrom(n-1, data, in); // data[n-2]까지 저장
			data[n-1] = in.nextInt(); // 마지막 1개를 data[n-1]에 저장
		}
	}
	
```

## Recursion VS Iteration
- 모든 순환함수는 반복문(iteration)으로 변경 가능
- 그 역도 성립함. 즉, **모든 반복문은 recursion으로 표현 가능함**
- 순환함수는 복잡한 알고리즘을 단순하고 알기 쉽게 표현하는 것을 가능하게 함.
- 하지만 함수 호출에 따른 오버헤드가 있음(매개변수 전달, 액티베이션 프레임 생성 등)