package com.seeyon.orgcenter.po;

import java.io.Serializable;

/**
 * (OrgPermissionFunRelation) 角色方法权限实体类
 *
 * @author yangjian
 * @since 2020-10-10 17:46:30
 */
public class OrgPermissionFunRelation implements Serializable {
    private static final long serialVersionUID = -90857466477330145L;

    private Integer id;

    private Integer appId;

    private String name;

    private Integer funId;

    private Integer roleId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFunId() {
        return funId;
    }

    public void setFunId(Integer funId) {
        this.funId = funId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}