- ubuntu 버전 확인
```
lsb_release -a
```

## Ubuntu에 mysql 설치
- apt-get 업데이트
```
sudo apt-get update
```

- mysql-server 설치
```
sudo apt-get install mysql-server
```

- 외부에서 접속할 수 있도록 mysql 포트(3306) 열기
```
sudo ufw allow mysql
또는
sudo ufw allow 3306
```

- mysql 실행
```
sudo systemctl start mysql
```

- Ubuntu 서버가 재시작되더라도 mysql이 자동 시작되도록 등록
```
sudo systemctl enable mysql
```

- mysql에 접속
    - 비밀번호 설정을 따로 하지 않았기 때문에 ubuntu 비밀번호와 동일
```
sudo /usr/bin/mysql -u root -p
(비밀번호 입력)
```

- (mysql에 접속 후) 버전 확인
```
SHOW VARIABLES LIKE "%version%";
```

- root계정에 패스워드 추가. (mysql 접속 후)
    - 5.7.6이후 버전이라면 아래와 같이 쿼리 실행
    ```
    ALTER USER 'root'@'localhost' IDENTIFIED BY '비밀번호';
    ex) ALTER USER 'root'@'localhost' IDENTIFIED BY 'admin';
    ```
    - 5.7.6이전 버전이라면 아래와 같이 쿼리 실행
    ```
    SET PASSWORD FOR 'root'@'localhost' = PASSWORD('비밀번호');
    ex) SET PASSWORD FOR 'root'@'localhost' = PASSWORD('admin');
    ```

- (mysql에 접속 후) user, 권한 등 확인
```
SELECT User, Host, Authentication_string FROM mysql.user;
```

- (mysql에 접속 후) Database 만들기
```
CREATE DATABASE practice_DB;
```

- (mysql에 접속 후) Database 리스트 확인
```
SHOW DATABASES;
```

- (mysql에 접속 후) mysql 의 계정 만들기. root계정보다 안전.
    - 계정은 tucker이고 Host는 localhost, 패스워드는 1234
        - `CREATE USER 'tucker'@'localhost' IDENTIFIED BY '1234';` 라고 하면 localhost에서 tucker/1234 로만 들어갈 수 있음 
        - `CREATE USER 'tucker'@'12.34.56.78' IDENTIFIED BY '1234';` 라고 하면 12.34.56.78에서 tucker/1234 로만 들어갈 수 있음
        - `CREATE USER 'baronic'@'%' IDENTIFIED BY 'baronic';` 라고 하면 모든ip에서 다 baronic/baronic 로 접속할 수 있음
    ```
    CREATE USER 'tucker'@'localhost' IDENTIFIED BY '1234';
    ```
- (mysql에 접속 후) mysql 환경설정을 변경할 경우, mysql의 재시작 없이 변경한 설정 부분 적용시킬 때 아래 명령어. DB의 table의 추가, 삭제 등의 변경은 MYSQL 환경 설정이 아니므로 해당 명령어가 필요 없다. 하지만 id, 패스워드 추가 & 수정 되었을 경우, 환경 설정이 변경되었기에 해당 명령어 필요
```
FLUSH PRIVILEGES;
```

- 계정이 잘 생성되었는지 user 정보 다시 확인
```
SELECT User, Host, Authentication_string FROM mysql.user;
```

- 이제 생성한 'tucker' 계정에 'practice_DB'를 사용할 수 있도록 권한 부여
    - localhost 에서 tucker로 접속했을 때 practice_DB에 대한 모든 권한 부여
    ```
    GRANT ALL PRIVILEGES ON practice_DB.* TO tucker@'localhost';
    ```
    - 외부 모든 곳(%) 에서 tucker로 접속했을 때 practice_DB에 대한 모든 권한 부여
    ```
    GRANT ALL PRIVILEGES ON practice_DB.* TO tucker@'%';
    ```
    - ex) 만약 위에서 해당 계정(baronic이라면) 에 대해서 모든 host에 대한 권한을 부여 하려면 `'%'` (''넣기)
    ```
    GRANT ALL PRIVILEGES ON practice_DB.* TO baronic@'%';
    ```

- DB의 권한을 변경했으니 다시 FLUSH PRIVILEGES;
```
FLUSH PRIVILEGES;
```

- tucker 계정이 localhost에서 어떤 권한을 가지고 있는지 확인
    ```
    SHOW GRANTS FOR 'tucker'@'localhost';
    ```
    ```
    SHOW GRANTS FOR 'baronic'@'%';
    ```
- 위의 쿼리 결과로 나온 `GRANT USAGE ON *.* TO`에서 `*.*`는 아무 권한이 없다는 의미이다. 현재 tucker 계정은 practice_DB만 모든 권한을 가지고 있고 mysql의 admin이나 system을 접근할 수 있는 권한이 없다는 것을 의미

- 계정 뒤에 붙은 @localhost는 해당 계정이 localhost 즉 mysql이 설치된 pc에서만 접속할 수 있다는 의미. 만약 다른 서버(remote)에서 접속하고 싶다면 접속하려는 서버의 IP로 계정을 새로 만들어야 한다. 예를 들어 192.168.0.10에서 접속하고 싶다면 아래와 같이 쿼리 실행
```
CREATE USER 'root'@'192.168.0.10' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'192.168.0.10' WITH GRANT OPTION;
FLUSH PRIVILEGES;
```
만약 특정 PC(192.168.0.10)이 아닌 어디서든 접근하려면 IP대신 %로 해주면 된다
```
CREATE USER 'root'@'%' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
``` 

- 계정 리스트를 다시 보면 root@% 계정이 추가된 것을 확인할 수 있다.
```
SELECT User, Host, Authentication_string FROM mysql.user;
```

- 마찬가지로 tucker 계정도 remote 접속이 필요하다면 아래와 같이 쿼리 실행
```
CREATE USER 'tucker'@'%' IDENTIFIED BY 'tucker123';
GRANT ALL PRIVILEGES ON practice_DB.* TO 'tucker'@'%';
FLUSH PRIVILEGES;
```


- 참고링크
    - https://dejavuqa.tistory.com/317
    

## ubuntu20.04 에서 mysql 외부접속 허용하기
- mysql 설정 파일 수정하기
    - [참고링크](https://yoshikixdrum.tistory.com/217)
- 방화벽 열기
    - `sudo ufw allow from 192.168.0.1 to any port 3306`
    - 아래 링크 보고 상황에 맞게 설정
    - [참고링크](https://milkye.tistory.com/343)
