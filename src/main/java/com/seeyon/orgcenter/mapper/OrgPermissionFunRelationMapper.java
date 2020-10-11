package com.seeyon.orgcenter.mapper;

import com.seeyon.orgcenter.entity.OrgAccount;
import com.seeyon.orgcenter.entity.OrgFunction;
import com.seeyon.orgcenter.entity.OrgPermissionFunRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seeyon.orgcenter.entity.OrgRole;
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
	List<OrgFunction> getFunctionByRoleID(@Param(value = "AppId") Integer AppId,@Param(value = "RoleID") Integer RoleID);


	/**
	 * 查询角色byaccountid
	 * @param AppId
	 * @param FunID
	 * @return
	 */
	List<OrgFunction> getRolesByFunID(@Param(value = "AppId") Integer AppId,@Param(value = "FunID") Integer FunID);

}
