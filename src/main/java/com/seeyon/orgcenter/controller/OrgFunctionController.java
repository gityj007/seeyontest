package com.seeyon.orgcenter.controller;


import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.manage.function.entity.OrgFunction;
import com.seeyon.orgcenter.manage.function.service.IOrgFunctionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  菜单模块
 * </p>
 *
 * @author gouyu
 * @since 2020-10-12
 */
@RestController
@RequestMapping("/orgcenter/org-function")
@Api("菜单模块")
public class OrgFunctionController {

	@Autowired
	private IOrgFunctionService orgFunctionService;

	@ApiOperation(value="获取所有菜单", notes="获取所有菜单all", produces="application/json")
	@RequestMapping(value = "/getAllOrgFunction",method = RequestMethod.GET)
	public ResultBody getAllOrgFunction(){
		List<OrgFunction> list = orgFunctionService.selectByPrimarySelective(null);
		ResultBody resultBody = ResultBody.success(list);
		resultBody.setMsg("查询成功");
		return resultBody;
	}


	@ApiOperation(value="获取菜单", notes="获取菜单byID", produces="application/json")
	@ApiImplicitParam(name = "id", value = "菜单ID", paramType = "query", required = true, dataType = "long")
	@RequestMapping(value = "/getOrgFunctionByID",method = RequestMethod.GET)
	public ResultBody getOrgFunctionByID(@RequestParam Long id){
		//ResultBody resultBody = ResultBody.success(orgFunctionService.getById(id));
		ResultBody resultBody = ResultBody.success(orgFunctionService.selectByPrimaryKey(id));
		resultBody.setMsg("查询成功");
		return resultBody;
	}


	@ApiOperation(value="菜单的新增", notes="菜单的新增", produces="application/json")
	@RequestMapping(value = "/saveOrUpdateToOrgFunction",method = RequestMethod.POST)
	public ResultBody saveOrUpdate(@RequestBody OrgFunction orgFunction){
		//ResultBody resultBody=ResultBody.success(orgFunctionService.saveOrUpdate(orgFunction));
		if(orgFunction.getId() == null){
			orgFunctionService.insert(orgFunction);
			ResultBody resultBody=ResultBody.success();
			resultBody.setMsg("新增成功");
			return resultBody;
		}else{
			orgFunctionService.updateByPrimaryKeySelective(orgFunction);
			ResultBody resultBody=ResultBody.success();
			resultBody.setMsg("修改成功");
			return resultBody;
		}
	}


	@ApiOperation(value="删除菜单", notes="删除菜单byID", produces="application/json")
	@ApiImplicitParam(name = "id", value = "功能ID", paramType = "form", required = true, dataType = "long")
	@RequestMapping(value = "/delOrgFunction",method = RequestMethod.POST)
	public ResultBody delOrgFunction(@RequestParam Long id){
		//ResultBody resultBody=ResultBody.success(orgFunctionService.removeById(id));
		orgFunctionService.deleteByPrimaryKey(id);
		ResultBody resultBody=ResultBody.success();
		resultBody.setMsg("删除成功");
		return resultBody;
	}


	@ApiOperation(value="删除多个菜单", notes="删除多个菜单byID", produces="application/json")
	@ApiImplicitParam(name = "ids", value = "菜单IDs", paramType = "form", required = true, dataType = "list")
	@RequestMapping(value = "/delMoreOrgFunction",method = RequestMethod.POST)
	public ResultBody delMoreOrgFunction(@RequestParam List<Long> ids){
		//ResultBody resultBody=ResultBody.success(orgFunctionService.removeById(id));
		//orgFunctionService.deleteAll(ids);
		ResultBody resultBody=ResultBody.success();
		resultBody.setMsg("删除成功");
		return resultBody;
	}
}
