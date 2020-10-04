package com.abc.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

/**
 * @Author guangyan
 * @Date 2020/10/3
 */
@Controller
public class DepartCodeConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
