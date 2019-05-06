package com.opms.bms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class OpmsBmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpmsBmsApplication.class, args);
	}

}
