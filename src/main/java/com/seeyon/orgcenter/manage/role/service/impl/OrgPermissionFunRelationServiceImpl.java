package com.seeyon.orgcenter.manage.role.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.manage.function.entity.OrgFunction;
import com.seeyon.orgcenter.manage.role.entity.OrgPermissionFunRelation;
import com.seeyon.orgcenter.manage.role.entity.OrgRole;
import com.seeyon.orgcenter.manage.role.mapper.OrgPermissionFunRelationMapper;
import com.seeyon.orgcenter.manage.role.service.IOrgPermissionFunRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  角色功能权限服务实现类
 * </p>
 *
 * @author gouyu
 * @since 2020-10-11
 */
@Service
public class OrgPermissionFunRelationServiceImpl extends ServiceImpl<OrgPermissionFunRelationMapper, OrgPermissionFunRelation> implements IOrgPermissionFunRelationService {
	/**
	 * 角色绑定功能权限
	 *
	 * @param RoleId
	 * @param funIDs
	 * @param AppId
	 * @param name
	 * @return
	 */
	@Override
	public ResultBody roleBindfunction(Long RoleId,List<Long> funIDs,Long AppId,String name){
		LambdaQueryWrapper<OrgPermissionFunRelation> orgPermissionFunRelationQueryWrapper=new LambdaQueryWrapper<OrgPermissionFunRelation>();
		orgPermissionFunRelationQueryWrapper.
				eq(OrgPermissionFunRelation::getRoleId,RoleId).
				eq(OrgPermissionFunRelation::getAppId,AppId).
				eq(OrgPermissionFunRelation::getName,name).
				in(OrgPermissionFunRelation::getFunId,funIDs).
				select(OrgPermissionFunRelation::getFunId);

		List<Map<String, Object>> maps = listMaps(orgPermissionFunRelationQueryWrapper);
		/**
		 * 移除已存在绑定的
		 */
		funIDs.removeIf(FunId->{
			for(Map<String, Object> map:maps){
				Long buffunId= (Long) map.get("funId");
				return funIDs.indexOf(buffunId)!=-1;
			}
			return false;
		});
		/**
		 * 组装保存数据
		 */
		List<OrgPermissionFunRelation> orgPermissionFunRelations=funIDs.stream().map(funId->{
			OrgPermissionFunRelation orgPermissionFunRelation=new OrgPermissionFunRelation();
			orgPermissionFunRelation.setFunId(funId);
			orgPermissionFunRelation.setRoleId(RoleId);
			orgPermissionFunRelation.setAppId(AppId);
			orgPermissionFunRelation.setName(name);
			return orgPermissionFunRelation;
		}).collect(Collectors.toList());
		return ResultBody.success(saveBatch(orgPermissionFunRelations));
	}

	/**
	 * 功能权限绑定角色
	 *
	 * @param AppId
	 * @param funID
	 * @param name
	 * @param RoleIDs
	 * @return
	 */
	@Override
	public ResultBody functionBindRole(Long AppId,Long funID,String name,List<Long> RoleIDs){
		LambdaQueryWrapper<OrgPermissionFunRelation> orgPermissionFunRelationQueryWrapper=new LambdaQueryWrapper<OrgPermissionFunRelation>();
		orgPermissionFunRelationQueryWrapper.
				eq(OrgPermissionFunRelation::getFunId,funID).
				eq(OrgPermissionFunRelation::getAppId,AppId).
				eq(OrgPermissionFunRelation::getName,name).
				in(OrgPermissionFunRelation::getRoleId,RoleIDs).
				select(OrgPermissionFunRelation::getRoleId);

		List<Map<String, Object>> maps = listMaps(orgPermissionFunRelationQueryWrapper);
		/**
		 * 移除已存在绑定的
		 */
		RoleIDs.removeIf(RoleID->{
			for(Map<String, Object> map:maps){
				Long bufroleId= (Long) map.get("roleID");
				return RoleIDs.indexOf(bufroleId)!=-1;
			}
			return false;
		});
		/**
		 * 组装保存数据
		 */
		List<OrgPermissionFunRelation> orgPermissionFunRelations=RoleIDs.stream().map(roleID->{
			OrgPermissionFunRelation orgPermissionFunRelation=new OrgPermissionFunRelation();
			orgPermissionFunRelation.setFunId(funID);
			orgPermissionFunRelation.setRoleId(roleID);
			orgPermissionFunRelation.setAppId(AppId);
			orgPermissionFunRelation.setName(name);
			return orgPermissionFunRelation;
		}).collect(Collectors.toList());
		return ResultBody.success(saveBatch(orgPermissionFunRelations));
	}

	/**
	 * 通过账号解除绑定角色
	 *
	 * @param AppId
	 * @param RoleID
	 * @param FunIDs
	 * @return
	 */
	@Override
	public ResultBody cancelRoleBindfunction(Long AppId,Long RoleID,List<Long> FunIDs){
		LambdaQueryWrapper<OrgPermissionFunRelation> orgPermissionFunRelationQueryWrapper=new LambdaQueryWrapper<OrgPermissionFunRelation>();
		orgPermissionFunRelationQueryWrapper.
				eq(OrgPermissionFunRelation::getAppId,AppId).
				eq(OrgPermissionFunRelation::getRoleId,RoleID)
				.in(OrgPermissionFunRelation::getFunId,FunIDs);
		ResultBody resultBody=ResultBody.success(remove(orgPermissionFunRelationQueryWrapper));
		resultBody.setMsg("删除成功");
		return resultBody;
	}

	/**
	 * 通过功能解除绑定角色
	 *
	 * @param AppId
	 * @param FunID
	 * @param RoleIDs
	 * @return
	 */
	@Override
	public ResultBody cancelFunctionBindRole(Long AppId,Long FunID,List<Long> RoleIDs){
		LambdaQueryWrapper<OrgPermissionFunRelation> orgPermissionFunRelationQueryWrapper=new LambdaQueryWrapper<OrgPermissionFunRelation>();
		orgPermissionFunRelationQueryWrapper.
				eq(OrgPermissionFunRelation::getAppId,AppId).
				eq(OrgPermissionFunRelation::getFunId,FunID)
				.in(OrgPermissionFunRelation::getRoleId,RoleIDs);
		ResultBody resultBody=ResultBody.success(remove(orgPermissionFunRelationQueryWrapper));
		resultBody.setMsg("删除成功");
		return resultBody;
	}

	/**
	 * 查询功能信息通过角色Id
	 * @param AppId
	 * @param RoleID
	 * @return
	 */
	@Override
	public ResultBody getFunctionByRoleID(Long AppId,Long RoleID){
		List<OrgFunction> orgFunction = getBaseMapper().getFunctionByRoleID(AppId, RoleID);
		ResultBody resultBody=ResultBody.success(orgFunction);
		resultBody.setMsg("查询成功");
		return resultBody;
	}

	/**
	 * 通过功能得到角色信息
	 *
	 * @param AppId
	 * @param FunID
	 * @return
	 */
	@Override
	public ResultBody getRolesByFunID(Long AppId, Long FunID) {
		List<OrgRole> orgFunction = getBaseMapper().getRolesByFunID(AppId, FunID);
		ResultBody resultBody=ResultBody.success(orgFunction);
		resultBody.setMsg("查询成功");
		return resultBody;
	}

}
