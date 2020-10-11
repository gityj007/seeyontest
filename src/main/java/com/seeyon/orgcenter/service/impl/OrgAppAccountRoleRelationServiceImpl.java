package com.seeyon.orgcenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectMaps;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.entity.OrgAppAccountRoleRelation;
import com.seeyon.orgcenter.mapper.OrgAppAccountRoleRelationMapper;
import com.seeyon.orgcenter.service.IOrgAppAccountRoleRelationService;
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
    public ResultBody accountBindRole(Integer AppId,Integer AccountId, List<Integer> RoleIDs) {
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
            return true;
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
    public ResultBody roleBindAccount(Integer AppId,Integer RoleID, List<Integer> AccountIds) {
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
            return true;
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
}
