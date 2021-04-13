# 모든 프로젝트 통합 admin 설계 목적 및 요구사항
- 하나의 admin 프로그램으로 여러 프로젝트를 관리하려는 목적
    - ex) 축구, 야구, 농구 등
- 메뉴들 목록은 `재퀴궈리` 로 계층 구조.
- user(운영 user, admin user)가 직접 메뉴 생성 가능하도록.
- user의 모든 행위를 log로 남김.
- 특정한 user의 메뉴에 대한 권한은 그룹 + 개인(별도로 부여) 으로 부여
    - user 검색 -> 그룹권한 + 개인권한을 sum해서 보여주기
- 처음 설계해보는 초짜 내 기준(?)에서 꽤 큰 범위로 설정했기에 꼭 필요치 않은 부분은 없애도 될 듯


# 테이블 설명

## 0. 공통 및 기타
- (mysql 기준) last_login_time 이나 insert_time은 기본값에 `CURRENT_TIMESTAMP` 설정, update_time은 `CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP` 설정
- 각 테이블(M : N 관계의 중간에서 릴레이 역할 테이블들 제외)의 id는 다 varchar
    - 만약 `auto increment` 같은 숫자가 별도로 필요하다면 idx 로 별도로 두면 좋다. 그리고 그 idx가 크다면 `int` 말고 `BIGINT` 와 같은 데이터 타입으로 두기. 그리고 `부호 없음` 체크 하면 더 큰 값으로 설정 가능.
    - action_log 테이블은 idx 따로 두지 않고 id(BIGINT)로 설정
- user_menu, menu-role_group 테이블 등에서 있는 crud(create, read, update, delete) 컬럼의 데이터 타입은 `boolean` 이어야 함(erd에서 잘못된 것). 또는 `int(1 or 0)`
- is_active도 `boolean` 이어야 함(erd에서 잘못된 것). 또는 `int(1 or 0)`



## user
- role_group 테이블과 더불어 가장 중요한 테이블
- 중요 컬럼
    - id 
        - varchar
        - pk
        - 로그인 id라고 생각하면 됨. 다른 플랫폼 회원가입시 id
            - ex) hong1234
    - name
        - varchar
        - ex) 홍길동
    - password

## role_group
- user 테이블과 더불어 가장 중요한 테이블
- 상속 개념
    - 예를 들어 A라는 role_group에 속한 홍길동은, A에 새로운 권한(삭제)이 추가되면 홍길동은 자동으로 삭제 권한을 부여받는다.

## menu


## sub_menu
- 여러 메뉴 목록 중 하나의 메뉴 안에 있는 여러 


## sub_menu
- 하나의 메뉴 안에서 


## action_log
- 중요도는 조금 떨어짐
- 중요 컬럼
    - action
        - varchar 
        - 특정 행동에 대한 설명(자유롭게)
        - ex) 사용자 메뉴의 생성버튼, 7(7번 버튼), 8, 삭제 등
    - description
        - varchar
        - 기타 설명
    - origin_data
        - varchar
        - 해당 액션 전 데이터(insert 기능이라면 애초에 없었기 때문에 null)
    - modified_data
        - varchar
        - 해당 액션 후 데이터
    

## multi_language
- user, role_group, data-source, menu, sub_menu 테이블과 연결되는 건데 연결하면 테이블 관계 육안으로 너무 복잡하기에 그냥 독립적으로 뒀음. multi_lanauge 


## data_source
- 통합 admin 목적이므로 여러 프로젝트의 데이터가 존재하는데 그래프화 할 수 있는 데이터들 중에서 보고자 하는 데이터만 설정하려는 목적
- ex) 축구, 농구, 야구 중 야구 프로그램 이용하는 customer의 정보만 보고 싶을 때 나머지 축구, 농구는 is_active를 `false` 로 설정
- 중요 컬럼
    - id
        - ex) Korea BaseBall PlayOff Season, korea Soccer, China Soccer 등

## ip_access_control
- 