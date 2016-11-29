package com.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

	private Logger logger = LoggerFactory.getLogger(WebConfig.class);

	/*
	 * @Bean public DataSource dataSource() {
	 * 
	 * EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	 * builder.setType(EmbeddedDatabaseType.H2);
	 * builder.addScript("classpath:com/db/jdbc/schema.sql");
	 * builder.addScript("classpath:com/db/jdbc/test-data.sql"); return
	 * builder.build();
	 * 
	 * }
	 */

	/*
	 * @Bean public SqlSessionFactoryBean SqlSessionFactoryBean(DataSource
	 * dataSource) { SqlSessionFactoryBean sqlSession = new
	 * SqlSessionFactoryBean(); String file =
	 * this.getClass().getResource("/").getFile(); logger.info(file);
	 * sqlSession.setConfigLocation(new FileSystemResource(new File(file,
	 * "mybatis.xml"))); sqlSession.setMapperLocations(new Resource[] { new
	 * FileSystemResource(file + "com/dao/mapper/AccountMapper.xml") });
	 * sqlSession.setDataSource(dataSource); return sqlSession; }
	 * 
	 * @Bean public MapperScannerConfigurer
	 * MapperScannerConfigurer(SqlSessionFactoryBean sqlSessionFactoryName) {
	 * MapperScannerConfigurer mapperScanner = new MapperScannerConfigurer();
	 * mapperScanner.setBasePackage("com.dao");
	 * mapperScanner.setSqlSessionFactoryBeanName("SqlSessionFactoryBean");
	 * return mapperScanner; }
	 */

	/*public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}*/

}
