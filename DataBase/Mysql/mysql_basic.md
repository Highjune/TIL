# 기본적이고 개념적인 부분들 정리
> 기본적인 개념들도 정리 (감으로 얼추 알고만 있었던 개념들)


- 인덱스
  - 인덱스 항목인 열을 WHERE 조건에 넣으면 인덱스를 사용하지만, 넣지 않으면 인덱스를 사용할 수 없음.

- EXPLAIN
  - 해당하는 쿼리에 대한 설명을 볼 수 있다.
  - 표준 SQL에는 존재하지 않고, 데이터베이스 제품 의존형 명령이다.
  - sql문이 실제로 실행된 것이 아니라, 어떤 상태로 실행되는지 데이터베이스가 설명해준다.
  - 사용 예시 (EXPLAINN + sql문)
  ```
  EXPLAIN select * from User where u.uid = 'aaaa-bbbb-cccc'
  ```
  - 결과
    - possible_keys는 사용될 수 있는 인덱스가 표시되고, key는 실제로 사용된 인덱스가 표시된다.
  
  
- 최적화
  - 데이터베이스 내부 처리에서는 SELECT 명령으 실행하기에 앞서 `실행계획`을 세운다. 실행계획에서는 '인덱스가 지정된 열이 WHERE 조건이 지정되어 있으니 인덱스를 사용하자'와 같은 처리가 이루어진다. 
  - EXPLAIN 명령은 이 실행계획을 확인하는 명령이다.
  - 실행계획에서는 인덱스의 유무뿐만 아니라 인덱스를 사용할 것인지 여부에 대해서도 데이터베이스 내부의 최적화 처리를 통해 판단한다. 이 때 판단 기준으로 인덱스의 품질도 고려한다. 예를 들어 ‘true’, ‘false’ 라는 값만 가지는 열이 있다면, 해당 열에 인덱스를 지정해도 단순한 이진트리가 되어 좋은 구조를 가지지 못한다. Ex) true -> true-> true…(반복). 이는 단순한 리스트와 별다른 차이가 없는 구조로, 이진탐색에 의한 효율화를 기대할 수 없다. 
  - 데이터의 종류가 적으면 적을수록 인덱스의 효율도 떨어진다. 반대로 서로 다른 값으로 여러 종류의 데이터가 존재하면(카디널리티가 높으면) 효율은 좋아진다. 이렇게 인덱스의 품질을 고려해 실행계획이 세워진다



- group by
  - group by 에서 지정한 열 이외의 열은 집계함수(ex. sum(), count())를 사용하지 않은 채 select 구에 지정할 수 없다.

- Mysql 에서는 데이터를 추가하거나 갱신할 경우, 동일한 테이블을 서브쿼리에서 사용할 수 없도록 되어있다. 
  - 그래서 아래와 같은 쿼리는 에러가 난다(You Can’t specify target table ‘(테이블이름)’ for update in FROM clause
  - 에러나는 쿼리
  ```
  DELETE FROM sampleTable WHERE a = (SELECT MIN(a) FROM sampleTable)
  ```
  - 그래서 변수를 사용하거나 인라인 뷸 임시 테이블을 만들도록 처리하면 된다.
  ```
  DELETE FROM sampleTable WHERE a = (SELECT a FROM (SELECT MIN(a) AS a FROM sampleTable) AS x);
  ```

- 내부처리 순서
  - WHERE 구 -> GROUP BY 구 -> SELECT 구 -> ORDER BY 구
  - 다음 쿼리는 에러
  ```
  SELECT name, COUNT(name) 
  FROM sampleTable
  WHERE COUNT(name) = 1 
  GROUP BY name;
  ```
  - WHERE 구로 행을 검색하는 처리가 GROUP BY 로 그룹화하는 처리보다 순서상 앞서기 때문
  - SELECT 구에서 지정한 별명을 WHERE 구에서 사용할 수 없었던 것과 같은 이유로, 그룹화가 필요한 집계함수는 WHERE 구에서 지정할 수 없다.
  - 그래서 HAVING을 사용해야 한다. 아래처럼
  ```
  SELECT name, COUNT(name) 
  FROM sampleTable
  GROUP BY name
  HAVING COUNT(name) = 1;
  ```

  