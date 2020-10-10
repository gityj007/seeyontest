package com.seeyon.orgcenter.service.impl;

import com.seeyon.orgcenter.dao.DaoSupport;
import com.seeyon.orgcenter.service.SystemRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author 勾瑜
 * @Description: 角色管理
 * @Date 2020-10-10
 */
@Service("systemRoleService")
public class SystemRoleServiceImpl implements SystemRoleService{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	/**
	 * 新增
	 * @param pd
	 */
	@Override
	public void save(Map pd){
		dao.save("systemRoleMapper.save", pd);
	}
}
