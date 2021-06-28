# 빠른 Session 체크를 위해 Redis 이용
- 툴은 Redis Desktop Manager 사용

## Application.properties
- 접속정보
```
# REDIS (RedisProperties)
spring.redis.host		= 12.1.2.3
spring.redis.port		= 12345
spring.redis.password	= adminpw
spring.redis.database	= 0
```

## Controller
- 세션체크 하는 부분
```
public String doItSomething(HttpServletRequest request, @RequestBody Map<String, Object> params) {
    Map<String, Object> result = new HashMap<String, Object>();


}
```