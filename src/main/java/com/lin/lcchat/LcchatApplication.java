package com.lin.lcchat;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author: chong.lin
 * @date: 2018/1/17 下午2:33
 * @company: 易宝支付(YeePay)
 */
@SpringBootApplication
public class LcchatApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LcchatApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(LcchatApplication.class, args);
	}

}

