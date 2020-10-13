package com.seeyon.orgcenter.controller;


import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.manage.role.service.IOrgPermissionFunRelationService;
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
 *  角色菜单模块
 * </p>
 *
 * @author gouyu
 * @since 2020-10-11
 */
@RestController
@RequestMapping("/orgcenter/org-permission-fun-relation")
public class OrgPermissionFunRelationController {
	@Autowired
	private IOrgPermissionFunRelationService orgPermissionFunRelationService;

	@ApiOperation(value="角色绑定菜单byID", notes="角色绑定菜单byID", produces="application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "RoleId", value = "角色ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "name", value = "权限名字", paramType = "form", required = true, dataType = "String"),
			@ApiImplicitParam(name = "funIDs", value = "功能ID", paramType = "form", required = true, dataType = "List")
	})
	@RequestMapping(value = "/roleBindfunction",method = RequestMethod.POST)
	public ResultBody roleBindfunction(@RequestParam Long RoleId,@RequestParam Long AppId,@RequestParam String name,@RequestParam List<Long> funIDs){
		ResultBody resultBody=orgPermissionFunRelationService.roleBindfunction(RoleId,funIDs,AppId,name);
		return resultBody;
	}

	@ApiOperation(value = "菜单绑定角色", notes = "菜单绑定角色", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "funID", value = "功能ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "name", value = "权限名字", paramType = "form", required = true, dataType = "String"),
			@ApiImplicitParam(name = "RoleIDs", value = "角色IDs", paramType = "form", required = true, dataType = "list")
	})
	@RequestMapping(value = "/functionBindRole", method = RequestMethod.POST)
	public ResultBody functionBindRole(@RequestParam Long AppId, @RequestParam Long funID,@RequestParam String name,@RequestParam List<Long> RoleIDs) {
		ResultBody resultBody = orgPermissionFunRelationService.functionBindRole(AppId, funID, name,RoleIDs);
		return resultBody;
	}


	@ApiOperation(value = "通过角色解除绑定菜单", notes = "通过角色解除绑定菜单", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "RoleID", value = "角色ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "FunIDs", value = "功能IDs", paramType = "form", required = true, dataType = "list")
	})
	@RequestMapping(value = "/cancelRoleBindfunction", method = RequestMethod.POST)
	public ResultBody cancelRoleBindfunction(@RequestParam Long AppId, @RequestParam Long RoleID, @RequestParam List<Long> FunIDs) {
		ResultBody resultBody = orgPermissionFunRelationService.cancelRoleBindfunction(AppId, RoleID, FunIDs);
		return resultBody;
	}


	@ApiOperation(value = "通过菜单解除绑定角色", notes = "通过菜单解除绑定角色", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "FunID", value = "功能ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "RoleIDs", value = "角色IDs", paramType = "form", required = true, dataType = "list")
	})
	@RequestMapping(value = "/cancelFunctionBindRole", method = RequestMethod.POST)
	public ResultBody cancelFunctionBindRole(@RequestParam Long AppId, @RequestParam Long FunID, @RequestParam List<Long> RoleIDs) {
		ResultBody resultBody = orgPermissionFunRelationService.cancelFunctionBindRole(AppId, FunID, RoleIDs);
		return resultBody;
	}

	@ApiOperation(value = "通过角色得到菜单信息", notes = "通过角色得到菜单信息", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "query", required = true, dataType = "int"),
			@ApiImplicitParam(name = "RoleID", value = "角色ID", paramType = "query", required = true, dataType = "int"),
	})
	@RequestMapping(value = "/getFunctionByRoleID", method = RequestMethod.GET)
	public ResultBody getFunctionByRoleID(@RequestParam Long AppId, @RequestParam Long RoleID) {
		ResultBody resultBody = orgPermissionFunRelationService.getFunctionByRoleID(AppId, RoleID);
		return resultBody;
	}

	@ApiOperation(value = "通过菜单得到角色信息", notes = "通过菜单得到角色信息", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "query", required = true, dataType = "int"),
			@ApiImplicitParam(name = "FunID", value = "功能ID", paramType = "query", required = true, dataType = "int"),
	})
	@RequestMapping(value = "/getRolesByFunID", method = RequestMethod.GET)
	public ResultBody getRolesByFunID(@RequestParam Long AppId, @RequestParam Long FunID){
		ResultBody resultBody = orgPermissionFunRelationService.getRolesByFunID(AppId, FunID);
		return resultBody;
	}
}
