package com.lkker.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * @Author liliang
 * @Date 2020/7/4 17:25
 * @Description
 **/
@Configuration
@EnableResourceServer
public class ApiServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

        //远程token验证, 普通token必须远程校验
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        //配置去哪里验证token
        tokenServices.setCheckTokenEndpointUrl("http://127.0.0.1:7002/oauth/check_token");

        //配置组件的clientid和密码,这个也是在auth中配置好的
        tokenServices.setClientId("lkker");
        tokenServices.setClientSecret("lkker@123");

        resources
                //设置我这个resource的id, 这个在auth中配置, 这里必须照抄
                .resourceId("api")
                .tokenServices(tokenServices)

                //这个貌似是配置要不要把token信息记录在session中
                .stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.cors().and()
                .httpBasic().and()
                // 由于使用的是JWT，我们这里不需要csrf
                .csrf().disable()
                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .anyRequest().authenticated();  // 所有请求需要身份认证

    }
}
