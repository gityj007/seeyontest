package com.seeyon.orgcenter.service.impl;

import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.entity.OrgAppAccountRoleRelation;
import com.seeyon.orgcenter.mapper.OrgAppAccountRoleRelationMapper;
import com.seeyon.orgcenter.service.IOrgAppAccountRoleRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
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
    public ResultBody accountBindRole(Integer AccountId, List<Integer> RoleIDs) {


        return null;
    }
}
