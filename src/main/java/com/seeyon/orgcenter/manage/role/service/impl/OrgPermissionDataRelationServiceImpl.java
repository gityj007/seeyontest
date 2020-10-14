package com.seeyon.orgcenter.manage.role.service.impl;

import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.common.baseservice.impl.BaseServiceImpl;
import com.seeyon.orgcenter.manage.function.entity.OrgFunction;
import com.seeyon.orgcenter.manage.role.entity.OrgPermissionDataRelation;
import com.seeyon.orgcenter.manage.role.entity.OrgPermissionFunRelation;
import com.seeyon.orgcenter.manage.role.entity.OrgRole;
import com.seeyon.orgcenter.manage.role.mapper.OrgPermissionDataRelationMapper;
import com.seeyon.orgcenter.manage.role.service.IOrgPermissionDataRelationService;
import com.seeyon.orgcenter.manage.tree.entity.OrgTree;
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
public class OrgPermissionDataRelationServiceImpl extends BaseServiceImpl<OrgPermissionDataRelationMapper, OrgPermissionDataRelation> implements IOrgPermissionDataRelationService {
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
		/*LambdaQueryWrapper<OrgPermissionDataRelation> orgPermissionDataRelationQueryWrapper=new LambdaQueryWrapper<OrgPermissionDataRelation>();
		orgPermissionDataRelationQueryWrapper.
				eq(OrgPermissionDataRelation::getRoleId,RoleID).
				eq(OrgPermissionDataRelation::getAppId,AppId).
				eq(OrgPermissionDataRelation::getName,name).
				eq(OrgPermissionDataRelation::getIsAvailableChild,IsAvailableChild).
				in(OrgPermissionDataRelation::getOrgId,OrgIDs).
				select(OrgPermissionDataRelation::getOrgId);

		List<Map<String, Object>> maps = listMaps(orgPermissionDataRelationQueryWrapper);*/

		/**
		 * 移除已存在绑定的
		 */
		/*OrgIDs.removeIf(OrgID->{
			for(Map<String, Object> map:maps){
				Long buforgId= (Long) map.get("orgId");
				return OrgIDs.indexOf(buforgId)!=-1;
			}
			return false;
		});*/
		/**
		 * 组装保存数据
		 */
		/*List<OrgPermissionDataRelation> orgPermissionDataRelations=OrgIDs.stream().map(orgId->{
			OrgPermissionDataRelation orgPermissionDataRelation=new OrgPermissionDataRelation();
			orgPermissionDataRelation.setOrgId(orgId);
			orgPermissionDataRelation.setIsAvailableChild(IsAvailableChild);
			orgPermissionDataRelation.setRoleId(RoleID);
			orgPermissionDataRelation.setAppId(AppId);
			orgPermissionDataRelation.setName(name);
			return orgPermissionDataRelation;
		}).collect(Collectors.toList());
		return ResultBody.success(saveBatch(orgPermissionDataRelations));*/
		return null;
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
		/*LambdaQueryWrapper<OrgPermissionDataRelation> orgPermissionDataRelationQueryWrapper=new LambdaQueryWrapper<OrgPermissionDataRelation>();
		orgPermissionDataRelationQueryWrapper.
				eq(OrgPermissionDataRelation::getOrgId,OrgID).
				eq(OrgPermissionDataRelation::getAppId,AppId).
				eq(OrgPermissionDataRelation::getName,name).
				eq(OrgPermissionDataRelation::getIsAvailableChild,IsAvailableChild).
				in(OrgPermissionDataRelation::getRoleId,RoleIDs).
				select(OrgPermissionDataRelation::getRoleId);

		List<Map<String, Object>> maps = listMaps(orgPermissionDataRelationQueryWrapper);*/

		/**
		 * 移除已存在绑定的
		 */
		/*RoleIDs.removeIf(RoleID->{
			for(Map<String, Object> map:maps){
				Long bufroleId= (Long) map.get("roleId");
				return RoleIDs.indexOf(bufroleId)!=-1;
			}
			return false;
		});*/
		/**
		 * 组装保存数据
		 */
		/*List<OrgPermissionDataRelation> orgPermissionDataRelations=RoleIDs.stream().map(roleId->{
			OrgPermissionDataRelation orgPermissionDataRelation=new OrgPermissionDataRelation();
			orgPermissionDataRelation.setOrgId(OrgID);
			orgPermissionDataRelation.setIsAvailableChild(IsAvailableChild);
			orgPermissionDataRelation.setRoleId(roleId);
			orgPermissionDataRelation.setAppId(AppId);
			orgPermissionDataRelation.setName(name);
			return orgPermissionDataRelation;
		}).collect(Collectors.toList());
		return ResultBody.success(saveBatch(orgPermissionDataRelations));*/
		return null;
	}

	/**
	 * 根据角色解除绑定数据权限
	 * @param AppId
	 * @param RoleID
	 * @param OrgIDs
	 * @return
	 */
	@Override
	public ResultBody cancelRoleBindOrgTree(Long AppId,Long RoleID,List<Long> OrgIDs){
		/*LambdaQueryWrapper<OrgPermissionDataRelation> orgPermissionDataRelationQueryWrapper=new LambdaQueryWrapper<OrgPermissionDataRelation>();
		orgPermissionDataRelationQueryWrapper.
				eq(OrgPermissionDataRelation::getAppId,AppId).
				eq(OrgPermissionDataRelation::getRoleId,RoleID)
				.in(OrgPermissionDataRelation::getOrgId,OrgIDs);
		ResultBody resultBody=ResultBody.success(remove(orgPermissionDataRelationQueryWrapper));
		resultBody.setMsg("删除成功");*/
		return null;
	}


	/**
	 * 根据角色解除绑定数据权限
	 * @param AppId
	 * @param OrgID
	 * @param RoleIDs
	 * @return
	 */
	@Override
	public ResultBody cancelOrgTreeBindRole(Long AppId,Long OrgID,List<Long> RoleIDs){
		/*LambdaQueryWrapper<OrgPermissionDataRelation> orgPermissionDataRelationQueryWrapper=new LambdaQueryWrapper<OrgPermissionDataRelation>();
		orgPermissionDataRelationQueryWrapper.
				eq(OrgPermissionDataRelation::getAppId,AppId).
				eq(OrgPermissionDataRelation::getOrgId,OrgID)
				.in(OrgPermissionDataRelation::getRoleId,RoleIDs);
		ResultBody resultBody=ResultBody.success(remove(orgPermissionDataRelationQueryWrapper));
		resultBody.setMsg("删除成功");*/
		return null;
	}

	/**
	 * 根据角色获取数据权限
	 * @param AppId
	 * @param RoleID
	 * @return
	 */
	@Override
	public ResultBody getOrgTreeByRoleID(Long AppId,Long RoleID){
		/*List<OrgTree> orgTree = getBaseMapper().getOrgTreeByRoleID(AppId, RoleID);
		ResultBody resultBody=ResultBody.success(orgTree);
		resultBody.setMsg("查询成功");*/
		return null;
	}

	/**
	 * 根据权限获取角色信息
	 * @param AppId
	 * @param OrgID
	 * @return
	 */
	@Override
	public ResultBody getRoleByOrgTree(Long AppId,Long OrgID){
		/*List<OrgRole> orgRole = getBaseMapper().getRoleByOrgTree(AppId, OrgID);
		ResultBody resultBody=ResultBody.success(orgRole);
		resultBody.setMsg("查询成功");*/
		return null;
	}
}
