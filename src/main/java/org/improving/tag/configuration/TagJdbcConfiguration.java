package org.improving.tag.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class TagJdbcConfiguration {
    @Bean
    public DataSource createDataSource() {
        var dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/tag?serverTimezone=UTC");
        dataSource.setUsername("ShavonneLocal");
        dataSource.setPassword("BlackHippieMagic2019!");
        return dataSource;
    }
}
