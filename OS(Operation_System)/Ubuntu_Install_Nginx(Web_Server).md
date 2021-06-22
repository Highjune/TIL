# Nginx 설치해서 웹서버로 사용
- cf) apache 웹서버보다 성능이 조금 더 빠름

(순서대로)

- Nginx 설치
    - 만약 root로 접속했다면
    ```
    apt install nginx
    ```
    - root 접속이 아니라면
    ```
    sudo apt install nginx
    ```
- nginx 서비스 시작
```
service nginx start
```
- 사용자 계정 만들기(사용자 디렉토리에 프런트 소스 넣어야 함). root로 접속해야 생성 가능
    - [사용자 계정 만들기 참고 링크](https://jhnyang.tistory.com/10)
    - 사용자 생성
    ```
    useradd highjune
    ```
    - 비번 설정
    ```
    passwd highjune
    ```
    - 사용자 계정을 만들게 되면 /home/highjune 이라는 디렉토리가 생성

- 사용자 계정(highune) 디렉토리 밑에 front_source 라는 디렉토리 생성
```
mkdir front_source
```

- /home/highjune/front_source 디렉토리 밑에 FTP 로 프런트 파일 옮기기

- /home/highjune/cert 디렉토리 만들어서 인증서 복사해서 넣기(.ssh) 위한 것
```
~~~.ca
~~~.crt
~~~.csr
~~~.key
```

- 설정하기
    - nginx를 설치하면 /etc/nginx가 자동 생성되고 그 하위에 sites-enabled 디렉토리가 있다.
    - /etc/nginx/sites-enabled
    - 그 밑에 .conf 설정 파일 만들기. 여기에 설정 파일 만든 것은 /etc/nginx/nginx.conf 에서 읽어들임
    - vim으로 설정 파일 생성하기. 
    - ex) vim no_cerf.conf 또는 vim on_cerf.conf
    1. 인증서 없는 버전(간단). 
    ```
        server {
            listen 80;
            listen [::]:80;
            server_name highjune.dev;

            access_log /var/log/nginx/highjune-dev-access.log;
            error_log /var/log/nginx/highjune-dev-error.log;

            location / {
                    root /home/test/front_source;
                    index index.html index.htm index.nginx-debian.html;
                    try_files $uri $uri/ /index.html;
            }
    }

    ```
    2. 인증서 있는 버전
    ```
        server {
        listen        443;
        listen        [::]:443;
        server_name   highjune.dev;
        ssl_certificate /home/test/cert/_highjune_dev.crt;
        ssl_certificate_key /home/test/cert/_highjune_dev.key;

        access_log /var/log/nginx/highjune-dev-access.log;
        error_log /var/log/nginx/highjune-dev-error.log;

        location / {


            root /home/test/front_source;
            index index.html index.htm index.nginx-debian.html;
            try_files $uri $uri/ /index.html;

        }
    }
    ```
    - 각각 의미
    ```
    listen 80;               // 80번(http) 포트를 여는데 ipv4 주소
    listen [::]:80;          // 80번(http) 포트를 여는데 ipv6 주소
    listen        443;       // 443번(https) 포트를 여는데 ipv4 주소
    listen        [::]:443;  // 443번(https) 포트를 여는데 ipv6 주소
    ```
    ```
    server_name twadm.arenacast.io; // 도메인 주소
    ```
    ```
    ssl_certificate /home/test/cert/_highjune_dev.crt;     // 인증서 있는 곳 위치
    ssl_certificate_key /home/test/cert/_highjune_dev.key; // 인증서 key 있는 곳 위치
    ```
    ```
    access_log /var/log/nginx/highjune-dev-access.log; // 로그 
    error_log /var/log/nginx/highjune-dev-error.log;   // 에러 로그
    ```
    ```
    root /home/test/front_source; // root 경로로 접근시 프런트 소스가 있는 곳
    index index.html index.htm index.nginx-debian.html; // root 경로로 왔을 때 처음 찾는 파일들. 순서대로임. index가 없으면 index.html, 앞의 것이 없으면 뒤의 것을 찾음.
    try_files $uri $uri/ /index.html; // index.html 을 실행
    ```

- 설정 적용하기. nginx 재시작
```
service nginx restart
```

- 제대로 적용됏는지 확인하기. 서비스 상태 확인
    - 상태 확인
    ```
    service nginx status
    ```
    - 만약 잘 안돌아간다면 설정파일들 .conf 에 잘못 입력한 것이다

- nginx 설정 파일(etc/nginx/nginx.conf) 확인하기
    - 위에서 설정한 파일들 읽어들이는 코드
    ```
    include /etc/nginx/conf.d/*.conf;
    include /etc/nginx/sites-enabled/*;
    ```
    - 서버에서 쿼리 읽어들이는 connection 시간 설정. 긴 쿼리 더 읽어들이고 싶을 때 이거 늘리면 됨
    ```
    keepalive_timeout 3600;
    ```
    - 업로드하는 파일 크기 설정
    ```
    client_max_body_size 0 // 0이면 무제한 파일 설정. 10mb 이런식으로 설정 가능
    ```
