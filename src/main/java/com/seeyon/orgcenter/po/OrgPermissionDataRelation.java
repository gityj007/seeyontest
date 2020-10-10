package com.seeyon.orgcenter.po;

import java.io.Serializable;

/**
 * (OrgPermissionDataRelation) 角色数据权限
 *
 * @author yangjian
 * @since 2020-10-10 17:45:30
 */
public class OrgPermissionDataRelation implements Serializable {
    private static final long serialVersionUID = -46361195653981840L;

    private Integer id;

    private Integer appId;

    private String name;

    private Integer orgId;

    private Integer isAvailableChild;

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

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getIsAvailableChild() {
        return isAvailableChild;
    }

    public void setIsAvailableChild(Integer isAvailableChild) {
        this.isAvailableChild = isAvailableChild;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}