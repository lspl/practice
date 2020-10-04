package com.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @EnableEurekaClient // 仅限于注册中心是Eureka,并且是SpringBoot应用(不是springcloud)
// @EnableDiscoveryClient // 注册中心可以是Eureka或者consul,并且是SpringBoot应用(不是springcloud)
@SpringBootApplication
public class ProviderApplication8081 {

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication8081.class, args);
	}

}
