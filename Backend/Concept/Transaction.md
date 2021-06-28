# java transaction

## Config
```
@Configuration
@MapperScan(value="com.baronic.ours", sqlSessionFactoryRef="sqlSessionFactory")
@EnableTransactionManagement
public class DataSource {
    @Primary
    @Bean(name="dataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Autowired @Qualifier("dataSource") DataSource dataSource, ApplicationContext applicationContext)
            throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setConfigLocation(applicationContext.getResource("classpath:sql/mybatis-config.xml"));
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:sql/**/mapper-*.xml"));
//        factoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper-primary/**/*.xml"));
        return factoryBean.getObject();
    }
    @Primary
    @Bean(name="sqlSession")
    public SqlSessionTemplate sqlSession(@Autowired @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Primary
    @Bean(name="transactionManager")
    public DataSourceTransactionManager transactionManager(@Autowired @Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
```

## Transaction 적용
```
@Service
public class baronicService {

    private final DataSourceTransactionManager transactionManager;

    public baronicService(DataSourceTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    ..(중략)..


    // 적용하는 메서드
    public Map<String, Object> Method_A(Map<String, Object> params) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		
	    ..(중략)..

        // Transaction 객체 생성
		DefaultTransactionDefinition tdf = new DefaultTransactionDefinition();
		tdf.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus trStatus = this.transactionManager.getTransaction(tdf);
		
			
        ..(중략)..

        this.baronicDao.updateBaronic(params);   

        //성공시 커밋
        this.transactionManager.commit(trStatus);
			
		} catch(Exception e) {
            //실패 시 롤백
			this.transactionManager.rollback(trStatus);
			resultMap.put("error_code", ResponseCode.FAIL.getStatusCode());
			return resultMap;
		}
		return resultMap;
	}

}
```


## 기타
- `selectLock`
- selectLock은 DB작업 로직에서 duplicate 를 피하기 위한 장치로서 select 쿼리문의 말미에 `FOR UPDATE`를 붙여주면 selectLock이 걸리기 때문에 Transaction 작업 단위를 컨트롤할 수 있다.
- ex) mapper-baronic.xml
```
<select id="selectSomething" resultType="map">
    /* bingo.selectSomething */
    SELECT (~~중략~~)
    WHERE 1=1
    AND id = #{id}
    LIMIT 1 FOR UPDATE
</select>
```