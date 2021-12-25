# [실전! 스프링 부트와 JPA 활용 1 - 웹 애플리케이션 개발](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-JPA-%ED%99%9C%EC%9A%A9-1/dashboard) 강의 듣고 정리한 강의

- [JPA 로드맵](https://www.inflearn.com/roadmaps/149) 에서 야생형 첫 번째 강의
- 생략된 부분들은 pdf 파일 꼭 보기

# 프로젝트 환경설정
## 프로젝트 생성
- build.gradle에 있는 plugins의 boot 플러그인은 라이브러리들의 디펜던시까지 다 관리해준다. 그래서 이 버전만 업그레이드 해주면 다른 라이브러리의 버전까지 동시에 업그레이드 된다. 
```
id 'org.springframework.boot' version '2.6.2' 를
id 'org.springframework.boot' version '2.6.3' 으로 변경 하면 ~
```
- 하나의 라이브러리를 들고오면 관련된 다른 라이브러리들은 알아서 다 당겨온다
```
implementation 'org.springframework.boot:spring-boot-starter-web' 라고 하면 관련된 라이브러리들을 자동으로 엄청 많이 들고온다. 용량 많음
```
## 라이브러리 살펴보기

## View 환경 설정
## H2 데이터베이스 설치3