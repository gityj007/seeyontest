package com.seeyon.orgcenter.manage.role.mapper;

import com.seeyon.orgcenter.common.basemapper.BaseMapper;
import com.seeyon.orgcenter.manage.role.entity.OrgPermissionFunRelation;
import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;


@ApiModel("角色fun权限")
@Mapper
public interface OrgPermissionFunRelationMapper extends BaseMapper<OrgPermissionFunRelation> {

}
