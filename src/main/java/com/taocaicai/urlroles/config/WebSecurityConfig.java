package com.taocaicai.urlroles.config;

import com.taocaicai.urlroles.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Oakley
 * @version 0.0.1
 * @Date 2020-06-07 03:30:3:30
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomUserDetailsService customUserDetailsService;
    /**
     * 指定userService
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(customUserDetailsService);

        //认证信息存储到内存中
       /* auth.inMemoryAuthentication()
                .passwordEncoder(new MyPasswordEncoder())
                .withUser("admin").password(new MyPasswordEncoder().encode("admin")).roles("ADMIN");*/
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
       // return new BCryptPasswordEncoder();
        return new MyPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/home").permitAll()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/dba/**").hasAnyRole("dba","admin")
                .antMatchers("/user/**").hasRole("user")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //设置静态资源不要拦截
        web.ignoring().antMatchers("/js/**","/cs/**","/images/**");
    }
}
