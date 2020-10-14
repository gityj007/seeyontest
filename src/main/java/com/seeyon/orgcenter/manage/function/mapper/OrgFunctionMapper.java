package com.seeyon.orgcenter.manage.function.mapper;

import com.seeyon.orgcenter.common.basemapper.BaseMapper;
import com.seeyon.orgcenter.manage.function.entity.OrgFunction;
import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;


@ApiModel("fun")
@Mapper
public interface OrgFunctionMapper extends BaseMapper<OrgFunction> {

}
