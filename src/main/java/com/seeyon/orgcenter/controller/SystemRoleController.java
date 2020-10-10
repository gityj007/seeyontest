package com.seeyon.orgcenter.controller;

import com.seeyon.orgcenter.service.SystemRoleService;
import com.seeyon.orgcenter.util.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;

/**
 * @Author 勾瑜
 * @Description: 角色管理的接口
 * @Date 2020-10-10
 */
@Controller
@RestController
@RequestMapping(value="/system/role")
public class SystemRoleController{

	@Resource(name="systemRoleService")
	private SystemRoleService systemRoleService;

	/**
	 * 保存
	 * @param
	 * @throws ParseException
	 */
	@RequestMapping(value="/save", method = RequestMethod.POST)
	@ResponseBody
	public PageResult save(HttpServletRequest request){
		PageResult pageResult = new PageResult();

		return pageResult;
	}
}
