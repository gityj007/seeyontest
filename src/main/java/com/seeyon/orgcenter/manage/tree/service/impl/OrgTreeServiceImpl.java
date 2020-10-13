package com.seeyon.orgcenter.manage.tree.service.impl;

import com.seeyon.orgcenter.dao.DaoSupport;
import com.seeyon.orgcenter.manage.function.entity.OrgFunction;
import com.seeyon.orgcenter.manage.tree.entity.OrgTree;
import com.seeyon.orgcenter.manage.tree.mapper.OrgTreeMapper;
import com.seeyon.orgcenter.manage.tree.service.IOrgTreeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gouyu
 * @since 2020-10-12
 */
@Service
public class OrgTreeServiceImpl extends ServiceImpl<OrgTreeMapper, OrgTree> implements IOrgTreeService {


	@Resource(name = "daoSupport")
	private DaoSupport dao;

	/**
	 * 获取全部的组织
	 */
	@Override
	public List<OrgTree> getList(){
		return (List<OrgTree>)dao.findForList("OrgTreeMapper.findAll", "");
	}
	/**
	 * 根据id获取组织
	 */
	@Override
	public OrgTree getOrgTreeById(Long id){
		return (OrgTree)dao.findForObject("OrgTreeMapper.findById", id);
	}
	/**
	 * 新增组织
	 */
	@Override
	public void add(OrgTree orgTree){
		dao.save("OrgTreeMapper.save", orgTree);
	}
	/**
	 * 更新组织
	 */
	@Override
	public void updata(OrgTree orgTree){
		dao.update("OrgTreeMapper.edit", orgTree);
	}
	/**
	 * 删除组织
	 */
	@Override
	public void delete(Long id){
		dao.update("OrgTreeMapper.delete", id);
	}
	/**
	 * 删除多个组织
	 */
	@Override
	public void deleteAll(List<Long> ids){
		dao.update("OrgTreeMapper.deleteAll", ids);
	}
}
