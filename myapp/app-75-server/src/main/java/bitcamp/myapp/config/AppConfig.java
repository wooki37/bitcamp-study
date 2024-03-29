package bitcamp.myapp.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// Application을 실행하는데 필요한 객체를 설정하는 일을 한다.
//
@ComponentScan(basePackages = {
        "bitcamp.myapp.dao",
        "bitcamp.myapp.controller",
        "bitcamp.myapp.service"})

@PropertySource({"classpath:bitcamp/myapp/config/ncloud/jdbc.properties"})
@MapperScan("bitcamp.myapp.dao")  // Mybatis가 자동으로 생성할 DAo 객체의 인터페이스 패키지 지정
@EnableTransactionManagement  // @EnableTransactionManagement 애노테이션을 처리할 객체 등록
public class AppConfig {

  public AppConfig() {
    System.out.println("AppConfig() 호출됨!!!!!!!");
  }
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ApplicationContext appCtx) throws Exception {
      System.out.println("AppConfig.sqlSessionFactory() 호출됨!");
      org.apache.ibatis.logging.LogFactory.useLog4J2Logging();
      SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
      factoryBean.setDataSource(dataSource);
      factoryBean.setTypeAliasesPackage("bitcamp.myapp.vo");
      factoryBean.setMapperLocations(appCtx.getResources("classpath:bitcamp/myapp/dao/mysql/*Dao.xml"));

      return factoryBean.getObject();
    }
  @Bean
  public DataSource dataSource(
    @Value("${jdbc.driver}") String driver,
    @Value("${jdbc.url}") String url,
    @Value("${jdbc.username}") String username,
    @Value("${jdbc.password}") String password) {
    System.out.println("AppConfig.dataSource() 호출되엇네~~~~~~~~~~~~~~~~~~~~!");
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName(driver);
    ds.setUrl(url);
    ds.setUsername(username);
    ds.setPassword(password);

    return ds;
  }
  @Bean
  public PlatformTransactionManager transactionManager(DataSource dataSource) {
    System.out.println("AppConfig.transactionManager() 호출됨!");
    return new DataSourceTransactionManager(dataSource);
  }
}



