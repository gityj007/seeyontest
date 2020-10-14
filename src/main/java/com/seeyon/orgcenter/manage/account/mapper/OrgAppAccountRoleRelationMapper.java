package com.seeyon.orgcenter.manage.account.mapper;

import com.seeyon.orgcenter.common.basemapper.BaseMapper;
import com.seeyon.orgcenter.manage.account.entity.OrgAccount;
import com.seeyon.orgcenter.manage.account.entity.OrgAppAccountRoleRelation;
import com.seeyon.orgcenter.manage.role.entity.OrgRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface OrgAppAccountRoleRelationMapper extends BaseMapper<OrgAppAccountRoleRelation> {

    /**
     * 查询账户byroleid
     * @param AppId
     * @param RoleID
     * @return
     */
    List<OrgAccount> getAccountsByRoleID(Long AppId,Long RoleID);


    /**
     * 查询角色byaccountid
     * @param AppId
     * @param AccountID
     * @return
     */
    List<OrgRole> getRolesByAccountID(Long AppId,Long AccountID);


    /**
     * 获取角色通过账号及分组
     *
     * @param AccountId
     * @param AppId
     * @param DoMain
     * @return
     */
    List<OrgRole> getRolesByAccDomain(Long AccountId,Long AppId,String DoMain);

}
