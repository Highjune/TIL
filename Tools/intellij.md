# 인텔리J

## 단축키
- [단축키참고링크](https://gmlwjd9405.github.io/2019/05/21/intellij-shortkey.html)

- intelli J 툴 안에서 단축키 확인하는 방법
  - settings - keymap 확인가능


- 해당하는 괄호의 짝 찾기. 
```
ctrl + m
```

- 현재 클래스의 멤버변수들 확인하기. outline. 롬복이 실행되었는지도 확인가능
```
command + f12
```

- 단축키 템플릿은 Live templates 에서 적용하면 됨
  - ex) custom 그룹 만들어서 tdd
  ```
  @Test
  public void $NAME$() throws Exception {
      //given
      $END$
      //when
      
      //then
  }
  ```

- 컨트롤러 /url 찾기
  - command + shift + \ (역슬러쉬)

- 드래그 한 후 해당한 파일 찾기
  - command + shift + o 


- 작성중인 함수의 파라미터 요소, 타입 확인하기
```
command + p
```

- 해당 라인 바로 찾아가기
```
command + L
```

- 블록 주석
  - 블럭한 뒤에
  ```
  option + command + /
  ```

- 찾기
```
command + o
```

- 구현체들 찾기. 인터페이스 위에 커서 올려두고
```
command + option + B
```

- 코드상에서 클래스 이름 바로 변경하기
  - 클래스 이름 위에 커서 두고
  ```
  shift + fn + f6
  ```

- 입력하고 있는 줄에서 바로 밑으로 한 줄 내려가기
```
command + shift + 엔터
```
- 메서드 사용시 필요한 파라미터 인자 확인
```
괄호 안에서
command + p
```

- 과거 히스토리(내역, history) 검색
```
command + e
```
- 바로 이전으로 돌아가기
```
command + e + 엔터
```

- 리턴의 값을 한줄로 표현하기
  ```
  command + option + n
  ```
  - ex) 
  - 전
  ```
  List<Member> list = find~~
  return list;
  ```
  - 후
  ```
  return find~
  ```

- 왼쪽에 Project 창 크기 조절
  - Project 부분에 커서 두고 (command + 1번 하면 이쪽 영역ㄷ으로 넘어감)
  ```
  command + shift + 왼쪽방향키 or 오른쪽방향키
  ```
  - esc 누르면 다시 코드쪽으로 돌아옴

- 포커스 뒤/앞으로 가기
  - 이전 커서가 있던 화면으로 돌아갈 때 편함
  ```
  command + [ 또는 ]
  ```

- 리턴 값 합치기
```
command + option + n
```
  - ex)
  ```
  int count = ac.getCount();
  return count;
  ```
  - 단축키로 합치면(count 위에 커서 두고)
  ```
  return ac.getCount();
  ```


- 테스트 클래스 바로 만들기
```
해당하는 클래스 이름 코드줄 위에 커서 두고
command + shift + t
```

- 리턴값 자동 생성
```
command + option + v
```
- 리팩토링과 관련된 여러 기능 확인
```
ctrl + t
```

- 특정 부분 함수로 뽑아내기(extract method)
```
블럭지정 후
command + option + m
```

- 액션창 열기
```
command + shift + a
```

- 빨간색으로 줄 쳐진 곳. 에러난 곳으로 바로 이동하기
```
f2
```

- build.gradle안에서 compile메소드의 자동완성
```
ctrl + space
```
- System.out.println()
  - 맥
  ```
  sout 후 tab키
  ```

- 메인메서드 단축키
  - 맥
  ```
  psvm 후 tab키
  ```
- action

  - 윈도우

  ```
  ctrl + shift + a
  ```

  - 맥

  ```
  command + shift + a
  ```

- 프로젝트에서의 새 파일생성(프로젝트 클릭후)

```
art + insert
```

- 깃 커밋창 열기(물론 깃 연동 후)

  - 윈도우

  ```
  ctrl + k
  ```

  - 맥

  ```
  command + k
  ```

- 깃 push
  - 윈도우
  ```
  ctrl + shift + k
  ```
  - 맥
  ```
  command + shift + k
  ```
- 패키지 가져오기

  - 윈도우/리눅스

  ```
  alt + enter
  ```

  - 맥

  ```
  option + enter
  ```

- 파일 이름 변경
  - 윈도우
  ```
  shift + f6
  ```
- 라인 단위 복사

  - 윈도우/리눅스

  ```
  ctrl + d
  ```

- 라인 단위 옮기기
  - 윈도우/리눅스
  ```
  alt + shift +  ↑↓
  ```
- 라인 단위 삭제
  - 윈도우/리눅스
  ```
  ctrl + y
  ```
- 해당하는 메서드로 이동
  - 윈도우/리눅스
  ```
  ctrl + b
  ```

- 메서드 안에 있는 것을 파라미터로 빼내기
```
option + command + p
```

- 특정한 비즈니스 코드를 함수로 빼내기(추출)
  - 별도로 빼내고 싶은 비즈니스 코드 블럭지정 후 (윈도우/리눅스)
  ```
  ctrl + art + m
  ```
  - 맥
  ```
  option + command + m
  ```  
- 변수 일괄 변경
```
shift + f6
```
- 현재 함수에서 파라미터 추가하기 (파라미터로 추가하고자 하는 것 커서 위에 두고)
```
option + command + p
```

- String을 별도의 상수로 뽑기
```
option + command + c
```

- 오버라이드 메서드 불러오기 (인터페이스 등 구현했을 때)
```
control + o 
```
- 

- 여러 줄 한번에 선택하기
  - option 한번 누른 후, 두번째 눌렀을 땐 누른 상태에서 위아래 화살표
  ```
  option, option + 위아래 화살표
  ```
  - column select mode 켜고 나서(shift + command + 8), shift 누른 상태에서 위아래 화살표로 해도 된다

- 해당 코드 줄 위아래로 옮기기
```
shift + command + 위아래 화살표
```

- 단어, 문자 바꾸기 replacement (하나의 파일 안에서)
```
command + r
```
- 단어, 문자 바꾸기 replacement (하나의 파일 안에서)
```
command + shift + r
```
  
- 해당 클래스에 대한 테스트클래스 바로 만들기
  - 윈도우/리눅스
  ```
  ctrl + shift + t
  ```

- 동시에 같은 변수 수정
  - 윈도우/리눅스
  ```
  shift + f6
  ```

- 리턴값 자동생성
  - 윈도우/리눅스
  ```
  ctrl + art + v
  ```



## 깃 연동하기

## 참고자료

[intelliJ 에서는 이클립스처럼 여러 프로젝트를 한 번에 열수 있는가?](https://jojoldu.tistory.com/334#ref=facebook)
[intelliJ gitBash 연동하는 법](https://goddaehee.tistory.com/250)
[intelliJ 디버그하는 법](https://jojoldu.tistory.com/149)
