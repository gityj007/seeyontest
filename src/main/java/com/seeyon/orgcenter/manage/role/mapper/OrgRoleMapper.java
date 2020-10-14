package com.seeyon.orgcenter.manage.role.mapper;

import com.seeyon.orgcenter.common.basemapper.BaseMapper;
import com.seeyon.orgcenter.manage.role.entity.OrgRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;


@ApiModel("角色")
@Mapper
public interface OrgRoleMapper extends BaseMapper<OrgRole> {

}
