package com.seeyon.orgcenter.manage.function.mapper;

import com.seeyon.orgcenter.manage.function.entity.OrgFunction;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yangjian
 * @since 2020-10-12
 */
@Mapper
public interface OrgFunctionMapper extends BaseMapper<OrgFunction> {

	/**
	 *菜单的新增
	 */
	void add(OrgFunction orgFunction);
	/**
	 *通过id查询菜单
	 */
	public OrgFunction findById(Long id);
}
