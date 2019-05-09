package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@MapperScan(basePackages = {"com.example.demo.mysqlMapper"}, sqlSessionFactoryRef = "mysqlSessionFactory")
public class MysqlConfig {
	@Autowired
	@Qualifier("mysqlDatasource")
	private DataSource dsMysql;
	
	@Bean
	@Primary
	public SqlSessionFactory mysqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dsMysql);
		return factoryBean.getObject();
	}
	
	@Bean
	@Primary
	public SqlSessionTemplate mysqlSessionTemplate() throws Exception
	{
		SqlSessionTemplate template = new SqlSessionTemplate(mysqlSessionFactory());
		return template;
	}
}