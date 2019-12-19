package pers.learn.security.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pers.learn.security.security.MyInMemoryUserDetailsManager;

/**
 * 自定义安全策略
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyInMemoryUserDetailsManager myInMemoryUserDetailsManager;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myInMemoryUserDetailsManager);
    }
}
