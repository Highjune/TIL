- [만화로 배우는 리눅스 시스템관리 1](http://www.yes24.com/Product/Goods/30705473)를 보고 정리한 내용

# 개념
- 셸(shell)
  - 사용자가 콘솔 환경에서 대화식으로 명령어를 입력하면서 사용하는 소프트웨어
  - 리눅스에서 bash나 dash라는 셸을 사용하는 경우 많음
  - vim으로 텍스트 편집하거나 grep으로 파일을 찾을 때, 이런 다양한 소프트웨어를 사용자 요구에 따라 실행하거나 조작을 돕는 게 셸의 역할
  - GNOME 단말은 셸인가?
    - No. GNOME 단말은 GUI 환경에서 셸을 실행하기 위해 사용하는 것으로 셸 자체가 아니다. tmux, ssh 도 마찬가지. 셸이라는 소프트웨어에 입력(vim 등)을 부탁하는 것

# 리눅스 명령어

## 명령어 내역 확인

```
history
```

또는

```
vim ~/.bash_history
```

## root 권한 얻기

- 아래 명령어 후 비밀번호 권한 받기.
- root 권한으로 명령어 실행하면 일반 user가 접근 못한다.

```
sudo su
```

## 리눅스에서 프로세스를 실행한 터미널의 세션 연결이 끊어지더라도 지속적으로 동작 할 수 있게 해주는 명령어

```
nohup
```

## 백그라운드에서 실행 명령어

```
&
```

## 실행중인 프로세스 확인

```
ps
```

- 옵션
  - `e` 실행중인 모든 프로세스의 정보
  - `f` 프로세스에 대한 자세한 정보 출력 (ppid 확인 가능)
  - ex) 현재 실행중인 프로세스의 자세한 정보 + 'api' 단어 확인

```
ps -ef | grep api
```

## 명령어 후방(밑 방향으로) 검색

```
history
ctrl + r 후에 찾고자 하는 것 입력 ex) vim  후에 ctrl + r 계속 누르면서 찾기.(위로 올라감)
```

## 명령어 전방(위 방향으로) 검색

- 설정 변경이 필요함

```
vim ~/.bashrc 로 설정 파일 열기
shift + g 로 파일 마지막으로 이동
stty stop undef 입력
```

- 콘솔 환경에 재로그인. bash를 재실행해서 새로운 설정을 읽어 들이는 것
- `ctrl + s` 후에 찾고자 하는 것 입력 ex) vim 후에 `ctrl + s` 계속 누르면서 찾기.(아래로 내려감)
- `ctrl + s` 는 초기상태에서는 다른 조작이 할당되어 있다. 그 설정을 변경해서 bash에서 `ctrl + s` 명령어를 사용할 수 있게 한 것
- 다른 서버에서도 전방 검색을 하려면 그 서버에서도 위와 같은 설정이 필요하다.

## 파일 끝으로 이동

```
shift + g
```

## 파이프라인(|)

- 어떤 명령어 실행 결과 출력을 그대로 다른 명령어에 넘김. 즉 앞의 출력이 뒤의 입력이 됨
- 받는 쪽 명령어는 열어야 할 파일 지정을 생략한다.
- 여러 번 사용 가능
- 콘솔애플리케이션에서 사용가능한 것이지 GUI애플리케이션 다수에서는 사용 못함

```
grep "/retro" access.log.1 | less
```

```
(중간의 grep -v "/live" 는 앞의 출력결과에서 지정한 문자열(/live) 을 포함하지 않는 줄만 출력)
grep "/retro" access.log.1 | grep -v "/live" | less
```

## `top` 시스템 상태 전반적으로 확인(cp, memory, process)

- `shift + m` 메모리사용률 내림차순으로, `shift + t` CPU시간 순서, `shift + p` CPU 사용량 순서.
- (shift + m 누른 후) `c` 상세표시 전환

```
top
shift + m
c
q(top 모드 종료, quit 의미)
```

## 실행중인 프로세스 종료

```
kill PID
```

```
다른 사용자의 프로세스라면 sudo 붙여야됨
sudo kill PID
```

```
여러 프로세스 ID를 동시에 띄워서 나열하면 동시에 종료 가능
sudo kill 111 222 333 444 ...C
```

## 디렉토리 삭제

- rm는 파일은 삭제할 수 있지만 디렉토리는 삭제하지 못한다. 디렉토리와 그 내용물을 모두 삭제하려면 rm -r 으로 하면 된다. 이 때 정말 삭제하시겠습니까 ? 라는 문구가 각 파일 하나씩 다 나온다
- 삭제 질문이 뜨지 않게 하려면 rm -rf으로. rm -rf는 확인절차 없이 삭제하므로 극도로 조심해서 사용해야 한다. 리눅스에서는 삭제된 파일이나 디렉토를 절대 복구 못한다.
- cf) rm 이라고 치면 도움말을 확인할 수 있다.

```
rm -r 디렉토리_이름
rmdir -r 디렉토리_이름

rm -rf 디렉토리_이름
rmdir -rf 디렉토리_이름
```

## 우분투 패키지 관리툴 업데이트

```
sudo apt-get update
```

## grep

- `-r`은 서브 폴더까지 검색하도록 지정. 재귀적으로 찾는 것임
- `-i`는 ignore case, 즉 알파벳 대문자, 소문자 차이 무시하고 검색
- grep -r -i "검색하고 싶은 문자열" 찾을 파일이 있는 폴더 경로(검색 시작점) 및 파일
- `-E` 정규 표현식을 사용할 때 앞에 붙임.
- 정규 표현식들
  - `()` 그룹화
  - `|` 좌우 중 하나
  - `?` 직전 표현이 0회 또는 1회 등장
  - `*` 직전 표현이 0회 이상 연속해서 등장
  - `+` 직전 표현이 1회 이상 연속해서 등장
  - `.` 임의의 한 문자
  - `^` 줄 머리
  - `$` 줄 끝
- 압축 파일은 grep으로 직접 쓸 수 없다. zcat 등의 로그 파일 압축 형식에 맞는 명령어로 열어야 한다.

```
(/home/docs/ 밑에 있는 모든 파일안에서 대소문자 무관하게 "api" 단어를 가진 파일과 그 문자열을 다 찾아낸다)
grep -r -i "api" /home/docs/
```

```
grep -r -i -E "((야메로) *(타로)|yamero +tarou)" /home/docs/
```

```
(아래처럼 -r옵션이 없으면 파일 안에서 지정한 내용을 포함한 줄을 찾을 수 있다.)
grep "orange" /var/log/apache2/access.log
```

## 로그 파일 압축 출력

- 오래된 로그 파일은 디슼 용량을 아끼기 위해 압축한다. 그 압축파일들을 grep으로 직접 사용할 수 없다.
- `cat` 비압축 테스트 파일용. 지정한 파일 내용을 읽어서 그대로 출력
- `zcat` gzip형식 전용 .gz .tgz 가능
- `xcat` xz형식 전용 .xz 가능
- `unzip` zip형식 전용

## `지금 이 순간` 실시간 로그 확인

- tail은 파일 내용 끝부분만 출력
- `-F` 옵션은 파일 변경을 감시해서 내용이 추가될 때마다 그 부분을 실시간으로 출력

```
tail -F access.log
```

## cut

- 필요한 줄만 뽑고 싶을 때
- 포인트는 구분자(delimiter), 구분자는 글자 하나만 지정 가능
- 옵션은 -d, -f 2가지. 보통 2가지를 같이 쓴다.

```
--delimiter "구분자"
또는
-d "구분자"

--fields 추출할 위치
또는
-f 추출할 위치
```

- ex1) " " 공백으로 끊었을 때 7번째 것

```
cut -d " " -f 7
```

- ex2) access.log에서 "/live" 포함한 것 빼고, 공백으로 끊었을 때 7번째 것을 출력

```
cat /var/log/apache2/access.log | grep -v "/live" | cut -d " " -f 7 | less
```

- 일부열만 제거하는 것도 가능
- 그래서 CSV(Comma Separated File) 파일을 cut을 써서 간단히 열 단위로 정보 추출 가능
  - `-f` 옵션으로 열 번호 지정, 여러 숫자를 지정하거나 열 범위를 지정할 수도 있다.
  - 연속한 열일 경우 `범위 시작-끝`
  ```
  cat items.csv | cut -d "," -f 1-3
  ```
  - 어떤 열 이후의 모든 열을 지정한다면 끝을 생략하고 `시작-`, 아래는 4부터 모든 열 지정
  ```
  cat items.csv | cut -d "," -f 4-
  ```
- cut 구분자 문자가 지정되지 않으면 cut명령어는 `탭문자를 구분자로 사용`한다. 셸 스크립트 안에서라면 `cut -d "(탭문자)"`로 사용가능.

## sort와 uniq

- 같은 내용의 줄을 셀 때 유용
- 둘은 거의 붙어다님
- sort는 알파벳 순서로 재정렬. 각 줄의 내용을 앞에서부터 비교해서 숫자순, 알파벳순으로 정렬. 기본은 오름차순. `--reverse` 또는 `-r`옵션은 내림차순

```
cat input.txt | sort
```

- uniq는 중복제거
  - 그런데 연속으로 위치해있는 중복밖에 제거하지 못한다. 같은 내용이 띄엄띄엄 있으면 중복제거 하지 못함.
  ```
  cat input.txt | uniq
  ```
- sort와 uniq를 동시에 사용
  - 미리 sort해서 정렬후에 uniq하면 띄엄띄엄 있는 것들을 중복 제거 가능
  ```
  cat input.txt | sort | uniq
  ```
- uniq는 같은 내용이 몇 번 등장했는가를 셀 수도 있다. `--count`옵션, `-c` 도 마찬가지.

  - 참고) `uniq -c` 옵션은 숫자가 오른쪽 정렬이다. `uniq -c` 결과는 sort에서 사용하는 경우가 많으니까 `단순 정렬`로도 문제없도록 만들어 둔 것.

  ```
  uniq -c
  ```

  - 위와 같이 쓰게 되면 제일 앞에 횟수가 나온다. 즉 중복도 제거하고 등장 횟수도 셈
  - ex) 접속한 페이지 경로 목록에 같은 경로의 등장 횟수 세기

  ```
  cat /var/log/apache2/access.log | grep -v "/live" | cut -d " " -f 7 | sort | uniq -c | less
  ```

  - 위와 같은 uniq 결과를 보면 경로 등장 횟수가 줄 맨 앞에 출력되어 있다.
  - 그래서 위의 결과를 파이프 라인을 통해 다시 sort 로 보내면 된다.

  ```
  cat /var/log/apache2/access.log | grep -v "/live" | cut -d " " -f 7 | sort | uniq -c | sort | less
  ```

  - 역순. sort에 `-c` 옵션

  ```
  cat /var/log/apache2/access.log | grep -v "/live" | cut -d " " -f 7 | sort | uniq -c | sort -c | less
  ```

  - 모든 것에 대한 목록(오름차순이든 내림차순이든)은 필요없으니 tail, head 명령어를 사용하면 된다.

  ```
  cat /var/log/apache2/access.log | grep -v "/live" | cut -d " " -f 7 | sort | uniq -c | sort -r | tail
  ```

- 예시(shell script로)

```
#!/bin/bash
log=/var/log/apache2/access.log
count=10

echo "접속수가 많은 ${count}개 페이지:"
cat $log | grep -v "/live" | cut -d " " -f 7 | sort | uniq -c | sort -c | head -n $count

echo "접속수가 적은 ${count}개 페이지:"
cat $log | grep -v "/live" | cut -d " " -f 7 | sort | uniq -c | sort -c | tail -n $count
```

- sort명령어도 cut처럼 특정 구분자로 나누는 기능이 있다.
  - 구분자 지정은 `--field-separator` 또는 `-f`
  - `-k`옵션으로 열 번호를 지정하면 그 열 내용으로 재정렬
  - ex) , 를 구분자로 구분했을 때 3번째 열 기준으로 정렬
  ```
  sort -t "," -k 3
  ```
  - 그런데 sort는 문자열을 한 문자씩 비교해서 재배치하므로 `단순정렬` 기준이다. 예를 들어 `10`은 `2`보다 앞에 정렬이 되는 것처럼. 왜냐하면 `10`의 `1`이 `2`보다 앞이므로 앞에 정렬되는 것임.
  - `숫자정렬`을 하려면 `--number` 또는 `-n` 옵션.
  - ex)
  ```
  cat items.csv | cut -d "," -f 1-3 | sort -t "," -k 3 -n | less
  ```
- `-b`옵션은 ?
  - `uniq -c` 결과는 기본적으로 숫자가 오른쪽 정렬이라 sort에서 `단순 정렬` 하더라도 문제가 없긴 했었다. 하지만 스페이스로 칸을 채워서 오른쪽으로 줄맞춤한 문자열은 단순 정렬해도 기대한 것과 다른 결과.
  - 그래서 `--ignore-leading-blanks` 또는 `-b` 옵션을 사용하면 오른쪽 줄맞춤을 위해서 넣은 스페이스를 무시하고 문자열을 정렬할 수 있다.
  - 데이터 예시
  ```
   8,          딱풀, 44, 220, 재고없음
   9,      샤프펜슬, 50, 401, 재고있음
  10,          볼펜, 10, 222, 재고있음
  ```
  - `-b`옵션 사용 예시
  ```
  cat items.csv | cut -d "," -f 1-3 | sort -t "," -k 2 -b
  ```

## 리다이렉트 >, >>

- 명령어 실행 결과를 저장하는 기본 테크닉
- `|`대신에 `>`를 사용하면 보통은 파이프라인으로 넘어가는 것과 같은 내용이 텍스트 파일로 출력된다
- `>`가 하나뿐인 리다이렉트는 이미 파일이 있으면 지우고 새로운 파일 만든다. `>`를 두 번 이어서 쓴 `>>` 리다이렉트면 기존 파일에 추가한다.
- 그래서 `>`는 파일명이 같으면 덮어쓰므로 반드시 다른 이름을 지정해야 한다.
- ex)

```
cat items.csv | cut =d "." -f 1-3 | sort -t "," -k 3 -n > ./items-sorted.csv
echo "12345, 추가항목, 0" >> ./items-sorted.csv
```

- 위처럼 `echo`명령어를 사용해서 임의의 문자열을 파일에 추가 가능하다.

## tail, head

- tail은 파일이나 파이프라인 입력 `끝에서` 10줄만 추출하는 것
- head는 파일이나 파이프라인 입력 `앞에서` 10줄만 추출하는 것
- `-n`옵션으로 출력하는 줄 수 조정 가능
  - 앞에서부터 3줄 추출
  ```
  head -n 3
  ```
  - 뒤에서부터 3줄 추출
  ```
  tail -n 3
  ```
- 부분출력
  ex) a b c d e f g h i j k l m n o p q r s t u v w x y z (head쪽 <---> tail쪽)

```
head -n 5 // 앞에서 5줄째까지. a b c d e 출력
head -n -5 // 앞에서 뒤에서 5개(v w x y z) 제외까지. a b c d e f g h i j k l m n o p q r s t u
tail -n +6 // 뒤에서 앞에서 5개(a b c d e) 제외까지. f g h i j k l m n o p q r s t u v w x y z, tail -n +6 만 지정하는 숫자가 조금 다름.
tail -n 5 // 뒤에서 5줄째까지. v w x y z
```

# vim

[cheat-sheet](https://vim.rtorr.com/lang/ko)

- 실행

```
vim 파일이름
```

또는 `vim 파일 경로`

```
vim /etc/경로~
```

만약 시스템 설정 파일을 변경하려면 `sudo` 붙이기

```
sudo vim /etc/경로~
```

- 실행 안되면 아래 2개 중 하나로 설치

```
sudo apt-get install vim
yum install vim
```

- 홈(노멀모드)에서 텍스트 `편집모드`는 `i`(insert), 편집 끝내기(돌아가기는 다 esc)는 `esc`
- 홈(노멀모드)에서 `검색모드`는 `/`
  - 검색하고 싶은 문자열 입력 후 `엔터`
  - `N`은 찾은 문자열 이후에 다음 같은 문자열, 순서대로 찾을 수 있음. 반대 방향은 `SHIFT + N`
  - 정규표현식 가능. / 뒤에 `\v` (백슬러시와 소문자v)
    - ex) CP949 또는 EUC-KR을 한번에 검색
    ```
    /\v(CP949|EUC-KR)
    ```
- 저장 및 나가기

  - 홈(노멀모드)에서 나가기`esc` 한 다음에 `:wq`
    - w : write
    - q : quit

- 복사 & 붙여넣기

  - 노멀모드에서 복사하고 싶은 위치까지 이동 후 `v` 하면 visual 모드로 변환. 커서 움직여서 복사할 범위 설정
  - 복사하기 `y`, cf) 양크는 vim에 있는 클립보드임. 양크(yank : 끌어당기다) 의 y
  - 붙여넣기 `shift + p`, paste의미인 p
    - 붙여넣을 횟수 지정해서도 가능. `횟수 + shift + p`, ex) 10 shift + p

- 일시정지 및 다시 돌아가기

  - 작업 중 `ctrl + z`
  - 지금 실행중인 애플리케이션 일시 정지. gui 애플리케이션 창을 뒤로 감춘 거랑 비슷
  - 다시 돌아가기. `fg` (ForeGround) 의 fg.

- 작업한 것 되돌리기와 다시 되살리기

  - 되돌리기 - 노멀모드에서 `u`, 연속해서 u는 여러번 되돌리기 가능
  - 되돌리기의 되살리기는 `ctrl + r`
  - 저장하고 나서 다시 열었을 때는 이전의 작업들은 먹히지 않음. ex) 한글 파일 작업할 때 같음
  - 둘 다 횟수 지정 가능.
    - `10u`, 그리고 `9999u`은 첫 상태로 되돌아가는 것
    - `10 ctrl + r`

- 일괄 치환
  - esc 키로 일단 노멀 모드로 돌아가기. `/` 는 명령어 각 부분을 구분하는 문자로 임의의 다른 문자를 사용해도 된다.
  ```
  :%s/원문/수정문
  ```
  - `new` 문자를 `older`로 모두 치환
  ```
  :%s/new/older
  ```

# 쉘 스크립트(shell script)

- 단순한 텍스트 파일, 내부는 명령어 내부 실행 절차
- 명령어를 직접 순서대로 실행하는 대신에 셸이 실행하도록 맡기는 것
- 셸이라는 것은 bash나 zsh 같은 셸로 실행하는 스크립트의 총칭
- 셸 스크립트를 실행할 때는 단순 명령어 입력에 사용하는 셸과는 별도로 프로세스가 생겨서 그 안에 스크립트가 실행되는 것. 그래서 스크립트 안에 적힌 exit 명령어로 종료하는 건 그 스크립트 실행용으로 생성된 프로세스 쪽이다.
- 스크립트는 각 줄이 80자 이내가 되도록 정리하는 것이 일반적 매너. 너무 길면 화면 폭에 맞지 않아서 짤려서 가독성 떨어짐
- 파일 생성

```
vim practice.sh
```

- 셔뱅(shebang) 또는 Hash-Bang 이라고도 함
  - 쉘 스크립트 첫 줄에 작성
  - 셔뱅이란 스크립트를 실행하는 프로그램(인터프리터)를 지정하는 것.
  - 뒤에 프로그램 전체 경로를 적으면 스크립트를 실행하는 프로그램을 셸이 자동으로 전환해준다.
  - `/bin/bash`는 bash 자체의 전체 경로. 즉 bash용 스크립트. 다른 종류들도 많음. ex) bash, zsh, perl, python, ruby, node 등

```
#!/bin/bash
```

- 셔뱅 작성 이후에 한줄씩 실행하고 싶은 명령어 한 줄로 작성하면 된다.
- 다 작성했으면 실행권한 줘야 한다. 새로 만든 셸 스크립트는 아직 실행권한이 없으니까 chmod로 명령어 권한을 줘야 함.

```
chmod +x practice.sh
```

- 실행

  - 아래처럼 바로 실행하면 안된다. 파일명만을 쳐서 명령어 실행이 가능한 건 파일이 /bin/이나 /usr/bin/ 같은 특별한 장소에 있을 떄뿐이다.

  ```
  practice.sh
  ```

  - 그래서 아래와 같은 예시들로 경로를 지정해줘야 한다.

  ```
  /home/highjune/practice.sh
  (또는)
  ./practice.sh
  (또는)
  ~highjune/practice.sh
  ```

- 쉘 스크립트 실행시 그 뒤의 처리에 영향이 가는 명령어가 있을 경우마다 삽입해야할 명령어

  - `[ ]` 안은 이전 명령어가 정상 종료했는지 확인하는 법

  ```
  if [ #? != 0 ]; then exit; fi
  ```

- 변수 설정 및 사용

  - 셸 기능의 하나. 그래서 셸 스크립트 안에서도 사용 가능
  - 한번 정의해두면 몇 번이고 반복해서 사용(참조)할 수 있으니 편함
  - 셀 스크립트 안에서 위쪽에 모아두는 건 가독성상 추천
  - 셸 스크립트 안에서 뿐 아니라 셸 밖인 그냥 터미널에서도 사용가능
  - 변수 지정. `=`
    - `=` 기준으로 `변수명(변수의이름)=값(변수의 값)`. 즉, 왼쪽이 변수명, 오른쪽이 변수의 값
    ```
    log=/var/log/apache2/access.log
    less $log
    ```
  - 변수 사용. `$`
    - `$변수명` 또는 `${변수명}` 이라고 쓰면 거기에 변숫값을 직접 적은 것과 같은 결과가 된다.
    ```
    less #log
    ```
  - 변수명에 숫자도 가능

  ```
  log1=/var/log/apache2/access.log
  ```

  - 변수명에는 _언더스코어를 사용많이 함

  ```
  JAVA_HOME=/usr/bin
  JAVA_VERSION="1.8"
  ```

  - 문자열을 eval 명령어에 넘기면 명령어열로 실행 가능

  ```
  tar_extract="tar xfv"
  tar_compress="tar cfv"

  eval "$tar_extract file.tar.gz"
  eval "$tar_compress directory"
  ```

  - 변수명 쪽이 값보다 길어지는 경우는 흔함
    - ex) 일수나 횟수가 중요한 스크립트일 경우

  ```
  days=30
  max_files=5
  ```

  - 변수에 변수가 들어가는 경우
    - ex) 같은 디렉토리에 있는 여러 파일을 다룬다면 공통인 경로 부분을 변수로 지정하는 방법도 자주 사용한다. ${변수명}을 쓰면 변수와 나머지 부분을 구별하기 쉽다
    ```
    base=/var/log/apache2
    latest=${base}/access.log
    prev=${base}/access.log.7.gz
    ```

- 환경변수

  - 작업하는 서버에 따라 관리용 사용자 이름이 달라서 실행할 내용이 다른 경우 등
  - 쉘 스크립트로 만들어도 서버가 바뀌면 재사용할 수 없는 경우
  - `환경변수는 자기가 정의하지 않아도 $변수명으로 값을 참조할 수 있는 특수한 변수`
  - 환경변수를 사용하면 셸 스크립트 실행 시 값이 변하므로 환경에 맞는 처리가 가능해진다.

  ```
  $HOME

  또는

  {HOME}
  ```

  - ex) `HOME`은 홈 디렉터리 경로라는 의미의 환경변수
    - 어떤 사용자로 로그인 하든간에 그 사용자의 홈 디렉터리 경로가 된다.
    ```
    user로 로그인
      #HOME -> /home/user
    tucker로 로그인
      #HOME -> /home/tucker
    highjune로 로그인
      #HOME -> /home/highjune
    ```
  - 아래와 같은 쉘 스크립트가 있을 경우

  ```
  #!/bin/bash
  mkdir #{HOME}/result
  ```

  위처럼 작성해두면 로그인한 user에 따라 다르게 적용가능

  ```
  #!/bin/bash
  mkdir /home/user/result

  #!/bin/bash
  mkdir /home/tucker/result

  #!/bin/bash
  mkdir /home/highjune/result
  ```

  - 이렇게 환경 변숫값은 스크립트를 실행할 때의 환경에 맞게 변하니까 이런 작업들이 가능한 것
  - 지금 환경에서 어떤 환경 변수를 쓸 수 있는지는 `env` 명령어를 실행해서 목록을 볼 수 있다. 대부분은 프로그램에서 사용하기 위한 정보이다.

  ```
  env
  ```

  - 파일명 역시 `명령어 치환`으로 쉽게 가능하다

    - 셸이나 셸 스크립트에서 아래처럼 적으면 그 부분이 명령어열 실행 결과(표준 출력)의 문자열로 치환된다.

    ```
    ${명령어열} 또는 `명령어열` , 그런데 보통 {명령어열} 처럼 사용한다.
    ```

    - 명령어 치환을 조합해서 그 날의 날짜를 파일명에 포함시키는 경우

    ```
    mv result.txt result-#(data +%Y-%m-%d).txt
    ```

    - 명령어 치환은 겹칠 수 있다.

      - 파일이나 디렉터리 경로를 넘기면 부모 디렉터리 경로를 돌려주는 dirname이라는 명령어가 있다

      ```
      dirname /data/2013-01-01/files/file.txt -> /data/2013-01-01/files
      dirname /data/2013-01-01/files -> /data/2013-01-01
      ```

      명령어 치환 겹치게 해서 아래처럼 사용할 수 있다.

      ```
      path=/data/2013-01-01/files/file.txt
      parent=${dirname $path}
      grandparent=$(dirname $parent) -> /data/2013-01-01

      위의 grandparent를 아래처럼 변경가능

      grandparent=${dirname $(dirname $path)}
      ```

    - 명령어 치환에서 파이프라인이나 변수 등도 사용 가능

## 조건분기(if문)
- 단순 조건 분기
  - 주의) then은 줄바꿈 다음에 써야함
  - 주의) if[$a="문자열"] 이렇게 붙여서 쓰면 안된다. `[`도 명령어임. /usr/bin/[ 에서 확인가능. $a = "문자열" ] 은 각각 다 인수이므로 명령어와 인수니까 사이를 띄워써야 함. 그런데 줄바꿈 대신에 ;(세미콜론)을 사용하면 여러 줄을 한번에 합칠 수 있다. ex) `if [ $? != 0 ]; then exit; fi` 주의) then 뒤에는 ;쓰지 않는다.
```
if [ $a = "문자열" ]
then
  $a 내용이
  "문자열"과 같다면
  실행하는 처리
fi
```
- 부정 조건으로 조건 분기
```
if [ $a != "문자열" ]
then
  $a 내용이
  "문자열"과 다르면
  실행하는 처리
fi
```
- 조건에 해당하지 않을 때 처리
```
if [ 조건 ]
then
  조건을 만족하면
  실행하는 처리
else
  조건을 만족하지 않으면
  실행하는 처리
fi
```
- `$#` 스크립트에 지정한 인수 개수를 의미하는 특수한 변수
  - script.sh first_param second_param
    - 변수가 총 2개(first_param, second_param)
    - `#$ = 2`
  - script.sh first_param second_param third_param
    - 변수가 총 3개((first_param, second_param, third_param)
    - `#$ = 3`
  - ex) 변수가 2개 들어오면 "Hello!" 출력
  ```
  if [ $# = 2 ]
  then
    echo "Hello!"
  fi
  ```

## 명령어 이상 종료에 대응하고 싶을 때(종료)
- 에러가 발생했을 때 멈추거나 하고 싶은 경우.
- `$?` 은 바로 직전에 실행한 명령어 종료 상태
  - 명령어가 실행한 다음에 명령어가 정샂억으로 종료했는지 알려주는 값을 $?라는 이름의 변수로 참조 가능
  - ex) (실행성공) 아래처럼 명령어를 실행하면 0이 나온다.
  ```
  cp ./test.txt /tmp/
  echo $?
  ```
  - 0은 실행 성공(여기서는 복사)을 의미한다. 
  - ex) (실행실패) 아래처럼 명령어를 실행하면 1이 나온다.
  ```
  cp ./missing /tmp/
  (./missing`를 설명할 수 없음. 그런 파일이나~~...대충 복사실행이 에러났다는 메시지)
  echo $?
  ```
  - 실행 실패의 종료 값은 0이 아니다. 1은 복사 실패를 의미한다.
  - 정상 종료는 0이고 그 외에는(이상 종료는) 0이 아닌 값이(1~255)라는 건 모든 명령어에서 공통 규칙. 즉 종료는 무조건 0~255 상태값 안에 다 존재. ex) apt명령어의 종료값은 100, 200 ls명령어의 종료값은 1, 2 이런 식.
- exit할 때 인수를 숫자로 지정하면, 즉 exit 0 또는 exit 1 이라고 적으면 그게 shell script 자체의 `종료 상태`가 된다.
  - ex) exit 100 이라고 하면 스크립트를 종료하면서 100을 리턴한다
  - exit만 적으면 exit 0 과 같다
  - 0 이외라면 무엇을 지정해도 된다.(특별히 에러 종류를 구별할 필요가 없으면 1을 지정하는 것이 보통이다)
  - 다른 스크립트에서 실행할 때 일반 명령어 종료 상태처럼 사용할 수 있다.
  - ex)
  ```
  #!/bin/bash

  if [ $1 = "" ]
  then
    echo "에러임, 처리할 파일을 지정해야 된다"
    exit 1
  fi
  ```
- ex) 파일을 복사 가능할 때만 실행하고 싶은 처리를 할 때. (즉, 에러에서 복귀. 에러나더라도 shell script 즉시 종료 말고)
```
#!/bin/bash

(..중략..)

cp $source_access $temp_file
if [ $? = 0 ]
then
  (복사 가능할 때 실행하고 싶은 처리)
else
  echo "파일이 존재하지 않음. 생략함"
fi
```

## for 반복문
- 같은 처리를 조금씩 인수(처리 대상 파일명 등) 를 바꿔가면서 반복 실행하는 구문
- 상황) 아래와 같은 명령어를 4번 실행, 수백개일 수도 있음
  - 접속 로그 월별 리포트를 한번에 정리
  ```
  ./create-report.sh redmine.log
  ./create-report.sh kintai.log
  ./create-report.sh download.log
  ./create-report.sh notice.log
  ```
- 위처럼 4번 실행하지 않고 for문을 담은 shell script 만들기(create_reports.sh)
  ```
  #!/bin/bash

  for filename in redmine.lon kintai.log download.log notice.log
  do 
    ./create-report.sh filename
  done
  ```
  - redmine.lon kintai.log download.log notice.log 라는 4개의 값을 filename이라는 하나의 변수명으로 순서대로 참조하는 것. 
  - do에서 done 사이에 적힌 내용은 리스트 값 각각에 대해 반복해서 실행
  - for ~ in 열은 아래같이 줄바꿈을 넣으면 안된다. 
  - ex1) vim practice.sh 만들어서 ./practice.sh 로 실행
  ```
  for filename in redmine.lon 
                  kintai.log 
                  download.log 
                  notice.log
  do 
    ./create-report.sh filename
  done
  ```
  - ex2) vim practice.sh 만들어서 ./practice.sh 로 실행
  ```
  #!/bin/bash

  for param in june mom fafa bro
  do 
    echo "hi" + $param
  done
  ```
  - 줄바꿈 하려면 앞에 `\`(백슬래쉬)를 넣어서 이스케이프해야 한다.
  ```
  for filename in redmine.lon \
                  kintai.log  \
                  download.log \
                  notice.log
  do 
    ./create-report.sh filename
  done
  ```
  - 또는 변수로 만들어서 좀 더 가독성을 높일 수 있다.
  ```
  file="redmine.lon kintai.log download.log notice.log"
  for filename in $files
  ```
- for 문 안에서 명령어 치환을 사용할 수 있다.
  - 상황) /var/log/apache2/ 위치에 있는 확장자가 .log인 파일들을 다 실행. 그런데 그 중에서 error.log는 제외
  ```
  for filename in `cd /var/log; ls *.log | grep -v error.log
  do
    ./create-report.sh $filename
  done
  ```
- for문은 셸 스크립트가 아니더라도 사용할 수 있다. 줄바꿈 대신에 ;(세미콜론)을 쓰면 한 줄로 만들어서 일반 명령어처럼 실행가능하다. 주의) do뒤에는 ;가 없다
```
for file in data log scripts; do echo $file; done
```
## 셸 함수(shell function)
- 셸 스크립트 안에서 스크립트 일부에 이름을 붙여서 함수로 만들 수 있게 한 것
- 사실 grep같은 명령어 안에는 많은 함수가 내장되어 있다(파일열기, 문자열 비교하기 등)
- 함수 정의
```
#!/bin/bash

hello() {
  echo "안녕하세요"
  echo "저는 june입니다"
  echo "반갑습니다"
}
```
- 함수 실행
   - 그냥 shell 안에서 함수 이름 호출만 하면 된다. (아래선 총 3번 실행). 당연히 스크립트 자체를 ./practice.sh 로 실행은 따로 해야 함
  ```
  #!/bin/bash

  hello() {
    echo "안녕하세요"
    echo "저는 june입니다"
    echo "반갑습니다"
  }

  hello
  hello
  hello
  ```
- 함수를 호출할 때 일반 명령어나 셸 스크립트처럼 인수를 지정하면 함수 안에서 $1, $2 .. 라는 변수로 인수 값을 참조할 수 있다. (주의 : 셸 스크립트 인수를 참조하는 것이지 함수 인수를 참조하는 것이 아니다)
```
#!/bin/bash

  hello() {
    echo "안녕하세요"
    echo "저는 $1 입니다"
    echo "반갑습니다"
  }

  hello june1
  hello june2
  hello june3
```
- 그래서 함수의 공통 부분, 다른 부분들을 인수로 컨트롤 할 수 있다. 다른 부분들이 2개 이상인 경우.
  - 참고) 다른 부분들이 1개면 for문으로 가능하지만 그 이상일 경우 함수로 해결 가능
  - 원래 코드
  ```
  source=marketing.log
  report=mail-${date +%Y-%m-%d}.csv
  ourdir=/shared/marketing/reports
  ./analyze_mail_log.sh $source $report
  mkdir -p $outdir
  mv /tmp/${report} ${outdir}/
  echo "$source 처리 완료"

  source=system.log
  report=a${date +%Y-%m-%d}.csv
  ourdir=/shared/system/mail-reports
  ./analyze_mail_log.sh $source $report
  mkdir -p $outdir
  mv /tmp/${report} ${outdir}/
  echo "$source 처리 완료"

  source=develop.log
  report=mail-${date +%Y-%m-%d}.txt
  ourdir=/shared/develop/reports/mail
  ./analyze_mail_log.sh $source $report
  mkdir -p $outdir
  mv /tmp/${report} ${outdir}/
  echo "$source 처리 완료"
  ```

  - 수정 코드
  ```
  #!/bin/bash

  report() {
    source=$1
    report=$2
    outdir=$3
    ./analyze_mail_log.sh $source $report
    mkdir -p $ourdir
    mv /tmp/${report} ${outdir}/
    echo "$source 처리 완료"
  }

  report marketing.log mail-${date +%Y-%m-%d}.csv /shared/marketing/reports
  report system.log ${date +%Y-%m-%d}.csv /shared/system/mail-reports
  report develop.log ${date +%Y-%m-%d}.txt /shared/develop/reports/mail
  ```
- 스크립트와 함수는 종료 상태도 비슷
  - $? 로 확인시 이전 명령어가 정상종료면 0, 아니면 0이외의 숫자
  - 다만 함수 종료 상태는 `return`이다. (`exit`아님)
  - 함수 종료. return.  함수 실행을 중단하고 종료 상태를 1로 지정
  ```
  #!/bin/bash

  report() {
    if [ #1 = "" ]
    then
      echo "인수가 필요함"
      return 1
    fi
  }
  ```
  - 스크립트 종료. exit. 스크립트 실행을 중단하고 종료 상태를 1로 지정. exit는 함수뿐만 아니라 스크립트 자체 처리까지 도중에 중단함. 
  ```
  #!/bin/bash

  if [ #1 = "" ]
  then
    echo "인수가 필요함"
    exit 1
  fi
  ```

- 함수는 명령어 치환도 사용가능
  - 수정 전 코드
  ```
  report marketing.log mail-$(date +%Y-%m-%d).csv /shared/..(중략)
  report system.log $(date +%Y-%m-%d).csv /shared/..(중략)
  report develop.log $(date +%Y-%m-%d).txt /shared/..(중략)
  ```
  - 수정 후 코드
    - 함수(today함수) 실행 결과는 명령어 실행 결과의 문자열이 된다.
  ```
  today() {
    date +%Y-%m-%d
  }

  report marketing.log mail-$(today).csv /shared/..(중략)
  report system.log $(today).csv /shared/..(중략)
  report develop.log $(today).txt /shared/..(중략)
  ```

- 셸 스크립트는 기본적으로 실행하고 싶은 명령어를 실행 순서대로 작성하지만, 함수를 사용한다면 실행 순서를 신경쓰지 않고 중요한 부분부터 스크립트 작성함. 그래서 스크립트 작성하는 자유도가 높아진다.
  - 상황) 처리 대상 하는 파일명이 셸 스크립트의 제일 마지막 부분에 가서야 볼 수 있어서 혼란스러움
  - 수정 전 코드
  ```
  #!/bin/bash

  report() {
    source=$1
    report=$2
    outdir=$3
    ./analyze_mail_log.sh $source $report
    mkdir -p $ourdir
    mv /tmp/${report} ${outdir}/
    echo "$source 처리 완료"
  }

  today() {
    date +%Y-%m-%d
  }

  report marketing.log mail-$(today).csv /shared/..(중략)
  report system.log $(today).csv /shared/..(중략)
  report develop.log $(today).txt /shared/..(중략)
  ```
  - 수정 후 코드
    - 중요한 처리를 main함수로 미리 정의해두고 마지막에 그걸 호출하는 게 보통 (중요한 처리 내용을 최초에 정의해둠. 이 시점에서는 아직 실행되지 않으므로 다른 함수는 아직 정의되지 않아도 괜찮음)
    - 중요한 부분 이외를 main 함수 뒤에 정의
    - 마지막에 main 함수를 한 번만 노출
    ```
    main() {
      report marketing.log mail-$(today).csv /shared/..(중략)
      report system.log $(today).csv /shared/..(중략)
      report develop.log $(today).txt /shared/..(중략)
    }
    report() {
      source=$1
      report=$2
      outdir=$3
      ./analyze_mail_log.sh $source $report
      mkdir -p $ourdir
      mv /tmp/${report} ${outdir}/
      echo "$source 처리 완료"
    }

    today() {
      date +%Y-%m-%d
    }

    main
    ```
- 셸 스크립트의 인수와 함수의 인수
  - copy_files.sh
  ```
  #!/bin/bash

  do_copy() {
    cp /tmp/source $1
    ..(중략)...
  }
  ...
  do_copy
  ...
  ```
  - 실행 시 명령어열
  ```
  ./copy_files.sh /tmp/target
  ```
  - 위와 같이 하면 에러난다.
  - 이유) 함수 안에서 $1 이라고 하면 셸 스크립트의 인수가 아니라 함수의 인수를 참조한다. 함수 안과 밖에서 #1 의미가 다르다는 것
  - 셸 스크립트 자체의 인수를 함수 안에서 참조하려면 함수 밖에서 일단 다른 이름의 변수로 정의해둬야 한다. 아래와 같이 사용
  ```
  #!/bin/bash

  target=$1

  do_copy() {
    cp /tmp/source #target
    ..(중략)...
  }
  ...
  do_copy
  ...
  ```

## 쉘 스크립트(shell script) 안에서 명령어 라인 사용

- 상황) 처리하고 싶은 파일명만이 다를 뿐인데 별도의 스크립트 수가 많이 늘어날 경우
- `category1.sh`
```
#!/bin/bash
directory=/tmp
source="${directory}/items_category1.csv"
result="${directory}/items_category1_sorted.csv"
..(중략)..
```

- `category2.sh`

```
#!/bin/bash
directory=/tmp
source="${directory}/items_category2.csv"
result="${directory}/items_category2_sorted.csv"
..(중략)..
```

- 위의 두 파일의 차이는 1<->2 만 다를 뿐. 처리 대상 파일명(source)과 출력 파일명(result)만 다름.
- 이럴 경우 명령어 라인 인수 사용하면 된다.
- 명령어에 대해 추가 지시를 내리는 게 명령어 라인 인수, 줄여서 인수.
- 일반적으로 특정 명령어의 옵션으로 사용하는 `-c`, `-r` 등, 옵션은 실제로 인수의 한 종류.
  - 옵션?
    - `-r`같이 "생략 가능한(지정하면 행동이 변하는) 인수"를 옵션 인수, 줄여서 옵션이라고 함.
    - option은 선택 가능하다는 것
    - ex) original을 copied위치에 디렉터리 내용도 포함해서 복사
    ```
    cp /tmp/original /tmp/copied
    ```
    - ex) original을 copied위치에 복사
    ```
    cp -r /tmp/original /tmp/copied
    ```
    - 위의 2가지 명령에서 `-r`은 `옵션 인수` 이고 나머지들, `/tmp/original`, `/tmp/copied` 는 `일반인수`이다.
- 그래서 위 2가지 파일(`category1.sh`, `category2.sh`) 중에서 하나의 파일을 아래와 같이 수정.

```
#!/bin/bash
directory=/tmp
source="${directory}/$1"
result="${directory}/$2"
..(중략)..
```

- 그리고 파일 이름을 범용적인 이름으로 수정.

```
mv category1.sh category.sh
```

- 아래와 같이 실행. 즉, 이전에는 파일 안에 직접 적었던 처리 대상 파일명과 출력 파일명을 스크립트 이름 뒤에 지정해서 실행

```
./category.sh items_category1.csv items_category1_sorted.csv
```

```
./category.sh items_category2.csv items_category2_sorted.csv
```

- 쉘 스크립트 내부에서는 지금처럼 실행 시 지정한 인수 값을 $1, $2, $3 와 같은 변수로 참조할 수 있다. 각각 first, second, third 지칭. 이런식으로 처리하고 싶은 파일 이름을 스크립트에 직접 적지 않아도 실행할 때 지정할 수 있다.

```
./script.sh first second third
```

- 인수가 여러 개 있어서 헷갈릴 경우, 인수를 이름으로 참조하기, 몇 번째가 뭐였는지 헷갈림

  - 상황, 인수 순서대로(기준일 로그, 다음날 로그, 전날 로그, 출력 파일0)

  ```
  ./accesses.sh /var/log/apache2/access.log.2.gz
                  /var/log/apache2/access.log.1.gz
                    /var/log/apache2/access.log.3.gz
                      /tmp/day2-reuslt.txt
  ```

  - 아래와 같이 수정. `b->base(기준일)`, `n->next(다음날)`, `p->previous(전날)`, `o->output(출력)`

  ```
  ./accesses.sh -b /var/log/apache2/access.log.2.gz
                  -n /var/log/apache2/access.log.1.gz
                    -p /var/log/apache2/access.log.3.gz
                      -o /tmp/day2-reuslt.txt
  ```

  - 스크립트 변경

  ```
  #!/bin/bash

  while getopts b:n:p:o: OPT
  do
    case #OPT in
      b) base="$OPTARG" ;;
      n) next="$OPTARG" ;;
      p) previous="$OPTARG" ;;
      o) output="$OPTARG" ;;
  ```

- 쉘 스크립트(shell script)에서 인수를 사용하는 방법
  1. 지정한 순서대로 값을 참조함
  ```
  # script.sh filename1 filename2
  ```
  ```
  #!/bin/bash
  source=$1
  target=$2
  ...
  ```
  2. 옵션 이름으로 값을 참조함
  ```
  # script.sh -s filename1 -t filename2
  ```
  ```
  #!/bin/bash
  while getopts s:t: OPT
  do
    case OPT in
      s) source="#OPTARG" ;;
      t) target="#OPTARG" ;;
    esac
  done
  ```

# 가상단말(tmux)

- 접속이 끊기기 쉬운 WiFi나 테더링 경유로 SSH 접속할 때 좋음
- 서버에서 tmux로 여러 화면을 사용한다면 SSH 접속은 처음 한번만 하면 됨. 인증도 한 번만 하면 되고 재접속도 한 번으로 끝. tmux attach 로 접속이 끊기기 전 상태로 바로 복귀도 가능
- 접속

```
tmux
```

- 명령어 찾지 못했다고 나오면

```
sudo apt-get install tmux
```

- 접속이 끊겼을 시

```
tmux attach
```

- tmux 기능은 먼저 `ctrl + B` 를 먼저 입력 후 아래 명령어 입력. 이런 키를 prefix key

  - `D` detach
  - `C` create
  - `P` previous
  - `N` Next
  - `R` 되살리기
  - `C` 프로세스 종료
  - `Z` 프로세스 일시 정지

- 여러 창 옮겨다니기

  - 새로운 창을 `ctrl + B` + `C` 로 만든 후
  - `ctrl + B` + `N` 또는 `P`

- 화면 분할
  - 가로 분할
  ```
  ctrl + B 후 "
  ```
  - 세로 분할
  ```
  ctrl + B 후 %
  ```
  - 분할된 화면에서 화면 전환.
  ```
  ctrl + B 후 ↑↓ 또는 → ←
  ```
  - 스크롤 하기. 화면을 벗어난 내용확인이 끝났으면 `Q`키로 원래 상태로 돌아오면 된다.
  ```
  ctrl + B 후 [ 누르면 커서를 화살표나 마우스 휠로 스크롤 가능
  ```
  - 화면 분할 종료
  ```
  exit
  ```
  - 분할된 화면 크기 변경하기
  ```
  ctrl + B 후 ctrl를 누르면서 ↑↓ → ←
  ```
