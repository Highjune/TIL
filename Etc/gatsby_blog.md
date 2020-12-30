# 정적 블로그 만들기
- 특정한 플랫폼(네xx, 티스xx 등)에 종속되지 않은 나만의 블로그를 아주 오래전부터 갖고 싶었는데 개발자 직군에 뛰어들고 나서야 만들게 될 줄은 생각도 못했다. 
- 기술 블로그 작성하기
- 아래 메뉴얼은 `윈도우` 기준


## Gatsby 프로젝트 생성

### 0. 차례
```
1. node js 설치
2. Git 설치
3. starter 연결 및 dev-server 켜기
4. C:\gatsby\blog로 이동 후 서버 on
5. 확인
6. 깃허브에 repository 만들고 push
7. netlify 로 배포
````

### 1. node js 설치
- Gatsby 는  node.js로 만들어졌기 때문에 설치 필요
- [다운로드](https://nodejs.org/ko/)
- .msi 파일 다운 받아서 설치(기본으로 진행)
- 설치 후 명령 프롬프트(cmd) 창에서 확인
```
node --version
npm --version
```


### 2. Git 설치
- [git 다운로드](https://git-scm.com/downloads)
### gatsby-cli 설치
- gatsby 프로젝트 생성을 하기 위해서는 gatsby-cli를 설치해야 한다
```
npm install -g gatsby-cli
```

### 3. starter 연결 및 dev-server 켜기
- 프로젝트를 생성할 폴더를 먼저 만든다 `C:/gatsby`
- 해당 프로젝트(gatsby)에 이동해서 blog(임의 이름) 폴더로 github 스타터 주소 연결해서 clone하기
    - gatsby new - 명령어 게츠비 프로젝트생성을 위한 명령어
    - blog - 내컴퓨터 디렉토리명을 지정
    - https://github.com/Highjune/gatsby-starter-bee 는 내가 선택한 템플릿(해당하는 스타터) 주소를 fork해온 나의 repository 주소
```
(C:\gatsby)로 이동 후
gatsby new blog https://github.com/Highjune/gatsby-starter-bee
```

### 4. C:\gatsby\blog로 이동 후 서버 on
```
cd blog (현재 위치 C:\gatsby\blog)
gatsby develop
```

### 5. 확인
```
http://localhost:8080/  또는
http://localhost:8000/___graphql
```

### 6. 깃허브에 repository 만들고 push
- 만든 gatsby 프로젝트를 올릴 "gatsby-blog"라는 repository 생성
- C:\gatsby\blog 위치에서 아래 명령어 실행 (blog폴더 우클릭 `git bash here`)
```
$ git init
$ git add .
$ git commit -m "gatsby blog setup"
$ git remote add origin [나의 "gatsby-blog" repository url]
$ git push origin master
```

### 7. netlify 로 배포
- [접속](https://app.netlify.com/teams/highjune/sites)
- 위 링크 접속
- new site from git 클릭 → githup 클릭 
- only select repository 클릭 → 해당 repository 선택(gatsby-blog) → deploy site
- 배포 완료되면 도메인 주소를 할당해준다.



### 기타 참고 자료
- [gatsby docs](https://www.gatsbyjs.com/docs/tutorial/part-zero/)
- [gatsby 블로그 생성하기 메뉴얼](https://velog.io/@hwang-eunji/create-github-blog-feat.-gatsby)
- [gatsby + netlify 이용해서 static page 배포하기](https://appear.github.io/2019/03/10/ETC/gatsby-01/)
- [gatsby-starter-bee 스타터로 gatsby+netlify 블로깅하기](https://delivan.dev/web/start-gatsby-blog/)
- [netlify로 정적 사이트 배포하기](https://blog.outsider.ne.kr/1417)
- [hexo에서 블로그 이전하기](https://blueshw.github.io/2018/10/07/hexo_to_gatsby/)