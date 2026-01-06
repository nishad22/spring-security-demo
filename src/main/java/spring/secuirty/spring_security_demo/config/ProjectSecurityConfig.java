package spring.secuirty.spring_security_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) {
        //line no. 15 -> request will be access by only authenticated user
        //http.authorizeHttpRequests(requests -> requests.anyRequest().authenticated());
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
                .requestMatchers("/notices","/contact").permitAll());
        //http.formLogin(Customizer.withDefaults());
        /**
         * how to disable default form Login
         */
//        http.formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.disable());
//        http.httpBasic(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.disable());
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
