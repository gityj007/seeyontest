package com.seeyon.orgcenter.controller;


import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.manage.account.entity.OrgAccount;
import com.seeyon.orgcenter.manage.account.service.IOrgAccountService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  账号模块
 * </p>
 *
 * @author yangjian
 * @since 2020-10-11
 */
@RestController
@RequestMapping("/orgcenter/org-account")
@Api("账号模块")
public class OrgAccountController {
    @Autowired
    private IOrgAccountService orgAccountService;


    @ApiOperation(value="获取所有账号", notes="获取所有账号", produces="application/json")
    @RequestMapping(value = "/getAllOrgAccount",method = RequestMethod.GET)
    public ResultBody getAllOrgAccount(){
        return ResultBody.success(orgAccountService.list());
    }

    @ApiOperation(value="获取账号byID", notes="获取账号byID", produces="application/json")
    @ApiImplicitParam(name = "id", value = "账号ID", paramType = "query", required = true, dataType = "long")
    @RequestMapping(value = "/getOrgAccountByID",method = RequestMethod.GET)
    public ResultBody getOrgAccountByID(@RequestParam Long id){
        ResultBody resultBody = ResultBody.success(orgAccountService.getById(id));
        resultBody.setMessage("查询成功");
        return resultBody;
    }



    @ApiOperation(value="添加或更新账号", notes="添加或更新账号", produces="application/json")
    @RequestMapping(value = "/saveOrUpdateOrgAccount",method = RequestMethod.POST)
    public ResultBody saveOrUpdateOrgAccount(@RequestBody OrgAccount orgAccount){
        //密码加密
        if(orgAccount.getId()==null){
            String passCode =orgAccountService.passEncryption("",orgAccount.getCredentialValue());
            orgAccount.setCredentialValue(passCode );
        }
        ResultBody resultBody=ResultBody.success(orgAccountService.saveOrUpdate(orgAccount));
        resultBody.setMessage("更新成功");
        return resultBody;
    }

    @ApiOperation(value="批量添加账号", notes="批量添加账号", produces="application/json")
    @RequestMapping(value = "/saveOrgAccountBatch",method = RequestMethod.POST)
    public ResultBody insertOrgAccountBatch(@RequestBody List<OrgAccount> orgAccounts){
        //密码加密
        orgAccounts.stream().peek(orgAccount->{
            String passCode =orgAccountService.passEncryption("",orgAccount.getCredentialValue());
            orgAccount.setCredentialValue( passCode );
        }).collect(Collectors.toList());


        ResultBody resultBody=ResultBody.success(orgAccountService.saveBatch(orgAccounts));
        resultBody.setMessage("批量添加账号成功");
        return resultBody;
    }

    @ApiOperation(value="删除账号byID", notes="删除账号byID", produces="application/json")
    @ApiImplicitParam(name = "id", value = "账号ID", paramType = "form", required = true, dataType = "long")
    @RequestMapping(value = "/delOrgAccountByID",method = RequestMethod.POST)
    public ResultBody delOrgAccountByID(@RequestParam Long id){
        ResultBody resultBody=ResultBody.success(orgAccountService.removeById(id));
        resultBody.setMessage("删除成功");
        return resultBody;
    }

    @ApiOperation(value="更新密码byID", notes="更新密码byID", produces="application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "账号ID", paramType = "form", required = true, dataType = "long"),
            @ApiImplicitParam(name = "Pass", value = "密码", paramType = "form", required = true, dataType = "String")
    })
    @RequestMapping(value = "/updatePassById",method = RequestMethod.POST)
    public ResultBody updatePassById(@RequestParam Long id,@RequestParam String Pass){
        orgAccountService.updatePass(id,Pass);
        ResultBody resultBody=ResultBody.success(null);
        resultBody.setMessage("密码更新成功");
        return resultBody;
    }



}
