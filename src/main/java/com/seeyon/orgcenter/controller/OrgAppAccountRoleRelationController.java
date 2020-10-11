package com.seeyon.orgcenter.controller;


import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.service.IOrgAppAccountRoleRelationService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  账号角色关系模块
 * </p>
 *
 * @author yangjian
 * @since 2020-10-11
 */
@RestController
@RequestMapping("/orgcenter/org-app-account-role-relation")
public class OrgAppAccountRoleRelationController {
    @Autowired
    private IOrgAppAccountRoleRelationService  orgAppAccountRoleRelationService;

    @ApiOperation(value="账号绑定角色byID", notes="删除角色byID", produces="application/json")
    @ApiImplicitParam(name = "AccountId", value = "账号ID", paramType = "form", required = true, dataType = "long")
    @RequestMapping(value = "/accountBindRole",method = RequestMethod.POST)
    public ResultBody accountBindRole(@RequestParam Integer AccountId, @RequestParam List<Integer> RoleIDs){
        ResultBody resultBody=orgAppAccountRoleRelationService.accountBindRole(AccountId,RoleIDs);
        return resultBody;
    }

}
