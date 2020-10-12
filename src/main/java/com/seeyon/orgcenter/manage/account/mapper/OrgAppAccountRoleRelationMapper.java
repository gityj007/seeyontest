package com.seeyon.orgcenter.manage.account.mapper;

import com.seeyon.orgcenter.manage.account.entity.OrgAccount;
import com.seeyon.orgcenter.manage.account.entity.OrgAppAccountRoleRelation;
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
public interface OrgAppAccountRoleRelationMapper extends BaseMapper<OrgAppAccountRoleRelation> {

    /**
     * 查询账户byroleid
     * @param AppId
     * @param RoleID
     * @return
     */
    List<OrgAccount> getAccountsByRoleID(@Param(value = "AppId") Long AppId, @Param(value = "RoleID") Long RoleID);


    /**
     * 查询角色byaccountid
     * @param AppId
     * @param AccountID
     * @return
     */
    List<OrgRole> getRolesByAccountID(@Param(value = "AppId") Long AppId, @Param(value = "AccountID") Long AccountID);


    /**
     * 获取角色通过账号及分组
     *
     * @param AccountId
     * @param AppId
     * @param DoMain
     * @return
     */
    List<OrgRole> getRolesByAccDomain(@Param(value = "AccountId") Long AccountId,@Param(value = "AppId") Long AppId,@Param(value = "DoMain") String DoMain);

}
