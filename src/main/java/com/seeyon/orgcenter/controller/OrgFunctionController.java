package com.seeyon.orgcenter.controller;


import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.manage.function.entity.OrgFunction;
import com.seeyon.orgcenter.manage.function.service.IOrgFunctionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  功能权限模块
 * </p>
 *
 * @author gouyu
 * @since 2020-10-12
 */
@RestController
@RequestMapping("/orgcenter/org-function")
@Api("功能权限模块")
public class OrgFunctionController {

	@Autowired
	private IOrgFunctionService orgFunctionService;

	@ApiOperation(value="获取所有功能权限", notes="获取所有功能权限", produces="application/json")
	@RequestMapping(value = "/getAllOrgFunction",method = RequestMethod.GET)
	public ResultBody getAllOrgFunction(){
		return ResultBody.success(orgFunctionService.list());
	}


	@ApiOperation(value="获取功能byID", notes="获取功能byID", produces="application/json")
	@ApiImplicitParam(name = "id", value = "功能ID", paramType = "query", required = true, dataType = "long")
	@RequestMapping(value = "/getOrgFunctionByID",method = RequestMethod.GET)
	public ResultBody getOrgFunctionByID(@RequestParam Long id){
		ResultBody resultBody = ResultBody.success(orgFunctionService.getById(id));
		resultBody.setMessage("查询成功");
		return resultBody;
	}


	@ApiOperation(value="添加或更新功能", notes="添加或更新功能", produces="application/json")
	@RequestMapping(value = "/saveOrUpdateOrgFunction",method = RequestMethod.POST)
	public ResultBody saveOrUpdateOrgFunction(@RequestBody OrgFunction orgFunction){
		ResultBody resultBody=ResultBody.success(orgFunctionService.saveOrUpdate(orgFunction));
		resultBody.setMessage("更新成功");
		return resultBody;
	}

	@ApiOperation(value="删除功能byID", notes="删除功能byID", produces="application/json")
	@ApiImplicitParam(name = "id", value = "功能ID", paramType = "form", required = true, dataType = "long")
	@RequestMapping(value = "/delOrgFunction",method = RequestMethod.POST)
	public ResultBody delOrgFunction(@RequestParam Long id){
		ResultBody resultBody=ResultBody.success(orgFunctionService.removeById(id));
		resultBody.setMessage("删除成功");
		return resultBody;
	}
}
