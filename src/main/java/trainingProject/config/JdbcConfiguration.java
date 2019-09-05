package trainingProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("trainingProject")
public class JdbcConfiguration {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db_example?useSSL=false");
        dataSource.setUsername("springuser");
        dataSource.setPassword("ThePassword");
        return dataSource;
    }
    @Bean
    public JdbcTemplate JdbcTemplate()
    {
        JdbcTemplate jdbcTemplate
                = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }


}


