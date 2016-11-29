package com.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DataConfig {

/*	@Bean
	public DataSource dataSource(){
		DruidDataSource dataSource=new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/database");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}*/
	
	
	  @Bean 
	  public DataSource dataSource() {
		  EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		  builder.setType(EmbeddedDatabaseType.H2);
		  builder.addScript("classpath:com/db/jdbc/schema.sql");
		  builder.addScript("classpath:com/db/jdbc/test-data.sql"); return
		  builder.build();
	  }
	 
	  @Bean
	  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		  return new JdbcTemplate(dataSource);
	  }
	
}
