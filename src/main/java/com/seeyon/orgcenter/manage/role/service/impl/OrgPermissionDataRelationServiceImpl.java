package com.seeyon.orgcenter.manage.role.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.manage.role.entity.OrgPermissionDataRelation;
import com.seeyon.orgcenter.manage.role.entity.OrgPermissionFunRelation;
import com.seeyon.orgcenter.manage.role.mapper.OrgPermissionDataRelationMapper;
import com.seeyon.orgcenter.manage.role.service.IOrgPermissionDataRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  角色数据权限service实现服务
 * </p>
 *
 * @author gouyu
 * @since 2020-10-12
 */
@Service
public class OrgPermissionDataRelationServiceImpl extends ServiceImpl<OrgPermissionDataRelationMapper, OrgPermissionDataRelation> implements IOrgPermissionDataRelationService {
	/**
	 * 角色绑定数据权限
	 *
	 * @param AppId
	 * @param name
	 * @param IsAvailableChild
	 * @param RoleID
	 * @param OrgIDs
	 * @return
	 */
	@Override
	public ResultBody roleBindOrgTree(Long AppId,String name,Integer IsAvailableChild,Long RoleID,List<Long> OrgIDs){
		LambdaQueryWrapper<OrgPermissionDataRelation> orgPermissionDataRelationQueryWrapper=new LambdaQueryWrapper<OrgPermissionDataRelation>();
		orgPermissionDataRelationQueryWrapper.
				eq(OrgPermissionDataRelation::getRoleId,RoleID).
				eq(OrgPermissionDataRelation::getAppId,AppId).
				eq(OrgPermissionDataRelation::getName,name).
				eq(OrgPermissionDataRelation::getIsAvailableChild,IsAvailableChild).
				in(OrgPermissionDataRelation::getOrgId,OrgIDs).
				select(OrgPermissionDataRelation::getOrgId);

		List<Map<String, Object>> maps = listMaps(orgPermissionDataRelationQueryWrapper);

		/**
		 * 移除已存在绑定的
		 */
		OrgIDs.removeIf(OrgID->{
			for(Map<String, Object> map:maps){
				Long buforgId= (Long) map.get("orgId");
				return OrgIDs.indexOf(buforgId)!=-1;
			}
			return false;
		});
		/**
		 * 组装保存数据
		 */
		List<OrgPermissionDataRelation> orgPermissionDataRelations=OrgIDs.stream().map(orgId->{
			OrgPermissionDataRelation orgPermissionDataRelation=new OrgPermissionDataRelation();
			orgPermissionDataRelation.setOrgId(orgId);
			orgPermissionDataRelation.setIsAvailableChild(IsAvailableChild);
			orgPermissionDataRelation.setRoleId(RoleID);
			orgPermissionDataRelation.setAppId(AppId);
			orgPermissionDataRelation.setName(name);
			return orgPermissionDataRelation;
		}).collect(Collectors.toList());
		return ResultBody.success(saveBatch(orgPermissionDataRelations));
	}

	/**
	 * 数据权限绑定角色
	 *
	 * @param AppId
	 * @param name
	 * @param IsAvailableChild
	 * @param OrgID
	 * @param RoleIDs
	 * @return
	 */
	@Override
	public ResultBody orgTreeBindRole(Long AppId,String name,int IsAvailableChild,Long OrgID,List<Long> RoleIDs){
		LambdaQueryWrapper<OrgPermissionDataRelation> orgPermissionDataRelationQueryWrapper=new LambdaQueryWrapper<OrgPermissionDataRelation>();
		orgPermissionDataRelationQueryWrapper.
				eq(OrgPermissionDataRelation::getOrgId,OrgID).
				eq(OrgPermissionDataRelation::getAppId,AppId).
				eq(OrgPermissionDataRelation::getName,name).
				eq(OrgPermissionDataRelation::getIsAvailableChild,IsAvailableChild).
				in(OrgPermissionDataRelation::getRoleId,RoleIDs).
				select(OrgPermissionDataRelation::getRoleId);

		List<Map<String, Object>> maps = listMaps(orgPermissionDataRelationQueryWrapper);

		/**
		 * 移除已存在绑定的
		 */
		RoleIDs.removeIf(RoleID->{
			for(Map<String, Object> map:maps){
				Long bufroleId= (Long) map.get("roleId");
				return RoleIDs.indexOf(bufroleId)!=-1;
			}
			return false;
		});
		/**
		 * 组装保存数据
		 */
		List<OrgPermissionDataRelation> orgPermissionDataRelations=RoleIDs.stream().map(roleId->{
			OrgPermissionDataRelation orgPermissionDataRelation=new OrgPermissionDataRelation();
			orgPermissionDataRelation.setOrgId(OrgID);
			orgPermissionDataRelation.setIsAvailableChild(IsAvailableChild);
			orgPermissionDataRelation.setRoleId(roleId);
			orgPermissionDataRelation.setAppId(AppId);
			orgPermissionDataRelation.setName(name);
			return orgPermissionDataRelation;
		}).collect(Collectors.toList());
		return ResultBody.success(saveBatch(orgPermissionDataRelations));
	}
}
