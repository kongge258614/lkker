package com.lkker.authentication.service;

import com.lkker.authentication.dao.AuthInfoRepository;
import com.lkker.authentication.model.entity.AuthInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @Author liliang
 * @Date 2020/7/4 12:30
 * @Description
 **/
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthInfoRepository authInfoRepository;
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        AuthInfo authInfo = authInfoRepository.findAuthInfoById(id);
        if(authInfo != null){
            // 处理权限
            return new org.springframework.security.core.userdetails.User(id,authInfo.getPassword(), null);
        }else {
            throw new UsernameNotFoundException("error: " + authInfo.getId() + " do not exist!");
        }
    }
}
