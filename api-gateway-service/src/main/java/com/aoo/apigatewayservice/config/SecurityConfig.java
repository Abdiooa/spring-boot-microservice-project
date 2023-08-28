package com.aoo.apigatewayservice.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
//import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoders;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    private final String issuerUri = "http://localhost:8180/realms/micro-realm-by-me";
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http){
        http.authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/logedout").permitAll()
                        .anyExchange().authenticated())
//                .oauth2Login(withDefaults());
        . oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtDecoder(jwtDecoder())));
//        .oauth2ResourceServer(oauth->oauth.jwt(Customizer.withDefaults()));
        http.csrf(csrf -> csrf.disable());
//        http.logout(logout -> logout
//                .logoutSuccessHandler(handler)
//        );
        return http.build();
    }
    @Bean
    public ReactiveJwtDecoder jwtDecoder() {
        return ReactiveJwtDecoders.fromIssuerLocation(issuerUri);
    }
//    @Bean
//    public ReactiveJwtDecoder jwtDecoder() {
//        return NimbusReactiveJwtDecoder.withJwkSetUri(jwkSetUri).build();
//    }
//    @Bean
//    public ServerLogoutSuccessHandler oidcLogoutSuccessHandler(ReactiveClientRegistrationRepository clientRegistrationRepository) {
//        OidcClientInitiatedServerLogoutSuccessHandler logoutSuccessHandler = new OidcClientInitiatedServerLogoutSuccessHandler(clientRegistrationRepository);
//        logoutSuccessHandler.setPostLogoutRedirectUri("http://localhost:9191/logedout");
//        return logoutSuccessHandler;
//    }
//    @Bean
//    public MapReactiveUserDetailsService users() {
//        UserDetails user1 = User.builder()
//                .username("user1")
//                .password("{noop}1234")
//                .roles("user")
//                .build();
//        UserDetails user2 = User.builder()
//                .username("user2")
//                .password("{noop}1234")
//                .roles("admin")
//                .build();
//        UserDetails user3 = User.builder()
//                .username("user3")
//                .password("{noop}1234")
//                .roles("user")
//                .build();
//        return new MapReactiveUserDetailsService(user1, user2, user3);
//    }
}
