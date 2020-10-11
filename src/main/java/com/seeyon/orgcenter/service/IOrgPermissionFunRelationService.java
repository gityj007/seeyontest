package com.seeyon.orgcenter.service;

import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.entity.OrgPermissionFunRelation;
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
public interface IOrgPermissionFunRelationService extends IService<OrgPermissionFunRelation> {

	/**
	 * 角色绑定功能权限
	 * @param RoleId
	 * @param funIDs
	 * @param AppId
	 * @param name
	 * @return
	 */
	ResultBody roleBindfunction(@RequestParam Integer RoleId,@RequestParam List<Integer> funIDs,@RequestParam Integer AppId,@RequestParam String name);

	/**
	 * 角色绑定功能权限
	 * @param AppId
	 * @param funID
	 * @param name
	 * @param RoleIDs
	 * @return
	 */
	ResultBody functionBindRole(Integer AppId,Integer funID,String name,List<Integer> RoleIDs);

	/**
	 * 通过角色解除绑定功能权限
	 * @param AppId
	 * @param RoleID
	 * @param FunIDs
	 * @return
	 */
	ResultBody cancelRoleBindfunction(Integer AppId,Integer RoleID,List<Integer> FunIDs);

	/**
	 * 通过功能解除绑定角色
	 * @param AppId
	 * @param FunID
	 * @param RoleIDs
	 * @return
	 */
	ResultBody cancelFunctionBindRole(Integer AppId,Integer FunID,List<Integer> RoleIDs);

	/**
	 * 查询功能信息通过角色Id
	 * @param AppId
	 * @param RoleID
	 * @return
	 */
	ResultBody getFunctionByRoleID(Integer AppId,Integer RoleID);

	/**
	 * 通过功能得到角色信息
	 * @param AppId
	 * @param FunID
	 * @return
	 */
	ResultBody getRolesByFunID( Integer AppId,  Integer FunID);
}
