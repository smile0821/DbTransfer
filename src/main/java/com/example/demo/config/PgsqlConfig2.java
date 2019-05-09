package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@MapperScan(basePackages = {"com.example.demo.pgsqlMapper"}, sqlSessionFactoryRef = "pgsqlSessionFactory")
public class PgsqlConfig {
	@Autowired
	@Qualifier("pgsqlDatasource")
	private DataSource dsPgsql;
	
	@Bean
	@Primary
	public SqlSessionFactory pgsqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dsPgsql);
		return factoryBean.getObject();
	}
	
	@Bean
	@Primary
	public SqlSessionTemplate pgsqlSessionTemplate() throws Exception
	{
		SqlSessionTemplate template = new SqlSessionTemplate(pgsqlSessionFactory());
		return template;
	}
}