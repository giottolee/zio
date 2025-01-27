package com.giotto.zio.service.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class DataSourceConfig {

	@Value("${spring.datasource.url:jdbc:mysql://localhost:3306/zio_db}")
	public String url;

	@Value("${spring.datasource.username:root}")
	private String username;

	@Value("${spring.datasource.password:1234qwer}")
	private String password;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		log.error("DataSource init url: {}, username: {}, password: {}", url, username, password);
		return dataSource;
	}
}
