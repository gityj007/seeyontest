package com.seeyon.orgcenter.manage.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.manage.account.entity.OrgAccount;
import com.seeyon.orgcenter.manage.account.entity.OrgAppAccountRoleRelation;
import com.seeyon.orgcenter.manage.role.entity.OrgRole;
import com.seeyon.orgcenter.manage.account.mapper.OrgAppAccountRoleRelationMapper;
import com.seeyon.orgcenter.manage.account.service.IOrgAppAccountRoleRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  角色权限Service服务实现类
 * </p>
 *
 * @author yangjian
 * @since 2020-10-11
 */
@Service
public class OrgAppAccountRoleRelationServiceImpl extends ServiceImpl<OrgAppAccountRoleRelationMapper, OrgAppAccountRoleRelation> implements IOrgAppAccountRoleRelationService {

    /**
     * 人员绑定角色
     *
     * @param AccountId
     * @param RoleIDs
     * @return
     */
    @Override
    public ResultBody accountBindRole(Long AppId,Long AccountId, List<Long> RoleIDs) {
        LambdaQueryWrapper<OrgAppAccountRoleRelation> orgAppAccountRoleRelationQueryWrapper = new LambdaQueryWrapper<>();
        orgAppAccountRoleRelationQueryWrapper.
                eq(OrgAppAccountRoleRelation::getAccountId,AccountId).
                eq(OrgAppAccountRoleRelation::getAppId,AppId).
                in(OrgAppAccountRoleRelation::getRoleId,RoleIDs).
                select(OrgAppAccountRoleRelation::getRoleId);

        List<Map<String, Object>> maps = listMaps(orgAppAccountRoleRelationQueryWrapper);

        /**
         * 移除已存在绑定的
         */
        RoleIDs.removeIf(RoleID->{
            for(Map<String, Object> map:maps){
                Long bufRoleID= (Long) map.get("roleId");
                return RoleIDs.indexOf(bufRoleID)!=-1;
            }
            return false;
        });

        /**
         * 组装保存数据
         */
        List<OrgAppAccountRoleRelation> orgAppAccountRoleRelations=RoleIDs.stream().map(RoleID->{
                OrgAppAccountRoleRelation orgAppAccountRoleRelation=new OrgAppAccountRoleRelation();
                orgAppAccountRoleRelation.setAccountId(AccountId);
                orgAppAccountRoleRelation.setRoleId(RoleID);
                orgAppAccountRoleRelation.setAppId(AppId);
                return orgAppAccountRoleRelation;
        }).collect(Collectors.toList());
        return ResultBody.success(saveBatch(orgAppAccountRoleRelations));
    }

    /**
     * 角色绑定人员
     *
     * @param AppId
     * @param RoleID
     * @param AccountIds
     * @return
     */
    @Override
    public ResultBody roleBindAccount(Long AppId,Long RoleID, List<Long> AccountIds) {
        LambdaQueryWrapper<OrgAppAccountRoleRelation> orgAppAccountRoleRelationQueryWrapper = new LambdaQueryWrapper<>();
        orgAppAccountRoleRelationQueryWrapper.
                eq(OrgAppAccountRoleRelation::getRoleId,RoleID).
                eq(OrgAppAccountRoleRelation::getAppId,AppId).
                in(OrgAppAccountRoleRelation::getAccountId,AccountIds).
                select(OrgAppAccountRoleRelation::getAccountId);

        List<Map<String, Object>> maps = listMaps(orgAppAccountRoleRelationQueryWrapper);

        /**
         * 移除已存在绑定的
         */
        AccountIds.removeIf(AccountId->{
            for(Map<String, Object> map:maps){
                Long bufaccountId= (Long) map.get("accountId");
                return AccountIds.indexOf(bufaccountId)!=-1;
            }
            return false;
        });

        /**
         * 组装保存数据
         */
        List<OrgAppAccountRoleRelation> orgAppAccountRoleRelations=AccountIds.stream().map(accountId->{
            OrgAppAccountRoleRelation orgAppAccountRoleRelation=new OrgAppAccountRoleRelation();
            orgAppAccountRoleRelation.setAccountId(accountId);
            orgAppAccountRoleRelation.setRoleId(RoleID);
            orgAppAccountRoleRelation.setAppId(AppId);
            return orgAppAccountRoleRelation;
        }).collect(Collectors.toList());
        return ResultBody.success(saveBatch(orgAppAccountRoleRelations));
    }

    /**
     * 通过账号解除绑定角色
     *
     * @param AppId
     * @param AccountId
     * @param RoleIDs
     * @return
     */
    @Override
    public ResultBody cancelAccountBindRole(Long AppId, Long AccountId, List<Long> RoleIDs) {
        QueryWrapper<OrgAppAccountRoleRelation> orgAppAccountRoleRelationQueryWrapper=new QueryWrapper<OrgAppAccountRoleRelation>();
        orgAppAccountRoleRelationQueryWrapper.
                eq("appId",AppId).
                eq("accountId",AccountId)
                .in("roleId",RoleIDs);
        ResultBody resultBody=ResultBody.success(remove(orgAppAccountRoleRelationQueryWrapper));
        resultBody.setMessage("删除成功");
        return resultBody;
    }

    /**
     * 通过账号解除绑定角色
     *
     * @param AppId
     * @param RoleID
     * @param AccountIds
     * @return
     */
    @Override
    public ResultBody cancelRoleBindAccount(Long AppId, Long RoleID, List<Long> AccountIds) {
        QueryWrapper<OrgAppAccountRoleRelation> orgAppAccountRoleRelationQueryWrapper=new QueryWrapper<OrgAppAccountRoleRelation>();
        orgAppAccountRoleRelationQueryWrapper.
                eq("appId",AppId).
                eq("roleId",RoleID)
                .in("accountId",AccountIds);
        ResultBody resultBody=ResultBody.success(remove(orgAppAccountRoleRelationQueryWrapper));
        resultBody.setMessage("删除成功");
        return resultBody;
    }

    /**
     * 查询账号信息通过角色Id
     *
     * @param AppId
     * @param RoleID
     * @return
     */
    @Override
    public ResultBody getAccountsByRoleID(Long AppId, Long RoleID) {
        List<OrgAccount> OrgAccounts =  getBaseMapper().getAccountsByRoleID(AppId, RoleID);;
        ResultBody resultBody=ResultBody.success(OrgAccounts);
        resultBody.setMessage("查询成功");
        return resultBody;
    }

    /**
     * 通过账号得到角色信息
     *
     * @param AppId
     * @param AccountID
     * @return
     */
    @Override
    public ResultBody getRolesByAccountID(Long AppId, Long AccountID) {
        List<OrgRole> orgRoles = getBaseMapper().getRolesByAccountID(AppId, AccountID);
        ResultBody resultBody=ResultBody.success(orgRoles);
        resultBody.setMessage("查询成功");
        return resultBody;
    }
}
