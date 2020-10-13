package com.seeyon.orgcenter.controller;


import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.manage.role.entity.OrgRole;
import com.seeyon.orgcenter.manage.role.service.IOrgRoleService;
import com.seeyon.orgcenter.manage.tree.entity.OrgTree;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  角色模块
 * </p>
 *
 * @author gouyu
 * @since 2020-10-11
 */
@RestController
@RequestMapping("/orgcenter/org-role")
@Api("角色模块")
public class OrgRoleController {

    @Autowired
    private IOrgRoleService orgRoleService;


	@ApiOperation(value="获取所有角色", notes="获取所有角色All", produces="application/json")
	@RequestMapping(value = "/getAllOrgRole",method = RequestMethod.GET)
	public ResultBody getAllOrgRole(){
		List<OrgRole> list = orgRoleService.getList();
		ResultBody resultBody = ResultBody.success(list);
		resultBody.setMsg("查询成功");
		return resultBody;
	}

	@ApiOperation(value="获取角色", notes="获取角色byID", produces="application/json")
	@ApiImplicitParam(name = "id", value = "角色ID", paramType = "query", required = true, dataType = "long")
	@RequestMapping(value = "/getOrgRoleByID",method = RequestMethod.GET)
	public ResultBody getOrgRoleByID(@RequestParam Long id){
		//ResultBody resultBody = ResultBody.success(orgFunctionService.getById(id));
		ResultBody resultBody = ResultBody.success(orgRoleService.getOrgRoleById(id));
		resultBody.setMsg("查询成功");
		return resultBody;
	}


    @ApiOperation(value="添加或更新角色", notes="添加或更新角色", produces="application/json")
    @RequestMapping(value = "/saveOrUpdateOrgRole",method = RequestMethod.POST)
    public ResultBody saveOrUpdateOrgRole(@RequestBody OrgRole orgRole){
		if(orgRole.getId() == null){
			orgRoleService.add(orgRole);
			ResultBody resultBody=ResultBody.success();
			resultBody.setMsg("新增成功");
			return resultBody;
		}else{
			orgRoleService.updata(orgRole);
			ResultBody resultBody=ResultBody.success();
			resultBody.setMsg("修改成功");
			return resultBody;
		}
    }


    @ApiOperation(value="删除角色byID", notes="删除角色byID", produces="application/json")
    @ApiImplicitParam(name = "id", value = "账号ID", paramType = "form", required = true, dataType = "long")
    @RequestMapping(value = "/delOrgRoleByID",method = RequestMethod.POST)
    public ResultBody delOrgRoleByID(@RequestParam Long id){
		orgRoleService.delete(id);
        ResultBody resultBody=ResultBody.success();
        resultBody.setMsg("删除角色成功");
        return resultBody;
    }

	@ApiOperation(value="删除多个角色", notes="删除多个角色", produces="application/json")
	@ApiImplicitParam(name = "ids", value = "角色IDs", paramType = "form", required = true, dataType = "list")
	@RequestMapping(value = "/delMoreOrgRole",method = RequestMethod.POST)
	public ResultBody delMoreOrgRole(@RequestParam List<Long> ids){
		//ResultBody resultBody=ResultBody.success(orgFunctionService.removeById(id));
		orgRoleService.deleteAll(ids);
		ResultBody resultBody=ResultBody.success();
		resultBody.setMsg("删除多个角色成功");
		return resultBody;
	}

}
