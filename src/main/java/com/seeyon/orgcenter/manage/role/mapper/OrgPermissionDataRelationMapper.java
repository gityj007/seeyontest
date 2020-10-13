package com.seeyon.orgcenter.manage.role.mapper;

import com.seeyon.orgcenter.manage.function.entity.OrgFunction;
import com.seeyon.orgcenter.manage.role.entity.OrgPermissionDataRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seeyon.orgcenter.manage.role.entity.OrgRole;
import com.seeyon.orgcenter.manage.tree.entity.OrgTree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yangjian
 * @since 2020-10-11
 */
@Mapper
public interface OrgPermissionDataRelationMapper extends BaseMapper<OrgPermissionDataRelation> {

	/**
	 * 查询数据权限
	 * @param AppId
	 * @param RoleID
	 * @return
	 */
	List<OrgTree> getOrgTreeByRoleID(@Param(value = "AppId") Long AppId,@Param(value = "RoleID") Long RoleID);


	/**
	 * 查询角色
	 * @param AppId
	 * @param OrgID
	 * @return
	 */
	List<OrgRole> getRoleByOrgTree(@Param(value = "AppId") Long AppId,@Param(value = "OrgID") Long OrgID);

}
