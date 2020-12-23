
[개인적으로 정리한 Git 명령어 - 노션페이지](https://www.notion.so/Git-577eee091a5c4617aa9a9a1b5fd7e11a)
 
[깃 소프트웨어 다운로드](https://git-scm.com/downloads)
- 윈도우 버전 다운로드 및 설치
- 그러면 명령 프롬프트에서도 git 명령어를 사용할 수 있다.


## 코드 정리
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
        - master의 파일내용과 develop(다른 branch)의  파일내용이 다를 경우 merge하면 충돌이 발생한다. 각각 checkout으로 이동하여 git log를 보면 자신의 내역밖에 보이지 않는다. 그럴 경우 그 파일을 들어가보면(내용) 두 가지 버전으로 서로 다른 부분에 대해서 표시가 되어 있다. 그 둘 중 선택하고자 하는 것으로 하나를 선택한 후에.
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
        - 



## 참고 자료

 
### 참고할만한 github 관련 링크 
[readme.md 독특하게 꾸미는 10가지 방법](https://dev.to/github/10-standout-github-profile-readmes-h2o)

[우아한 형제들 - 기술 블로그](https://woowabros.github.io/experience/2017/10/30/baemin-mobile-git-branch-strategy.html)

[git-flow cheatsheet](https://danielkummer.github.io/git-flow-cheatsheet/index.ko_KR.html)
[간편 안내서](https://rogerdudler.github.io/git-guide/index.ko.html)
