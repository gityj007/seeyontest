package com.seeyon.orgcenter.manage.function.service;

import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.manage.function.entity.OrgFunction;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  菜单服务的interface
 * </p>
 *
 * @author gouyu
 * @since 2020-10-12
 */
public interface IOrgFunctionService extends IService<OrgFunction> {
	/**
	 *菜单的新增
	 */
	void add(OrgFunction orgFunction);
	/**
	 *通过id查询菜单
	 */
	OrgFunction getFunctionEntity(Long id);
	/**
	 *查询所有菜单
	 */
	List<OrgFunction> getList();
	/**
	 *根据id删除菜单
	 */
	void delete(Long id);
	/**
	 *根据id更新菜单
	 */
	void updata(OrgFunction orgFunction);
	/**
	 *多个id删除多个菜单
	 */
	void deleteAll(List<Long> ids);
}
