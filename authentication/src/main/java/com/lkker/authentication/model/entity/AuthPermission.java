package com.lkker.authentication.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author liliang
 * @Date 2020/6/28 14:22
 * @Description
 **/

//@Entity
@Data
public class AuthPermission {


    @Id
    private String id;

    /**
     * 目标地址
     */
    @Column(unique = true)
    private String url;

    /**
     * 地址说明
     */
    private String description;

    /**
     * 类型
     */
    private String type;

    /**
     * 是否是开放接口
     */
    private Boolean isPublic;


    /**
     * 是否可以修改
     */
    private Boolean editable;
}
