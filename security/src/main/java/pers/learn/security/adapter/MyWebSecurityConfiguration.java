package pers.learn.security.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pers.learn.security.filter.LoginPostProcessor;
import pers.learn.security.filter.PreLoginFilter;
import pers.learn.security.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义安全策略
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        PreLoginFilter preLoginFilter = new PreLoginFilter("/process", null);
        http.csrf().disable()
                .cors()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                // .addFilterBefore(preLoginFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .successForwardUrl("/login/success")
                .failureForwardUrl("/login/fail");
    }
}
