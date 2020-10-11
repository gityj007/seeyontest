package com.seeyon.orgcenter.service;

import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.entity.OrgAppAccountRoleRelation;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangjian
 * @since 2020-10-11
 */
public interface IOrgAppAccountRoleRelationService extends IService<OrgAppAccountRoleRelation> {
    /**
     * 人员绑定角色
     * @param AccountId
     * @param RoleIDs
     * @return
     */
    ResultBody accountBindRole(@RequestParam Integer AccountId, @RequestParam List<Integer> RoleIDs);
}
