package com.seeyon.orgcenter.manage.role.service;

import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.manage.role.entity.OrgPermissionDataRelation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  角色数据权限service服务
 * </p>
 *
 * @author gouyu
 * @since 2020-10-12
 */
public interface IOrgPermissionDataRelationService extends IService<OrgPermissionDataRelation> {
	/**
	 * 角色绑定数据权限
	 * @param AppId
	 * @param RoleID
	 * @param OrgIDs
	 * @param name
	 * @param IsAvailableChild
	 * @return
	 */
	ResultBody roleBindOrgTree(Long AppId,String name,Integer IsAvailableChild,Long RoleID,List<Long> OrgIDs);
	/**
	 * 角色绑定数据权限
	 * @param AppId
	 * @param name
	 * @param IsAvailableChild
	 * @param OrgID
	 * @param RoleIDs
	 * @return
	 */
	ResultBody orgTreeBindRole(Long AppId,String name,int IsAvailableChild,Long OrgID,List<Long> RoleIDs);
	/**
	 * 根据角色解除绑定数据权限
	 * @param AppId
	 * @param RoleID
	 * @param OrgIDs
	 * @return
	 */
	ResultBody cancelRoleBindOrgTree(Long AppId,Long RoleID,List<Long> OrgIDs);
	/**
	 * 根据角色解除绑定数据权限
	 * @param AppId
	 * @param OrgID
	 * @param RoleIDs
	 * @return
	 */
	ResultBody cancelOrgTreeBindRole(Long AppId,Long OrgID,List<Long> RoleIDs);
	/**
	 * 根据角色获取数据权限
	 * @param AppId
	 * @param RoleID
	 * @return
	 */
	ResultBody getOrgTreeByRoleID(Long AppId,Long RoleID);
	/**
	 * 根据权限获取角色信息
	 * @param AppId
	 * @param OrgID
	 * @return
	 */
	ResultBody getRoleByOrgTree(Long AppId,Long OrgID);
}
