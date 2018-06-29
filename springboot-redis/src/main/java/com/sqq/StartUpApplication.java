package com.sqq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * 启动类
 * @author PC
 *
 */
@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class StartUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartUpApplication.class, args);
	}

}
