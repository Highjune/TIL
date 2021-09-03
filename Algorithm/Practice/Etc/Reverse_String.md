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

# 책 풀이1
- 비추천. 왜냐하면 매번 String은 새로운 객체가 생성되는 것이므로.
```
public String reverse_string(String str) {
        String result = "";

        char[] arr = str.toCharArray();

        for (int i = arr.length - 1 ; i >= 0 ; --i) { // 감소 i-- 해도 됨
            System.out.println(i);
            result += str.charAt(i);    // 매번 Strnig 객체가 생성되는 것이므로 메모리 낭비
        }
        return result;
    }
```

# 책 풀이2
- 추천
```
public String reverse_string(String in) {
    int len = in.length();
    StringBuilder out = new StringBuilder(len); // 파라미터 len 없어도 됨
    for (int i = len - 1 ; i >= 0 ; --i) {
        out.append(in.chartAt(i));
    }

    return out.toString();       
        
}
```

