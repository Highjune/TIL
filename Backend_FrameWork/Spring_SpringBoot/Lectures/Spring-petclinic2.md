
- 로깅을 좀 더 자세히 보고 싶으면 INFO -> DEBUG모드로, `application.properties` 파일에다가 아래 작성
    ```
    // logging.level.org.springframework=INFO
    logging.level.org.springframework.web=DEBUG
    ```
- 로그 중에 `o.s.web.servlet.DispatcherServlet` 는 앞에 package가 다 생략되어 있는 것임
    - `org.springframework.web.servlet.DispatcherServlet` 임
    