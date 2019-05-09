package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {
	@Primary
	@Bean(name="mysqlDatasource")
	@ConfigurationProperties(prefix = "spring.ds_mysql")
	public DataSource mysqlSource()
	{
		return DataSourceBuilder.create().build();
	}
	@Bean(name="pgsqlDatasource")
	@ConfigurationProperties(prefix = "spring.ds_pgsql")
	public DataSource pgsqlSource()
	{
		return DataSourceBuilder.create().build();
	}
}
