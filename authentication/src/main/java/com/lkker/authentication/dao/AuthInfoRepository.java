package com.lkker.authentication.dao;

import com.lkker.authentication.model.entity.AuthInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

/**
 * @Author liliang
 * @Date 2020/7/4 12:32
 * @Description
 **/
@Component
public interface AuthInfoRepository extends JpaRepository<AuthInfo,String>, JpaSpecificationExecutor<AuthInfo> {

    AuthInfo findAuthInfoById(String id);
}
