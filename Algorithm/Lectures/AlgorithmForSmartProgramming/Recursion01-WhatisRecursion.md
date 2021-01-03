# 재귀, 순환(Recursion)이란?

- 자기 자신을 호출하는 함수
```
    void func(...)
    {
        ...
        func(...);
        ...
    }
```

## 자기 자신을 호출하면 어떤 일이 벌어지는가?
- 무한루프에 빠지게 될 가능성이 있다
    - 자기 그대로의 자신을 호출한다.(무한루프를 피할 수 없다)
```
public class test {
	public static void main(String[] args) {
		func();
	
	}	
	public static void func() {
		System.out.println("Hello"); // Hello가 무한출력
		func();
	}
}

```

- 항상 무한루프에 빠지는 것은 아니다.   
    - recursion을 작성하는 것에 따라서 무한루프에 안 빠지게 할 수도 있다.
    - 자기 그대로의 자신을 호출하지 않는다.
    - Base Case만 존재한다고 해서 꼭 무한루프의 위험에서 빠져나오는 것은 아니다.
    - Recursive case가 func(k+1)이면 무한루프 됨
    ```
        public class test {
        public static void main(String[] args) {
            int n = 4;
            func(n);
        }
        public static void func(int k) {
            if (k<=0) { // Base case : 적어도 하나의 recursion에 빠지지 않는 경우가 존재해야 한다.
                return;
            } else {
                System.out.println("Hello...");
                func(k-1); // Recursive case : recursion을 반복하다보면 결국 base case로 수렴해야 한다.
            }
        }
    }
    ```
- 1~n까지의 합
```
public class test {
	public static void main(String[] args) {
		int result = func(4);
		System.out.println(result);
	}
	public static int func(int n) {
		if (n==0) {
			return 0;
		} else {
			return n + func(n-1);
		}
	}
}
```

- 순환함수와 수학적귀납법의 원리가 동일
    - 증명은 생략

## Factorial : n!을 순환으로 구현
- Recursion의 대표적인 예
- 0! = 1, n! = nx...x(n-1)!(n>0)
```
public static int factorial(int n) {
		if(n==0) {
			return 1;
		}else {
			return n*factorial(n-1);
		}
	}
```


## x^n을 순환으로 구현
- n은 음이 아닌 정수
- x^0 = 1, x^n = x*x^(n-1) (if, n>0)
```
public static double power(double X, int n) {
		if (n==0) {
			return 1;
		} else {
			return X*power(X, n-1);
		}
	}
```

## Fibonacci Number을 순환으로 구현
- F(0) = 0, F(1) = 1
- F(n) = F(n-1) + F(n-2)
- n은 자연수
```
public int fibonacci(int n) {
		if(n<2) {
			return n;
		} else {
			return fibonacci(n-1) + fibonacci(n-2); 
		}
	}
```

## 최대공약수 : Euclid Method
- 최대공약수를 구하는 알고리즘 중 가장 기본적인 알고리즘
- `m>=n인 두 양의 정수 m과 n에 대해서 m이 n의 배수이면 gcd(m, n)=n이고, 그렇지 않으면 gcd(m, n)=gcd(n, m%n)이다.`
```
public static int gcd(int m, int n) {
		if(m<n) { //m>=n이라 정의를 했기 때문에 만약 n이 더 크면 바꿈
			int tmp=n; // swap m and N 
			m=n;
			n=tmp;
		}
		if(m%n==0) {
			return n;
		} else {
			return gcd(n, m%n);
		}
	}
```

## 좀 더 단순한 Euclid Method
```
public static int gcd(int p, int q) {
		if (q==0) {
			return p;
		} else {
			return gcd(q, p%q);
		}
	}
```

