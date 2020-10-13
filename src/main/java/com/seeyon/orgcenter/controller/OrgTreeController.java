package com.seeyon.orgcenter.controller;


import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.manage.function.entity.OrgFunction;
import com.seeyon.orgcenter.manage.role.entity.OrgRole;
import com.seeyon.orgcenter.manage.tree.entity.OrgTree;
import com.seeyon.orgcenter.manage.tree.service.IOrgTreeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  组织模块
 * </p>
 *
 * @author gouyu
 * @since 2020-10-12
 */
@RestController
@RequestMapping("/orgcenter/org-tree")
@Api("组织模块")
public class OrgTreeController{
	@Autowired
	private IOrgTreeService orgTreeService;

	@ApiOperation(value="获取所有组织", notes="获取所有组织All", produces="application/json")
	@RequestMapping(value = "/getAllOrgTree",method = RequestMethod.GET)
	public ResultBody getAllOrgTree(){
		List<OrgTree> list = orgTreeService.getList();
		ResultBody resultBody = ResultBody.success(list);
		resultBody.setMsg("查询成功");
		return resultBody;
	}


	@ApiOperation(value="获取组织", notes="获取组织byID", produces="application/json")
	@ApiImplicitParam(name = "id", value = "组织ID", paramType = "query", required = true, dataType = "long")
	@RequestMapping(value = "/getOrgTreeByID",method = RequestMethod.GET)
	public ResultBody getOrgTreeByID(@RequestParam Long id){
		//ResultBody resultBody = ResultBody.success(orgFunctionService.getById(id));
		ResultBody resultBody = ResultBody.success(orgTreeService.getOrgTreeById(id));
		resultBody.setMsg("查询成功");
		return resultBody;
	}

	@ApiOperation(value="添加或更新组织", notes="添加或更新组织", produces="application/json")
	@RequestMapping(value = "/saveOrUpdateOrgTree",method = RequestMethod.POST)
	public ResultBody saveOrUpdateOrgTree(@RequestBody OrgTree orgTree){
		if(orgTree.getId() == null){
			orgTreeService.add(orgTree);
			ResultBody resultBody=ResultBody.success();
			resultBody.setMsg("新增成功");
			return resultBody;
		}else{
			orgTreeService.updata(orgTree);
			ResultBody resultBody=ResultBody.success();
			resultBody.setMsg("修改成功");
			return resultBody;
		}
	}

	@ApiOperation(value="删除组织", notes="删除菜单byID", produces="application/json")
	@ApiImplicitParam(name = "id", value = "功能ID", paramType = "form", required = true, dataType = "long")
	@RequestMapping(value = "/delOrgTree",method = RequestMethod.POST)
	public ResultBody delOrgTree(@RequestParam Long id){
		//ResultBody resultBody=ResultBody.success(orgFunctionService.removeById(id));
		orgTreeService.delete(id);
		ResultBody resultBody=ResultBody.success();
		resultBody.setMsg("删除成功");
		return resultBody;
	}

	@ApiOperation(value="删除多个组织", notes="删除多个组织byID", produces="application/json")
	@ApiImplicitParam(name = "ids", value = "组织IDs", paramType = "form", required = true, dataType = "list")
	@RequestMapping(value = "/delMoreOrgTree",method = RequestMethod.POST)
	public ResultBody delMoreOrgTree(@RequestParam List<Long> ids){
		//ResultBody resultBody=ResultBody.success(orgFunctionService.removeById(id));
		orgTreeService.deleteAll(ids);
		ResultBody resultBody=ResultBody.success();
		resultBody.setMsg("删除成功");
		return resultBody;
	}
}
