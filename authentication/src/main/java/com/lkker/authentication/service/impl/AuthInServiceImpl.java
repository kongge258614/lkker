package com.lkker.authentication.service.impl;

import com.lkker.authentication.dao.AuthInfoRepository;
import com.lkker.authentication.exception.UsernameIsExitedException;
import com.lkker.authentication.model.entity.AuthInfo;
import com.lkker.authentication.service.AuthInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author liliang
 * @Date 2020/7/4 16:50
 * @Description
 **/
@Service
public class AuthInServiceImpl implements AuthInService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthInfoRepository authInfoRepository;

    @Transactional
    @Override
    public void signup(AuthInfo authInfo) {
        AuthInfo bizUser = authInfoRepository.findAuthInfoById(authInfo.getId());
        if(null != bizUser){
            throw new UsernameIsExitedException("用户已经存在");
        }
        authInfo.setPassword(passwordEncoder.encode(authInfo.getPassword()));
        authInfo.setEnabled(true);
        authInfo.setAccountNonExpired(true);
        authInfo.setAccountNonLocked(true);
        authInfo.setCredentialsNonExpired(true);
        authInfoRepository.save(authInfo);
    }
}
