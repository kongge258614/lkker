package com.lkker.authentication.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @Author liliang
 * @Date 2020/6/28 14:19
 * @Description: 角色
 **/
@Data
//@Entity
public class AuthRole {
    @Id
    private String id;

    private String name;

    private String description;

    @ManyToMany
    private List<AuthPermissionGroup> authPermissionGroups;

}
