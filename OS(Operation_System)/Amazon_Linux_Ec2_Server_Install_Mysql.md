# Amazon Linux Ec2 서버에 Mysql 설치 (필기 다 못해서 링크 참고하면서 보기)
- 참고 링크
    - https://lemontia.tistory.com/1029 (설치, yum설치, character 설정 등)
    - https://emong.tistory.com/235 (외부접속 허용관련)
    - https://jootc.com/p/201806101246 (접속권한 설정)


- 패키지 설치
    - Linux 는 크게 레드햇, 데비안, 우분투 3가지인데 계열에 딸느 패키지 관리 명령어가 다르다
        - 레드햇 계열은 : yum
            - 레드햇 엔터프라이즈
            - 페도라
            - CentOS
        - 데비안, 우분투 계열 : apt-get
    ```
    sudo yum update
    ```

- mysql 다운로드
    - 새 버전 있을 수 있으니 검색해보기
    ```
    sudo yum install https://dev.mysql.com/get/mysql80-community-release-el7-3.noarch.rpm
    ```
- mysql 설치
```
sudo yum install mysql-community-server
```

- mysql 실행
```
sudo systemctl start mysqld
```

- mysql 실행확인(상태확인)
```
sudo systemctl status mysqld
```

- mysql 에 접속하기 위해 초기화된 비밀번호 찾기. 로그에서.
    ```
    sudo grep 'temporary password' /var/log/mysqld.log
    ```
    - 그러면 아래처럼 뜬다
    ```
    ..(중략).. A temporary password is generated for root@localhost: 3lkjsdfkkjsaf
    ```


- 접속
```
sudo mysql_secure_installation -p '3lkjsdfkkjsaf'
```

- 새로운 비밀번호 입력하라고 뜬다.
    - 중요) 최소 8자 이상, 대소문자, 특수 문자 등 필요 해서 잘 설정해야 함

- 설정값들에 대해서 물어본다. 다 `Y`

- mysql로 로그인 가능
    ```
    mysql -u root -p
    ```
    ```
    (위에서 설정한 새로운 비번 입력)
    ```



- 방화벽 세팅해야 한다.
    - 확인
    ```
    netstat -ntlp
    ```
    - 또는 검색해서 확인
    ```
    sudo netstat -ntlp | grep mysqld
    ```
    - 방화벽에 포트 추가해주기


    - 참고(아래 3개 명령어로 방화벽 다 열 수 있다)
    ```
    sudo iptables -X
    sudo iptables -S
    sudo iptables -F
    ```
    
- mysql 외부 접속 허용해주기
    - /etc/my.cnf 에 포트 열기
        - 파일 열어서
        ```
        vi /etc/my.cnf 
        ```
        - 외부에서 접근할 수 있도록 열어주기
        ```
        bind-address = 0.0.0.0

        ..(중략)..
        ```
        - 만약 `bind-address = 127.0.0.1` 이 되어 있으면 주석 처리해주자. 사실 `bind-address = 0.0.0.0` 안해주고 이것만 주석처리 해도 된다. 
        ```
        #bind-address = 127.0.0.1
        bind-address = 0.0.0.0
        ..(중략)..
        ```
        - 설정 파일 변경했으니 재시작
        ```
        sudo service mysqld restart
        ```
        - 포트 열려 있는지 확인
        ``` 
        netstat -ntlp
        ```
        - 해보면 아래 추가
        ```
        0.0.0.0:3306
        ```
- 접속
```
mysql -u root -p 
```
     