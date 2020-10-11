package com.seeyon.orgcenter.controller;


import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.service.IOrgAppAccountRoleRelationService;
import com.seeyon.orgcenter.service.IOrgPermissionFunRelationService;
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
 *  角色权限模块
 * </p>
 *
 * @author yangjian
 * @since 2020-10-11
 */
@RestController
@RequestMapping("/orgcenter/org-permission-fun-relation")
public class OrgPermissionFunRelationController {
	@Autowired
	private IOrgPermissionFunRelationService orgPermissionFunRelationService;

	@ApiOperation(value="角色绑定功能权限byID", notes="角色绑定功能权限byID", produces="application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "RoleId", value = "角色ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "name", value = "权限名字", paramType = "form", required = true, dataType = "String"),
			@ApiImplicitParam(name = "funIDs", value = "功能ID", paramType = "form", required = true, dataType = "List")
	})
	@RequestMapping(value = "/roleBindfunction",method = RequestMethod.POST)
	public ResultBody roleBindfunction(@RequestParam Integer RoleId,@RequestParam Integer AppId,@RequestParam String name,@RequestParam List<Integer> funIDs){
		ResultBody resultBody=orgPermissionFunRelationService.roleBindfunction(RoleId,funIDs,AppId,name);
		return resultBody;
	}

	@ApiOperation(value = "功能权限绑定角色", notes = "功能权限绑定角色", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "funID", value = "功能ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "name", value = "权限名字", paramType = "form", required = true, dataType = "String"),
			@ApiImplicitParam(name = "RoleIDs", value = "角色IDs", paramType = "form", required = true, dataType = "list")
	})
	@RequestMapping(value = "/functionBindRole", method = RequestMethod.POST)
	public ResultBody functionBindRole(@RequestParam Integer AppId, @RequestParam Integer funID,@RequestParam String name,@RequestParam List<Integer> RoleIDs) {
		ResultBody resultBody = orgPermissionFunRelationService.functionBindRole(AppId, funID, name,RoleIDs);
		return resultBody;
	}


	@ApiOperation(value = "通过角色解除绑定功能权限", notes = "通过角色解除绑定功能权限", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "RoleID", value = "角色ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "FunIDs", value = "功能IDs", paramType = "form", required = true, dataType = "list")
	})
	@RequestMapping(value = "/cancelRoleBindfunction", method = RequestMethod.POST)
	public ResultBody cancelRoleBindfunction(@RequestParam Integer AppId, @RequestParam Integer RoleID, @RequestParam List<Integer> FunIDs) {
		ResultBody resultBody = orgPermissionFunRelationService.cancelRoleBindfunction(AppId, RoleID, FunIDs);
		return resultBody;
	}


	@ApiOperation(value = "通过功能权限解除绑定角色", notes = "通过功能权限解除绑定角色", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "FunID", value = "功能ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "RoleIDs", value = "角色IDs", paramType = "form", required = true, dataType = "list")
	})
	@RequestMapping(value = "/cancelFunctionBindRole", method = RequestMethod.POST)
	public ResultBody cancelFunctionBindRole(@RequestParam Integer AppId, @RequestParam Integer FunID, @RequestParam List<Integer> RoleIDs) {
		ResultBody resultBody = orgPermissionFunRelationService.cancelFunctionBindRole(AppId, FunID, RoleIDs);
		return resultBody;
	}

	@ApiOperation(value = "通过角色得到功能信息", notes = "通过角色得到功能信息", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "RoleID", value = "角色ID", paramType = "form", required = true, dataType = "int"),
	})
	@RequestMapping(value = "/getFunctionByRoleID", method = RequestMethod.GET)
	public ResultBody getFunctionByRoleID(@RequestParam Integer AppId, @RequestParam Integer RoleID) {
		ResultBody resultBody = orgPermissionFunRelationService.getFunctionByRoleID(AppId, RoleID);
		return resultBody;
	}

	@ApiOperation(value = "通过功能得到角色信息", notes = "通过功能得到角色信息", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "FunID", value = "功能ID", paramType = "form", required = true, dataType = "int"),
	})
	@RequestMapping(value = "/getRolesByFunID", method = RequestMethod.GET)
	public ResultBody getRolesByFunID(@RequestParam Integer AppId, @RequestParam Integer FunID){
		ResultBody resultBody = orgPermissionFunRelationService.getRolesByFunID(AppId, FunID);
		return resultBody;
	}
}
