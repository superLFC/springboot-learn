package pers.learn.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.alibaba.fastjson.JSON.toJSON;
import static com.alibaba.fastjson.JSON.toJSONString;
import static org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY;
import static org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY;

@Slf4j
public class PreLoginFilter extends GenericFilterBean {

    private static final String LOGIN_TYPE_KEY = "login_type";


    private RequestMatcher requiresAuthenticationRequestMatcher;
    private Map<LoginTypeEnum, LoginPostProcessor> processors = new HashMap<>();

    public PreLoginFilter(String loginProcessingUrl, Collection<LoginPostProcessor> loginPostProcessors) {
        Assert.notNull(loginProcessingUrl, "loginProcessingUrl must not be null");
        requiresAuthenticationRequestMatcher = new AntPathRequestMatcher(loginProcessingUrl, "POST");
        LoginPostProcessor loginPostProcessor = defaultLoginPostProcessor();
        processors.put(loginPostProcessor.getLoginTypeEnum(), loginPostProcessor);

        if (!CollectionUtils.isEmpty(loginPostProcessors)) {
            loginPostProcessors.forEach(element -> processors.put(element.getLoginTypeEnum(), element));
        }
    }

    private LoginPostProcessor defaultLoginPostProcessor() {
        return new LoginPostProcessor() {
            @Override
            public LoginTypeEnum getLoginTypeEnum() {
                return LoginTypeEnum.NORMAL;
            }

            @Override
            public String obtainUsername(ServletRequest request) {
                return request.getParameter(SPRING_SECURITY_FORM_USERNAME_KEY);
            }

            @Override
            public String obtainPassword(ServletRequest request) {
                return request.getParameter(SPRING_SECURITY_FORM_PASSWORD_KEY);
            }
        };
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(httpServletRequest);
        if (requiresAuthenticationRequestMatcher.matches(httpServletRequest)) {
            requestWrapper.getAuthType();
        }
        chain.doFilter(httpServletRequest, response);
    }
}
