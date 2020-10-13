package com.seeyon.orgcenter.controller;


import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.manage.role.service.IOrgPermissionDataRelationService;
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
 *  角色数据权限
 * </p>
 *
 * @author gouyu
 * @since 2020-10-12
 */
@RestController
@RequestMapping("/orgcenter/org-permission-data-relation")
@Api(value = "角色数据权限模块")
public class OrgPermissionDataRelationController {
	@Autowired
	private IOrgPermissionDataRelationService orgPermissionDataRelationService;


	@ApiOperation(value = "角色分配数据权限", notes = "角色分配数据权限", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "name", value = "权限名称", paramType = "form", required = true, dataType = "String"),
			@ApiImplicitParam(name = "IsAvailableChild", value = "是否对子节点有效", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "RoleID", value = "角色ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "OrgIDs", value = "权限IDs", paramType = "form", required = true, dataType = "list")
	})
	@RequestMapping(value = "/roleBindOrgTree", method = RequestMethod.POST)
	public ResultBody roleBindOrgTree(@RequestParam Long AppId,@RequestParam String name,@RequestParam int IsAvailableChild,@RequestParam Long RoleID,@RequestParam List<Long> OrgIDs) {
		ResultBody resultBody = orgPermissionDataRelationService.roleBindOrgTree(AppId,name,IsAvailableChild,RoleID, OrgIDs);
		return resultBody;
	}


	@ApiOperation(value = "数据权限绑定角色", notes = "数据权限绑定角色", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "name", value = "权限名称", paramType = "form", required = true, dataType = "String"),
			@ApiImplicitParam(name = "IsAvailableChild", value = "是否对子节点有效", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "OrgID", value = "权限ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "RoleIDs", value = "角色IDs", paramType = "form", required = true, dataType = "list")
	})
	@RequestMapping(value = "/orgTreeBindRole", method = RequestMethod.POST)
	public ResultBody orgTreeBindRole(@RequestParam Long AppId,@RequestParam String name,@RequestParam int IsAvailableChild,@RequestParam Long OrgID,@RequestParam List<Long> RoleIDs) {
		ResultBody resultBody = orgPermissionDataRelationService.orgTreeBindRole(AppId,name,IsAvailableChild,OrgID, RoleIDs);
		return resultBody;
	}


	@ApiOperation(value = "通过角色解除绑定数据权限", notes = "通过角色解除绑定数据权限", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "RoleID", value = "角色ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "OrgIDs", value = "数据IDs", paramType = "form", required = true, dataType = "list")
	})
	@RequestMapping(value = "/cancelRoleBindOrgTree", method = RequestMethod.POST)
	public ResultBody cancelRoleBindOrgTree(@RequestParam Long AppId, @RequestParam Long RoleID, @RequestParam List<Long> OrgIDs) {
		ResultBody resultBody = orgPermissionDataRelationService.cancelRoleBindOrgTree(AppId, RoleID, OrgIDs);
		return resultBody;
	}

	@ApiOperation(value = "通过数据权限解除绑定角色", notes = "通过数据权限解除绑定角色", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "OrgID", value = "数据权限ID", paramType = "form", required = true, dataType = "int"),
			@ApiImplicitParam(name = "RoleIDs", value = "角色IDs", paramType = "form", required = true, dataType = "list")
	})
	@RequestMapping(value = "/cancelOrgTreeBindRole", method = RequestMethod.POST)
	public ResultBody cancelOrgTreeBindRole(@RequestParam Long AppId, @RequestParam Long OrgID, @RequestParam List<Long> RoleIDs) {
		ResultBody resultBody = orgPermissionDataRelationService.cancelOrgTreeBindRole(AppId, OrgID, RoleIDs);
		return resultBody;
	}


	@ApiOperation(value = "通过角色获取权限信息", notes = "通过角色获取权限信息", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "query", required = true, dataType = "int"),
			@ApiImplicitParam(name = "RoleID", value = "角色ID", paramType = "query", required = true, dataType = "int"),
	})
	@RequestMapping(value = "/getOrgTreeByRoleID", method = RequestMethod.GET)
	public ResultBody getOrgTreeByRoleID(@RequestParam Long AppId, @RequestParam Long RoleID) {
		ResultBody resultBody = orgPermissionDataRelationService.getOrgTreeByRoleID(AppId, RoleID);
		return resultBody;
	}


	@ApiOperation(value = "通过角色获取权限信息", notes = "通过角色获取权限信息", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "AppId", value = "应用ID", paramType = "query", required = true, dataType = "int"),
			@ApiImplicitParam(name = "OrgID", value = "权限ID", paramType = "query", required = true, dataType = "int"),
	})
	@RequestMapping(value = "/getRoleByOrgTree", method = RequestMethod.GET)
	public ResultBody getRoleByOrgTree(@RequestParam Long AppId, @RequestParam Long OrgID) {
		ResultBody resultBody = orgPermissionDataRelationService.getRoleByOrgTree(AppId, OrgID);
		return resultBody;
	}
}
