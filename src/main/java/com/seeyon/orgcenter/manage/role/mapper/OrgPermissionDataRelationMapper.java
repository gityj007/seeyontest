package com.seeyon.orgcenter.manage.role.mapper;

import com.seeyon.orgcenter.common.basemapper.BaseMapper;
import com.seeyon.orgcenter.manage.account.entity.OrgAccount;
import com.seeyon.orgcenter.manage.role.entity.OrgPermissionDataRelation;
import com.seeyon.orgcenter.manage.role.entity.OrgRole;
import com.seeyon.orgcenter.manage.tree.entity.OrgTree;
import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@ApiModel("角色data权限")
@Mapper
public interface OrgPermissionDataRelationMapper extends BaseMapper<OrgPermissionDataRelation> {
	/**
	 * 查询组织by角色
	 * @param AppId
	 * @param RoleID
	 * @return
	 */
	List<OrgTree> getOrgTreeByRoleID(@Param(value = "AppId") Long AppId,@Param(value = "RoleID") Long RoleID);


	/**
	 * 查询角色by组织
	 * @param AppId
	 * @param OrgID
	 * @return
	 */
	List<OrgRole> getRoleByOrgTree(@Param(value = "AppId") Long AppId,@Param(value = "OrgID") Long OrgID);
}
