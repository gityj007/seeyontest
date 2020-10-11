package com.seeyon.orgcenter.controller;


import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.entity.OrgAccount;
import com.seeyon.orgcenter.entity.OrgRole;
import com.seeyon.orgcenter.service.IOrgAccountService;
import com.seeyon.orgcenter.service.IOrgRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  角色模块
 * </p>
 *
 * @author yangjian
 * @since 2020-10-11
 */
@RestController
@RequestMapping("/orgcenter/org-role")
@Api("角色模块")
public class OrgRoleController {

    @Autowired
    private IOrgRoleService orgRoleService;


    @ApiOperation(value="添加或更新角色", notes="添加或更新角色", produces="application/json")
    @RequestMapping(value = "/saveOrUpdateOrgAccount",method = RequestMethod.POST)
    public ResultBody saveOrUpdateOrgRole(@RequestBody OrgRole orgRole){
        ResultBody resultBody=ResultBody.success(orgRoleService.saveOrUpdate(orgRole));
        resultBody.setMessage("更新成功");
        return resultBody;
    }

    @ApiOperation(value="批量添加角色", notes="批量添加角色", produces="application/json")
    @RequestMapping(value = "/insertOrgRoleBatch",method = RequestMethod.POST)
    public ResultBody insertOrgRoleBatch(@RequestBody List<OrgRole> orgRoles){
        ResultBody resultBody=ResultBody.success(orgRoleService.saveBatch(orgRoles));
        resultBody.setMessage("批量添加角色成功");
        return resultBody;
    }


    @ApiOperation(value="删除角色byID", notes="删除角色byID", produces="application/json")
    @ApiImplicitParam(name = "id", value = "账号ID", paramType = "form", required = true, dataType = "long")
    @RequestMapping(value = "/delOrgRoleByID",method = RequestMethod.POST)
    public ResultBody delOrgRoleByID(@RequestParam Integer id){
        ResultBody resultBody=ResultBody.success(orgRoleService.removeById(id));
        resultBody.setMessage("删除角色成功");
        return resultBody;
    }

}
