package com.lkker.authentication.model.entity;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @Author liliang
 * @Date 2020/6/28 14:21
 * @Description
 **/
public class AuthPermissionGroup {

    @Id
    private String id;

    private String name;

    private String description;

    @ManyToMany
    private List<AuthPermission> authPermissions;

}