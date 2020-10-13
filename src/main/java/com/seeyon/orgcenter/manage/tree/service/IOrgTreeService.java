package com.seeyon.orgcenter.manage.tree.service;

import com.seeyon.orgcenter.manage.function.entity.OrgFunction;
import com.seeyon.orgcenter.manage.tree.entity.OrgTree;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  组织服务interface类
 * </p>
 *
 * @author gouyu
 * @since 2020-10-12
 */
public interface IOrgTreeService extends IService<OrgTree> {
	/**
	 * 获取全部的组织
	 */
	List<OrgTree> getList();
	/**
	 * 根据id获取组织
	 */
	OrgTree getOrgTreeById(Long id);
	/**
	 * 新增组织
	 */
	void add(OrgTree orgTree);
	/**
	 * 修改组织
	 */
	void updata(OrgTree orgTree);
	/**
	 * 删除组织
	 */
	void delete(Long id);
	/**
	 * 删除多个组织
	 */
	void deleteAll(List<Long> ids);
}
