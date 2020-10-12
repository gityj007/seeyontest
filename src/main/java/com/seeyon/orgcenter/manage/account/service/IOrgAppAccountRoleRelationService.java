package com.seeyon.orgcenter.manage.account.service;

import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.manage.account.entity.OrgAppAccountRoleRelation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangjian
 * @since 2020-10-11
 */
public interface IOrgAppAccountRoleRelationService extends IService<OrgAppAccountRoleRelation> {
    /**
     * 人员绑定角色
     * @param AppId
     * @param AccountId
     * @param RoleIDs
     * @return
     */
    ResultBody accountBindRole(Long AppId,Long AccountId, List<Long> RoleIDs);

    /**
     * 角色绑定人员
     * @param AppId
     * @param RoleID
     * @param AccountIds
     * @return
     */
    ResultBody roleBindAccount(Long AppId,Long RoleID, List<Long> AccountIds);

    /**
     * 通过账号解除绑定角色
     * @param AppId
     * @param AccountId
     * @param RoleIDs
     * @return
     */
    ResultBody cancelAccountBindRole(Long AppId,Long AccountId,List<Long> RoleIDs);

    /**
     * 通过账号解除绑定角色
     * @param AppId
     * @param RoleID
     * @param AccountIds
     * @return
     */
    ResultBody cancelRoleBindAccount( Long AppId,Long RoleID,List<Long> AccountIds);

    /**
     * 查询账号信息通过角色Id
     * @param AppId
     * @param RoleID
     * @return
     */
    ResultBody getAccountsByRoleID( Long AppId, Long RoleID);

    /**
     * 通过账号得到角色信息
     * @param AppId
     * @param AccountID
     * @return
     */
    ResultBody getRolesByAccountID( Long AppId,  Long AccountID);
}
