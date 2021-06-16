[개인적으로 정리한 Git 명령어 - 노션페이지](https://www.notion.so/Git-577eee091a5c4617aa9a9a1b5fd7e11a)

[깃 소프트웨어 다운로드](https://git-scm.com/downloads)

- 윈도우 버전 다운로드 및 설치
- 그러면 명령 프롬프트에서도 git 명령어를 사용할 수 있다.

## 명령어 정리

- 깃 시작
  - 해당 폴더 우클릭 - git bash로 실행해서 명령창 open
  - 시작(아래 명령어 실행시 .git 숨김 폴더 생성)
  ```
  git init
  ```
  - 명령 프롬프트(cmd 창)에서 해당 프로젝트로 이동한 후에 시작해도 된다.
- 원격저장소 설정

  - 한번 설정하면 안해도 된다
  - 원격저장소 추가
    - origin 말고 특정한 이름 설정 해도 된다
    - ex)
    ```
    git remote add june 주소
    ```
    - origin 으로 설정했을 경우
    ```
    git remote add origin repository주소
    ```
  - 설정한 원격저장소 주소 확인. 일반적으로 원격저장소는 origin 이라는 이름을 가진다.

  ```
  git remote -v
  ```

  - 원격저장소 이름 변경
    - origin -> june으로 변경
    ```
    git remote rename origin june
    ```
  - 특정한 원격저장소에 대해서 log, merge 등 수행할 수 있다.

  ```
  git log origin/master
  git merge origin/master
  ```

  - 원격저장소 삭제(test 원격저장소 삭제)

  ```
  git remote rm test
  ```

- 기본 설정

  - `--global` 제외하면 해당하는 repository만 설정하는 것임
  - 프로젝트마다 다르게 설정하고 싶으면 --global 빼도 된다

  ```
  git config --global user.name 아이디

  git config --global user.email 이메일
  ```

- 환경설정 파일 확인(.gitconfig)

  - cd~ 로 상위 폴더로 가서 ls -al 로 모든 파일 확인해보면 .gitconfig 파일 존재하는 것을 볼 수 있다. cat .gitconfig 보면 설정한 것들 확인가능

  ```
  cd ~
  ls -al
  cat .gitconfig
  ```

- pull 종류

  - git fetch 와 git merge를 순차적으로 해야 하는데 이것이 합쳐진 것이 git pull
  - pull은 항상 push보다 먼저 해야 된다
  - pull을 통해 최신것을 다운로드 하지 않은 상태에서 작업할 경우, 다른 사람들이 작업한 내역에 git명령어를 쓰게 되면 그 위에 덮어쓰게 된다. 하나의 파일을 같이 수정할 경우에는 반드시 git pull origin master로 반드시 다 당겨오고 나서 작업해야 된다.

  ```
  git pull origin master
  ```

  - 만약 위와 같은 작업을 하지 않은 상태에서 push를 하게 되면 에러가 생기는데, 그것을 해결하는 방법

  ```
  git push origin 브런치명 --allow-unrelated-histories

  (또는 아래처럼 '+' 붙여서)

  git push origin +브런치명
  ```

  - 위 명령 옵션은 이미 존재하는 두 프로젝트의 기록(history)을 저장하는 드문 상황에 사용된다고 한다. 즉, git에서는 서로 관련 기록이 없는 이질적인 두 프로젝트를 병합할 때 기본적으로 거부하는데, 이것을 허용해 주는 것이다.

- push 종류

  - 현재 나의 로컬폴더와 깃허브간의 싱크상태 확인해주는 것

  ```
  git status
  ```

  - 변경된 파일들을 모두 tracking(staging area에 올림) => 프로젝트 기준으로 수정된 것들 다 올림.
    - add뒤에 한 칸 띄우기
    - git status로 확인 가능

  ```
  git add .
  git add *
  (둘 다 같음)
  ```

  - 특정 파일만 staging area에 올리고 싶으면

    - git status로 확인 가능

    ```
    git add 파일명.확장자
    ```

    ```
    git add document.txt
    ```

  - staging area 에 올린 파일을 다시 내리고 싶으면(이후에 다시 git status 해보면 내려온 것 확인 가능하다)

    ```
    git reset 파일명.확장자
    ```

    ```
    git rest document.txt
    ```

    - 그리고 수정한 상태에서, 그 수정한 것을 되돌리고 싶을 때

    ```
    git restore -- 파일명.확장자
    ```

  - commit 메시지 추가(인식, 메모할 수 있도록)
    - (현재 상태는)local 저장소에만 인식되어 있는 상태, remote 저장소에는 아직 업로드 되지 않은 상태.

  ```
  git commit -m "message"
  ```

  - 커밋 메시지 수정(에디터 들어가서)
    - 아래 명령어로 에디터 들어가기
    ```
    git commit --amend
    ```
    - 에디터로 들어가자마자 a(끼워넣기)또는 i 누르면 글 수정 가능
    - 다 입력 후 esc -> :wq 누른 후 엔터로 나가기
      - `w` 저장
      - `q` 종료
      - `wq` 저장+종료
    - 만약 에디터로 들어가지 않고 수정하려면
    ```
    git commit --amend -m "new commit message"
    ```
  - push(remote repository에)

  ```
  git push origin master
  ```

- branch

  - 현재 생성되어 있는 브런치들 확인 명령어
    - default로 master만 생성되어 있다.
    ```
    git branch
    ```
  - 새 브런치 생성
    - 만약 develop 브런치 생성
    - 주의) 만약 현재 repository 가 단 한번도 commit하지 않은 상황이면 에러가 발생한다.
    ```
    git branch develop
    ```
  - 다른 브런치로 커서 이동

    - 현재 master branch에 커서가 있는 상태

    ```
    git checkout develop

    (develop branch에서 작업후... 커밋까지)
    ```

  - 다른 브런치에서 작업했던 것을 배포가능, 배포중인 master브런치와 병합(병합의 주체는 master)

    - 다시 커서를 master로 이동 후에 변경한 branch(develop) 와 병합

    ```
    git checkout master   (--> master로 커서 이동)
    git merge develop

    git push origin master (--> remote repo에도 반영)

    ```

    - 병합하고 난 후 쓸모없는 branch 제거

    ```
    git branch -d develop
    ```

  - branch 충돌날 경우
    - master의 파일내용과 develop(다른 branch)의 파일내용이 다를 경우 merge하면 충돌이 발생한다. 각각 checkout으로 이동하여 git log를 보면 자신의 내역밖에 보이지 않는다. 그럴 경우 그 파일을 들어가보면(내용) 두 가지 버전으로 서로 다른 부분에 대해서 표시가 되어 있다. 그 둘 중 선택하고자 하는 것으로 하나를 선택한 후에.
    ```
    git add .(=git add *)
    git commit -m "메시지"
    ```
    - 위와 같은 과정을 하면 merge가 된다. (git merge develop 으로 다시 merge하면 이미 병합되어 있다고 메시지 확인가능)

- 로그 확인
  - 사실 github에서 직접 ui로 log들을 확인하면 되므로 필요성이 높지는 않다.
  - 로그 확인
    ```
    git log
    ```
    - 엔터 누르면서 목록 확인가능함(편집모드)
    - q를 눌러서 나가면 된다
  - log에 대한 통계정보
    ```
    git log --stat
    ```
    - 얼마나 많은 라인을 추가했는지 확인가능하다
    - branch와 병합정보를 graph로 정리된 것을 확인
      - `-p` 커밋에 적용된 구체적인 항목들 출력
      - pretty - 커밋정보를 우리가 지정한 형식으로 출력할 수 있도록 가능케 해준다.
        - `%h` 해시값
        - `%an` - author name
        - `%ar` - 날짜
        - `%s` - 커밋주제
      ```
      git log -p -3  (위에서부터 3개까지 확인가능, 어떻게 커밋이 이루어졌는지도)
      git log --pretty=oneline (각각의 커밋내용들이 한줄로 축약된 형태로 표시됨)
      git log --pretty=format:"%h -> %an, %ar : %s" --graph
      ```
- 기타명령어

  - 다운받아서 복사할 때, 명령창에서 하면 저장소의 폴더 내용이 다 다운받아진다.(다운 받은 후에 수정해서 올리기 위해)

  ```
  해당하는폴더> git clone 깃주소
  ```

  - branch 상황들 정리

  ```
  git log --graph --all --decorate
  ```

  - 버전 확인

  ```
  git --version
  ```

  - 공동 프로젝트에서 다른 사람이 수정한 내역을 내 컴퓨터로 다운받고자 할 때.

  ```
  git fetch
  ```

  - 특정 commit 위치로 돌아가기(local의 상태만)
    - --hard 옵션은 특정 커밋 이후 기록 다 삭제
    - --soft 옵션은 특정 커밋 이후 기록 보존
    - git log로 확인한 hash 값
    - 그래서 lcoal repo 확인해보면 특정 커밋 이후에 만들었던 파일 다 사라져있다

  ```
  git reset --hard 989dd3c3591fab797e07c3c674a8c18dcff3b11b
  ```

  - local repo의 상태를 특정 commit 시점으로 변경 후에 remote repo의 상태도 동일하게 하려면, git push 하게 되면 오류가 발생(둘의 구조 자체가 달라졌기 때문에)

    - 그래서 강제로 push 를 하고자 하는 경우

    ```
    git push -f
    ```

  - 소스코드만 압축하기

    - .git폴더를 제외한 모든 소스코드 압축 파일 형태로 압축

    ```
    git archive --format=zip master -o Master.zip

    git archive --format=zip master -o ../Master.zip  (상위폴더로 압축파일 내보낼 때)

    ```

  - Git Rebase 명령어로 특정한 커밋을 수정
    - [rebase관한 좋은 글 링크](https://junwoo45.github.io/2019-10-23-rebase/)
    - i 옵션 - interactice 모드로 editor가 열린다
    - HEAD~3 - HEAD를 기준으로 최근 3개까지의 커밋만 확인
    - 특정 커밋만을 선택해서 확인할 수 있다.
    - 수정하고자 하는 커밋에 관한 것을 pick을 `reword`로 바꿔주면 됨(해당 창 아래에 여러 명령어 참고하면 된다) 바꿔주고 나서 :wq! 로 나오면 나오자마자 바로 해당 커밋메시지 수정하면 된다
    ```
    git rebase -i HEAD~3
    git rebase -i 1sidfowijlsdkfj1ljldkfjsdf (특정 커밋 - git log를 통해서 확인)
    ```
  - Git Rebase 명령으로 특정한 커밋을 삭제
    - 아래 명령어로 열어서(또는 특정 커밋 선택) pick을 drop으로 변경. 저장한 후 나와서 git log로 확인해보면 없음
    ```
    git rebase -i HEAD~3
    ```
  - 파일생성
    - touch "파일명"
    - 파일이 없는 상태에서는 용량 0인 파일이 생성되고 기존 파일에 대해 touch 하면 파일에 대한 수정 일자가 최신화
    ```
    touch "example.txt"
    ```
  - commit 날짜, 시간 변경, committer 변경 (중간의 특정 커밋을 변경하면 그 이후의 커밋들의 해시값들이 다 변경된다)

    1. rebase로 변경

    ```
    git rebase -i ebfba5375791476213c9352253e55437d0b88aa2

    (pick -> edit) 으로 변경후 :wq! 로 나오기

    GIT_COMMITTER_DATE="Feb 13 10:00:00 2020 +0000" git commit --amend --no-edit --date "Feb 13 10:00:00 2020 +0000"

    git rebase --continue

    git log (로 확인)

    ```

    2. filter 기능으로 변경

       - if문 사용가능
       - if문 다음과 [ 안의 첫 공백 끝 공백, '=' 전후의 공백등을 빠짐없이 넣어줘야 한다.

       ```
       'if [ $GIT_COMMIT = 해시값 ]
       then
           export GIT_AUTHOR_DATE="Mon Oct 1 10:00:00 2018 +0000"
           export GIT_COMMITER_DATE="Mon Oct 1 10:00:00 2018 +0000"
       fi'
       ```

       ```
       $ git filter-branch -f --env-filter '
       > OLD_EMAIL="test@test.com"
       > CORRECT_NAME="highjune"
       > CORRECT_EMAIL="highjune37@gmail.com"
       > if [ $GIT_COMMITTER_EMAIL = #OLD_EMAIL ]
       > then
       >   export GIT_COMMITTER_NAME="$CORRECT_NAME"
       >   export GIT_COMMITTER_EMAIL="$CORRECT_EMAIL"
       > fi
       > if [ $GIT_AUTHER_EMAIL = $OLD_EMAIL ]
       > then
       >   export GIT_AUTHOR_NAME="$CORRECT_NAME"
       >   export GIT_AUTHOR_EMAIL="$CORRECT_EMAIL"
       > fi'

       ```

  - rebase취소

  ```
  git rebase --abort
  ```

  - commit 메시지 템플릿 만들기([참조](https://jeong-pro.tistory.com/207))

    1. 템플릿 포맷 파일 만들기(git 명령 프롬프트에서 .git 파일 있는 폴더로 이동한 후)

    ```
    touch git-commit-template.txt
    ```

    2. 템플릿 메시지 작성

    ```
    vim git-commit-template.txt
    ```

    3. git-commit-template.txt 파일 안에 내용 작성(작성 후 저장 및 나오기)

    ```
    <타입> : <제목>

    ##### 제목은 최대 50글자까지만 입력 #####


    #본문은 위에 작성
    ######## 본문은 한 줄에 최대 72글자까지만 입력 #################

    #꼬릿말은 아래에 작성 : ex) #이슈 번호

    # ---COMMIT END ---
    #<타입> 리스트
    # feat : 기능(새로운 기능)
    # fix : 버그(버그 수정)
    # refactor : 리팩토링
    # style : 스타일(코드 형식, 세미콜론 추가:비즈니스 로직에 변경 없음)
    # docs : 문서(문서 추가, 수정, 삭제)
    # test : 테스트(테스트 코드 추가, 수정, 삭제 : 비즈니스 로직에 변경 없음)
    # chore : 기타 변경사항(빌드 스크립트 수정 등)

    # -----------------
    # 제목 첫 글자를 대문자로
    # 제목은 명령문으로
    # 제목 끝에 마침표(.) 금지
    # 제목과 본문을 한 줄 띄워 분리하기
    # 본문은 "어떻게"보다 "무엇을", "왜"를 설명한다.
    # 본문에 여러줄의 메시지를 작성할 땐 "-" 로 구분
    # -----------------
    ```

    4. config설정파일(.git 폴더 안에 있음) 에 등록. 파일 위치+파일명

    ```
    git config commit.template /c/gatsby/blog/git-commit-template.txt
    ```

    또는 --global 옵션 줘서

    ```
    git config --global commit.template /c/gatsby/blog/git-commit-template.txt
    ```

    5. 사용하면 됨.

    ```
    git commit -m "message" 대신

    git commit 만 하면 템플릿 열림
    ```

## GitLab 코드관리
- NAS서버를 별도로 설치해서 그 곳에 GitLab. 내부IP사용
- [NAS란?](https://itblogpro.tistory.com/81)
- 순서
  - GitLab에서 특정 issue를 등록한다(기존 코드가 remote에 있는 상태) ex) login_issue1
    - milestone은 이슈를 포함한 큰 개념(user로그인, 결제 등)
    - 담당자 설정 : june
    - 라벨 : 로그인
    - 기타 항목들 설정 후 이슈 등록
  - 이슈에 해당하는 branch 생성(login_issue1), master코드를 그대로 복사
  - tool(ex. intelliJ, VS코드 등)에서 remote tool에 새로운 branch(login_issue1) 생성된 것 확인하기
    ```
    git branch -r
    ```
    - 만약 안 보이면 아래 명령 후 다시  `git branch -r`로 확인
    ```
    git remote update
    ``` 
    - 현재 local에는 `login_issue1` 브런치 없는 상태임
    ```
    git branch
    ```
  - remote에 생성된 브런치 local로 당겨오기
  ```
  git checkout -t login_issue1
  ```
  - local로 들고왔는지 확인하기. 목록에 `login_issue1` 있는지 확인
  ```
  git branch
  ```
  - 이제 이 branch에서 작업하기(tool에서)
  - 커밋하고 push까지 하기
    ```
    git add .
    git commit -m "update login_issue"
    git push origin
    ```
    - `git push origin`하면 remote의 `login_issue1` branch에 적용된 것. master에는 아직 적용이 된 것이 아니다.
  - remote(GitLab) 의 master branch로 merge 하기
    - GitLab에서 드랍다운 branch 설정하는 탭에서 `login_issue1`선택.
    - `create merge requets` 버튼 떠 있음. 클릭
    - 담당자, 라벨 등 설정
    - `submit merge request` ㅡ `merge` 클릭.
    - cf) 기존 브런치 삭제한다고 체크하면 merge가 되면서 `login_issue1` branch는 사라짐
  - 만약 충돌이 나면?
    - merge버튼이 안 뜨고 경고가 뜬다. 그런 경우에는 경고 부분 해결하기.



## 참고 자료

### 참고할만한 github 관련 링크

[readme.md 독특하게 꾸미는 10가지 방법](https://dev.to/github/10-standout-github-profile-readmes-h2o)

[우아한 형제들 - 기술 블로그](https://woowabros.github.io/experience/2017/10/30/baemin-mobile-git-branch-strategy.html)

[git-flow cheatsheet](https://danielkummer.github.io/git-flow-cheatsheet/index.ko_KR.html)

[간편 안내서](https://rogerdudler.github.io/git-guide/index.ko.html)

[git remote branch 가져오기](https://cjh5414.github.io/get-git-remote-branch/)

[git-flow와 branch간 merge 충돌 해결 ](https://www.holaxprogramming.com/2018/11/01/git-commands/)

[git pull 충돌 때 merge 취소해서 충돌 해결](https://gutmate.github.io/2018/04/18/git-pull-fail/)

[git pull 충돌 때 merge 취소해서 충돌 해결2](https://wikidocs.net/17171)

[git pull 충돌 때 충돌 해결3](https://goddaehee.tistory.com/2530)

[코퀄리티 개발 컨텐츠 모음 - Git](https://github.com/Integerous/goQuality-dev-contents/tree/master/5.%20%EA%B8%B0%ED%83%80)

[git flow model - 생활코딩](https://www.youtube.com/watch?v=EzcF6RX8RrQ)

[누구나 쉽게 이해할 수 있는 Git 입문](https://backlog.com/git-tutorial/kr/intro/intro1_1.html)

### 커밋 템플릿 세팅법

[커밋 템플릿 사용법](https://jeong-pro.tistory.com/207)
