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

## admin_user

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

## admin_role_group

- user 테이블과 더불어 가장 중요한 테이블
- 상속 개념
  - 예를 들어 A라는 role_group에 속한 홍길동은, A에 새로운 권한(삭제)이 추가되면 홍길동은 자동으로 삭제 권한을 부여받는다.

## menu

- 재귀쿼리로 계층 구조를 알 수 있게 던져줘야 함
- 중요컬럼

  - id
    - varchar
    - 사실 integer로 하면 더 명확하지만, 크게 상관없다.
  - depth
    - 몇 단계(hierachy)인지.
  - parent
    - id값과 동일 데이터 컬럼
    - 자신의 부모(id)가 누구인지, 부모의 id
    - 제일 위는 root(Integer라면 0으로 지정하든지, 임의대로)
  - order
    - 같은 부모 안에서의 순서
  - url
    - 메뉴버튼을 클릭했을 시 어떤 페이지(위치=url)로 이동할 것인가

- ex) (다시 정리하기)

| id  | name  | dept | parent | order |
| :-: | :---: | :--: | :----: | :---: |
|  1  | home  |  1   |   N    |   1   |
|  2  | menu1 |  2   |   1    |   1   |
|  3  | menu2 |  1   |   1    |   2   |
|  4  | menu2 |  1   |   1    |   3   |

## admin_user_menu

- user가 `개별적으로`(그룹으로 부여받는 권한 이외의) 받은 `메뉴`에 대한 권한
- user가 그룹으로 부여받는 권한(user_role_group 테이블) 보다 우선순위가 더 높음

## admin_user_role_group

- user가 `그룹단위`로 부여받는 `메뉴` 권한

## menu_function

- 하나의 `메뉴 밑에 있는 기능`들 정의
- 기능 리스트
- ex) `수정하기` 버튼이 A유저에게는 보이지 않도록
- 미리 버튼들을 만들어 두는 것임
- 중요컬럼
  - name
    - `조회 버튼`, `삭제 버튼`

## admin_user_menu_function

- 하나의 `메뉴 밑에 있는 기능`들에 대한 권한

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

- user, role_group, data_source, menu, sub_menu 테이블에 multi_language가 포함이 되어 연결되는 건데 연결하면 테이블 관계 육안으로 너무 복잡하기에 그냥 독립적으로 뒀음.
- 중요컬럼
  - id
    - location과 같이 pk
- ex) (다시 확인해보기)

| id  | location |  name  |
| :-: | :------: | :----: |
|  1  |    kr    |  농구  |
|  1  |   eng    |  야구  |
|  1  |    ch    |  축구  |
|  1  |    jp    | 테니스 |
|  2  |    kr    |  농구  |
|  2  |   eng    |  야구  |
|  2  |    ch    |  축구  |
|  2  |    jp    | 테니스 |

## data_source

- 통합 admin 목적이므로 여러 프로젝트의 데이터가 존재하는데 그래프화 할 수 있는 데이터들 중에서 보고자 하는 데이터만 설정하려는 목적
- ex) 축구, 농구, 야구 중 야구 프로그램 이용하는 customer의 정보만 보고 싶을 때 나머지 축구, 농구는 is_active를 `false` 로 설정
- 중요 컬럼
  - id
    - ex) Korea BaseBall PlayOff Season, korea Soccer, China Soccer 등

## ip_access

- 중요 컬럼
  - user_id
    - ex) hong1234
  - ip
    - ex) 192.168.0.~
  - desc
    - ex) hong1234의 집 pc, hong1234의 회사 pc
