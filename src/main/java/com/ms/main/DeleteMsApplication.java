package com.ms.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import brave.sampler.Sampler;

@SpringBootApplication
@ComponentScan({"com.acontroller", "com.bservice"})
@EnableJpaRepositories("com.cdao")
@EntityScan("com.domain")
@EnableDiscoveryClient
@EnableFeignClients("com.proxy") //will scan the packages for feign clients(classes annotated with @FeignClient)
public class DeleteMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeleteMsApplication.class, args);
	}

	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}