# .gitignore 파일
## https://github.com/github/gitignore 사이트에 찾을 수 있음
## 아래 예시들과 설명들은 책 `프로 Git 2/E` 에서 공부하며 적은 것들 
- Git이 관리할 필요 없다. 보통 로그 파일이나 빌드 시스템이 자동으로 생성한 파일들


# 기본적인 패턴
- 아무것도 없는 라인이나, `샾` 으로 시작되는 라인은 무시한다.
- 표준 Glob 패턴을 사용한다.
- 슬래시(/) 로 시작하면 하위 디렉터리에 적용되지(recursivity) 않는다.
- 디렉터리는 실래시(/)를 끝에 사용하는 것으로 표현한다.
- 느낌표(!)로 시작하는 패턴의 파일은 무시하지 않는다.

# 의미
- 애스터리스크(*)는 문자가 하나도 없거나 하나 이상을 의미
- [abc] 는 중괄호 안에 문자 중 하나를 의미한다(그러니까 이 경우에는 a, b, c)
- 물음표(?) 는 문자 하나를 뜻함
- [0-9] 처럼 중괄호 안의 캐릭터 사이에 붙임표(-)를 사용하면 그 캐릭터 사이에 있는 문자 하나를 의미한다.
- 애스터리스크 2개를 사용하여 디렉터리 안의 디렉터리까지 지정할 수 있다.
    - a/**/z 패턴은 a/z, a/b/z, a/b/c/z 디렉터리에 사용할 수 있다.


# .gitignore 파일의 설명과 예시
- 확장자가 .a인 파일 무시
```
*.a
```
- 확장자가 '.o'나 '.a'인 파일은 무시하는 것
    - '.o'와 '.a'는 빌드 시스템이 만들어내는 오브젝와 아카이브
```
*.[oa]
```
- 윗윗 라인에서 확장자가 .a인 파일은 무시하게 했지만 lib.a는 무시하지 않음
```
!lib.a
```
- ~로 끝나는 모든 파일을 무시
    - ~로 끝나는 파일은 Emacssk vi 같은 텍스트 편집기가 임시로 만ㄷ릉너ㅐ는 파일
```
*~
```
- 현재 디렉터리에 있는 TODO 파일은 무시하고 subdir/TODO처럼 하위 디렉터리에 있는 파일은 무시하지 않음
```
/TODO
```
- build/ 디렉터리에 있는 모든 파일은 무시
```
build/
```
- doc/notes.txt 파일은 무시하고 doc/server/arch.txt 파일은 무시하지 않음
```
doc/*.txt
```
- doc 디렉터리 아래의 모든 .pdf 파일을 무시
```
doc/**/*.pdf
```