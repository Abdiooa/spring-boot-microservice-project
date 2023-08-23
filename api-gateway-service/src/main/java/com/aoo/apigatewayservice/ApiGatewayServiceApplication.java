package com.aoo.apigatewayservice;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@SpringBootApplication
public class ApiGatewayServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayServiceApplication.class, args);
	}
//	@Bean
//	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
//		var circuitBreakerConfig = CircuitBreakerConfig.custom()
//				.failureRateThreshold(50)
//				.waitDurationInOpenState(Duration.ofMillis(1000))
//				.slidingWindowSize(2)
//				.build();
//		var timeLimiterConfig = TimeLimiterConfig.custom()
//				.timeoutDuration(Duration.ofSeconds(4))
//				.build();
//
//		return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
//				.circuitBreakerConfig(circuitBreakerConfig)
//				.timeLimiterConfig(timeLimiterConfig)
//				.build());
//	}
}
