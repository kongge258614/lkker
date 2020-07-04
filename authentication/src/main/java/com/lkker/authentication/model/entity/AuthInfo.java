package com.lkker.authentication.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author liliang
 * @Date 2020/6/28 13:58
 * @Description:用户表
 **/
@Entity
@Data
@NoArgsConstructor
public class AuthInfo {

    @Id
    private String id;

    private String password;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean credentialsNonExpired;

    private Boolean enabled;

//    @ManyToMany
//    protected List<AuthRoleGroup> authRoleGroups;
}
