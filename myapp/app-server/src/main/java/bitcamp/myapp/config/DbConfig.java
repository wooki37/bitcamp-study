package bitcamp.myapp.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@PropertySource({"classpath:bitcamp/myapp/config/ncloud/jdbc.properties"})
@EnableTransactionManagement  // @EnableTransactionManagement 애노테이션을 처리할 객체 등록
public class DbConfig {

   {
    System.out.println("DbConfig() 호출됨!!!!!!!");
  }
  @Bean
  public DataSource dataSource(
          @Value("${jdbc.driver}") String driver,
          @Value("${jdbc.url}") String url,
          @Value("${jdbc.username}") String username,
          @Value("${jdbc.password}") String password) {
    System.out.println("DbConfig.dataSource() 호출되엇네~~~~~~~~~~~~~~~~~~~~!");
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName(driver);
    ds.setUrl(url);
    ds.setUsername(username);
    ds.setPassword(password);

    return ds;
  }
  @Bean
  public PlatformTransactionManager transactionManager(DataSource dataSource) {
    System.out.println("DbConfig.transactionManager() 호출됨!");

    return new DataSourceTransactionManager(dataSource);
  }
}

