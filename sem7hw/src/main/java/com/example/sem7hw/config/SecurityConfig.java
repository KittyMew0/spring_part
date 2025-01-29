package com.example.sem7hw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/private-data").hasRole("ADMIN") // Только для ADMIN
                .antMatchers("/public-data").authenticated() // Для всех аутентифицированных
                .and()
                .formLogin() // Включаем форму логина
                .loginPage("/login") // Связываем с формой логина
                .defaultSuccessUrl("/public-data", true) // После успешного входа
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login") // После выхода перенаправление на логин
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("ADMIN");
    }
}
