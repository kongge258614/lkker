package com.lkker.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @Author liliang
 * @Date 2020/7/4 10:53
 * @Description
 **/
@Configuration
public class TokenConfig {

    @Bean
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }
}
