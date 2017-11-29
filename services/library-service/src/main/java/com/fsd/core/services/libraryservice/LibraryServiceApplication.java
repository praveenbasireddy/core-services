package com.fsd.core.services.libraryservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.util.SocketUtils;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
//Enable the Below for Auth
//@EnableResourceServer
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class LibraryServiceApplication
        //extends ResourceServerConfigurerAdapter
{

    private static final Logger log = LoggerFactory.getLogger(LibraryServiceApplication.class);
    @Autowired
    private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(LibraryServiceApplication.class, args);
	}

    // this is used in the clients to make calls leveraging ribbon
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
