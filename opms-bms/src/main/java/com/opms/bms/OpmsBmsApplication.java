package com.opms.bms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableAsync
public class OpmsBmsApplication {

	private static   ApplicationContext application;

	public static void main(String[] args) {

		application = SpringApplication.run(OpmsBmsApplication.class, args);
	}

	@Bean("getApplication")
	public  ApplicationContext getApplication(){
		return  this.application;
	}

}
