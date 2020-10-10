package com.seeyon.orgcenter.po;

import java.io.Serializable;

/**
 * (OrgAppAccountRoleRelation) 账户角色
 *
 * @author yangjian
 * @since 2020-10-10 17:39:37
 */
public class OrgAppAccountRoleRelation implements Serializable {
    private static final long serialVersionUID = 162955485322165879L;

    private Integer id;

    private Integer accountId;

    private Integer roleId;

    private String domain;

    private Integer appId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

}