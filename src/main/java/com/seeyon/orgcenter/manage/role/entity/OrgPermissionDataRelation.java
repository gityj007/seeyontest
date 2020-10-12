package com.seeyon.orgcenter.manage.role.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangjian
 * @since 2020-10-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="OrgPermissionDataRelation对象", description="")
public class OrgPermissionDataRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID",type = IdType.AUTO)
    private Integer id;

    @TableField("APP_ID")
    private Integer appId;

    @TableField("NAME")
    private String name;

    @TableField("ORG_ID")
    private Integer orgId;

    @TableField("IS_AVAILABLE_CHILD")
    private Integer isAvailableChild;

    @TableField("ROLE_ID")
    private Integer roleId;


}
