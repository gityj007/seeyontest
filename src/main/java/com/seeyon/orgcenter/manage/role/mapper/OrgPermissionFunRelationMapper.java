package com.seeyon.orgcenter.manage.role.mapper;

import com.seeyon.orgcenter.manage.function.entity.OrgFunction;
import com.seeyon.orgcenter.manage.role.entity.OrgPermissionFunRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seeyon.orgcenter.manage.role.entity.OrgRole;
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
public interface OrgPermissionFunRelationMapper extends BaseMapper<OrgPermissionFunRelation> {
	/**
	 * 查询角色byroleid
	 * @param AppId
	 * @param RoleID
	 * @return
	 */
	List<OrgFunction> getFunctionByRoleID(@Param(value = "AppId") Long AppId,@Param(value = "RoleID") Long RoleID);


	/**
	 * 查询角色byaccountid
	 * @param AppId
	 * @param FunID
	 * @return
	 */
	List<OrgRole> getRolesByFunID(@Param(value = "AppId") Long AppId,@Param(value = "FunID") Long FunID);

}
