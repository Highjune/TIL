## Mybatis

- preparedStatement를 #{} 를 통해. 사용하는 것

### 문법

- choose

  ```
  <choose>
          <when test = "조건">
          ...
          </when>
          <when test = "조건">
          ...
          </when>
          .
          .
          .
          <otherwise> <!-- otherwise는 없어도 됨 -->
          ...
          </otherwise>
  </choose>
  ```

  - 보통 조건절에서 많이 쓰인다
  - ex)

  ```
  <choose>
  	<when test="'upcoming'.equals(filterType)">
       AND A.game_start_time <![CDATA[>]]> now()
  	</when>
  	<when test="menuType == 106002 || menuType == 106003">
       AND A.game_start_time <![CDATA[>]]> now()
  	</when>
  	<otherwise>
       AND A.game_start_time <![CDATA[<]]> now()
       AND C.status_type NOT IN <include refid="endGameStatus"/>
  	</otherwise>
  </choose>
  ```

- if

  ```
  <if test = "조건">

  </if>
  ```

  - ex)

  ```
  <if test="gameType == 104002">

  </if>

  ```

- sql문으로 정의하고 include로 들고오기

```
<sql id="GameType">
    	IN (104001, 104002, 104003, 104004, 105001)
</sql>


<select>
	select *
	from board AS b
	where b.game_type <include refid="GameType"></include>
</select>
```

- foreach

  - [문법 정리 링크](https://java119.tistory.com/85)
  - 넘겨준 리스트인 item에서 .으로 변수 뽑아내기
  - ex)

  ```
   <insert id="insertRoleInfo" parameterType="java.util.List">
    /* role.insertRoleInfo */
    INSERT INTO db_name.admin_role
    	VALUES
    	<foreach collection = "list" item = "item" separator = ", ">
  				(
  					#{item.user_id}
  					, #{item.menu_code}
  					, #{item.use_tag}
  					, NOW()
  				)
  		</foreach>
  </insert>
  ```

- insert한 후 자동 생성되는 키 바로 들고오기

  - useGeneratedKeys="true" 로 자동생성(mysql-autoincrement)
  - keyProperty="id" 로 자동생성되는 키를 id값으로 사용
  - test.xml

  ```
  <insert id="insert_id" parameterType="map" useGeneratedKeys="true" keyProperty="id">

          INSERT INTO db.test_table
          (
              name,
              age,
          )
          VALUES
          (
              {name},
              {age}
          )
  </insert>

  ```

  - testDao

  ```
   public Map<String, Object> insert(Map<String, Object> params) {
      sqlSession.insert(NS + "insertEntryInfo", params);
      return params;
  }
  ```

  - testService

  ```
  params.get("id"); // 이렇게 사용가능
  ```

### 링크

- [#{}안에 jdbctype=VARCHAR와 같이 붙이는 이유](http://egloos.zum.com/uknowapps/v/1814539)
