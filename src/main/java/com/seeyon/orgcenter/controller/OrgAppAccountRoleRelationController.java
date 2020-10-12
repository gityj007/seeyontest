package com.seeyon.orgcenter.controller;


import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.manage.account.service.IOrgAppAccountRoleRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 账号角色关系模块
 * </p>
 *
 * @author yangjian
 * @since 2020-10-11
 */
@RestController
@RequestMapping("/orgcenter/org-app-account-role-relation")
@Api(value = "账号角色关系模块")
public class OrgAppAccountRoleRelationController {
    @Autowired
    private IOrgAppAccountRoleRelationService orgAppAccountRoleRelationService;

    @ApiOperation(value = "账号绑定角色", notes = "账号绑定角色", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
            @ApiImplicitParam(name = "AccountId", value = "账号ID", paramType = "form", required = true, dataType = "int"),
            @ApiImplicitParam(name = "RoleIDs", value = "角色IDs", paramType = "form", required = true, dataType = "list")
    })
    @RequestMapping(value = "/accountBindRole", method = RequestMethod.POST)
    public ResultBody accountBindRole(@RequestParam Long AppId, @RequestParam Long AccountId, @RequestParam List<Long> RoleIDs) {
        ResultBody resultBody = orgAppAccountRoleRelationService.accountBindRole(AppId, AccountId, RoleIDs);
        return resultBody;
    }

    @ApiOperation(value = "角色绑定账号", notes = "角色绑定账号", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
            @ApiImplicitParam(name = "RoleID", value = "角色ID", paramType = "form", required = true, dataType = "int"),
            @ApiImplicitParam(name = "AccountIds", value = "账号IDs", paramType = "form", required = true, dataType = "list")
    })
    @RequestMapping(value = "/roleBindAccount", method = RequestMethod.POST)
    public ResultBody roleBindAccount(@RequestParam Long AppId, @RequestParam Long RoleID, @RequestParam List<Long> AccountIds) {
        ResultBody resultBody = orgAppAccountRoleRelationService.roleBindAccount(AppId, RoleID, AccountIds);
        return resultBody;
    }






    @ApiOperation(value = "通过账号解除绑定角色", notes = "通过账号解除绑定角色", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
            @ApiImplicitParam(name = "AccountId", value = "账号ID", paramType = "form", required = true, dataType = "int"),
            @ApiImplicitParam(name = "RoleIDs", value = "角色IDs", paramType = "form", required = true, dataType = "list")
    })
    @RequestMapping(value = "/cancelAccountBindRole", method = RequestMethod.POST)
    public ResultBody cancelAccountBindRole(@RequestParam Long AppId, @RequestParam Long AccountId, @RequestParam List<Long> RoleIDs) {
        ResultBody resultBody = orgAppAccountRoleRelationService.cancelAccountBindRole(AppId, AccountId, RoleIDs);
        return resultBody;
    }

    @ApiOperation(value = "通过角色解除绑定账号", notes = "通过角色解除绑定账号", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
            @ApiImplicitParam(name = "RoleID", value = "角色ID", paramType = "form", required = true, dataType = "int"),
            @ApiImplicitParam(name = "AccountIds", value = "账号IDs", paramType = "form", required = true, dataType = "list")
    })
    @RequestMapping(value = "/cancelRoleBindAccount", method = RequestMethod.POST)
    public ResultBody cancelRoleBindAccount(@RequestParam Long AppId, @RequestParam Long RoleID, @RequestParam List<Long> AccountIds) {
        ResultBody resultBody = orgAppAccountRoleRelationService.cancelRoleBindAccount(AppId, RoleID, AccountIds);
        return resultBody;
    }




    @ApiOperation(value = "通过角色得到账号信息", notes = "通过角色得到账号信息", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
            @ApiImplicitParam(name = "RoleID", value = "角色ID", paramType = "form", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/getAccountsByRoleID", method = RequestMethod.GET)
    public ResultBody getAccountsByRoleID(@RequestParam Long AppId, @RequestParam Long RoleID) {
        ResultBody resultBody = orgAppAccountRoleRelationService.getAccountsByRoleID(AppId, RoleID);
        return resultBody;
    }


    @ApiOperation(value = "通过账号得到角色信息", notes = "通过账号得到角色信息", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
            @ApiImplicitParam(name = "AccountID", value = "账号ID", paramType = "form", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/getRolesByAccountID", method = RequestMethod.GET)
    public ResultBody getRolesByAccountID(@RequestParam Long AppId, @RequestParam Long AccountID){
        ResultBody resultBody = orgAppAccountRoleRelationService.getRolesByAccountID(AppId, AccountID);
        return resultBody;
    }


}
