package com.seeyon.orgcenter.service;

import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.entity.OrgAppAccountRoleRelation;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;

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
    ResultBody accountBindRole(Integer AppId,Integer AccountId, List<Integer> RoleIDs);

    /**
     * 角色绑定人员
     * @param AppId
     * @param RoleID
     * @param AccountIds
     * @return
     */
    ResultBody roleBindAccount(Integer AppId,Integer RoleID, List<Integer> AccountIds);

    /**
     * 通过账号解除绑定角色
     * @param AppId
     * @param AccountId
     * @param RoleIDs
     * @return
     */
    ResultBody cancelAccountBindRole(Integer AppId,Integer AccountId,List<Integer> RoleIDs);

    /**
     * 通过账号解除绑定角色
     * @param AppId
     * @param RoleID
     * @param AccountIds
     * @return
     */
    ResultBody cancelRoleBindAccount( Integer AppId,Integer RoleID,List<Integer> AccountIds);

    /**
     * 查询账号信息通过角色Id
     * @param AppId
     * @param RoleID
     * @return
     */
    ResultBody getAccountsByRoleID( Integer AppId, Integer RoleID);

    /**
     * 通过账号得到角色信息
     * @param AppId
     * @param AccountID
     * @return
     */
    ResultBody getRolesByAccountID( Integer AppId,  Integer AccountID);
}
