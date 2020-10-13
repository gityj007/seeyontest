package com.seeyon.orgcenter.manage.function.service.impl;

import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.dao.DaoSupport;
import com.seeyon.orgcenter.manage.function.entity.OrgFunction;
import com.seeyon.orgcenter.manage.function.mapper.OrgFunctionMapper;
import com.seeyon.orgcenter.manage.function.service.IOrgFunctionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  菜单服务实现service类
 * </p>
 *
 * @author gouyu
 * @since 2020-10-12
 */
@Service
public class OrgFunctionServiceImpl extends ServiceImpl<OrgFunctionMapper, OrgFunction> implements IOrgFunctionService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	/**
	 *菜单的新增
	 */
	@Override
	public void add(OrgFunction orgFunction){
		dao.save("OrgFunctionMapper.save", orgFunction);
	}

	/**
	 *获取菜单
	 */
	@Override
	public OrgFunction getFunctionEntity(Long id){
		return (OrgFunction)dao.findForObject("OrgFunctionMapper.findById", id);
	}
	/**
	 *获取所有菜单
	 */
	@Override
	public List<OrgFunction> getList(){
		return (List<OrgFunction>)dao.findForList("OrgFunctionMapper.findAll", "");
	}
	/**
	 *根据id删除菜单
	 */
	@Override
	public void delete(Long id){
		dao.delete("OrgFunctionMapper.delete", id);
	}
	/**
	 *根据id修改菜单
	 */
	@Override
	public void updata(OrgFunction orgFunction){
		dao.update("OrgFunctionMapper.edit", orgFunction);
	}
	/**
	 *删除多个菜单
	 */
	@Override
	public void deleteAll(List<Long> ids){
		dao.delete("OrgFunctionMapper.deleteAll", ids);
	}
}
