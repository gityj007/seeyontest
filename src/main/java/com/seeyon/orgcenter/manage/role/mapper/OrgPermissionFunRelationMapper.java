package com.seeyon.orgcenter.manage.role.mapper;

import com.seeyon.orgcenter.common.basemapper.BaseMapper;
import com.seeyon.orgcenter.manage.function.entity.OrgFunction;
import com.seeyon.orgcenter.manage.role.entity.OrgPermissionFunRelation;
import com.seeyon.orgcenter.manage.role.entity.OrgRole;
import com.seeyon.orgcenter.manage.tree.entity.OrgTree;
import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@ApiModel("角色fun权限")
@Mapper
public interface OrgPermissionFunRelationMapper extends BaseMapper<OrgPermissionFunRelation> {
	/**
	 * 查询菜单by角色
	 * @param AppId
	 * @param RoleID
	 * @return
	 */
	List<OrgFunction> getFunctionByRoleID(@Param(value = "AppId") Long AppId,@Param(value = "RoleID") Long RoleID);


	/**
	 * 查询角色by菜单
	 * @param AppId
	 * @param FunID
	 * @return
	 */
	List<OrgRole> getRolesByFunID(@Param(value = "AppId") Long AppId,@Param(value = "FunID") Long FunID);
}
