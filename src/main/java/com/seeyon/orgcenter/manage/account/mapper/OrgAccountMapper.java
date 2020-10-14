package com.seeyon.orgcenter.manage.account.mapper;

import com.seeyon.orgcenter.common.basemapper.BaseMapper;
import com.seeyon.orgcenter.manage.account.entity.OrgAccount;
import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;

@ApiModel("账号")
@Mapper
public interface OrgAccountMapper  extends BaseMapper<OrgAccount> {

}
