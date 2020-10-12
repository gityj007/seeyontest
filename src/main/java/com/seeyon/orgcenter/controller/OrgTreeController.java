package com.seeyon.orgcenter.controller;


import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.manage.role.entity.OrgRole;
import com.seeyon.orgcenter.manage.tree.entity.OrgTree;
import com.seeyon.orgcenter.manage.tree.service.IOrgTreeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@ApiOperation(value="添加或更新组织", notes="添加或更新组织", produces="application/json")
	@RequestMapping(value = "/saveOrUpdateOrgTree",method = RequestMethod.POST)
	public ResultBody saveOrUpdateOrgTree(@RequestBody OrgTree orgTree){
		ResultBody resultBody=ResultBody.success(orgTreeService.saveOrUpdate(orgTree));
		resultBody.setMessage("更新成功");
		return resultBody;
	}

	@ApiOperation(value="删除组织byID", notes="删除组织byID", produces="application/json")
	@ApiImplicitParam(name = "id", value = "组织ID", paramType = "form", required = true, dataType = "long")
	@RequestMapping(value = "/delOrgTreeByID",method = RequestMethod.POST)
	public ResultBody delOrgTreeByID(@RequestParam Long id){
		ResultBody resultBody=ResultBody.success(orgTreeService.removeById(id));
		resultBody.setMessage("删除组织成功");
		return resultBody;
	}


}
