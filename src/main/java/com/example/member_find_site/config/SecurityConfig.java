package com.example.member_find_site.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //스프링 시큐리티 필터가 스프링 필터체인에 등록됨
public class SecurityConfig{

    @Bean
    public BCryptPasswordEncoder encoderPwd() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable(); // 사이트 위변조 방지
        //인가(접근권한 설정)
        http.authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/memeber/info/**").hasAnyRole("ADMIN","MEMBER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll();

        //로그인 설정
        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("login")
                .defaultSuccessUrl("/");


        return http.build();
    }
}
