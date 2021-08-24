# 라이브러리 함수 쓰지 않고 문자열 뒤짚기
- 프로그래밍 면접, 이렇게 준비한다 p71

# 내 풀이
```
public String reverse_string(String str) {
        String result = "";

        char[] arr = str.toCharArray();

        for (int i = 0 ; i < arr.length ; i++) {
            result += arr[arr.length - 1 - i];
        }
        return result;
    }
```

# 책 풀이
```
public String reverse_string(String str) {
        String result = "";

        char[] arr = str.toCharArray();

        for (int i = arr.length - 1 ; i >= 0 ; --i) { // 감소 i-- 해도 됨
            System.out.println(i);
            result += str.charAt(i);
        }
        return result;
    }
```