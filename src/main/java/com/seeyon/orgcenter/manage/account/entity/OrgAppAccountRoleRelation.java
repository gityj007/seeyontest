package com.seeyon.orgcenter.manage.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
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
@ApiModel(value="OrgAppAccountRoleRelation对象", description="")
public class OrgAppAccountRoleRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID",type = IdType.AUTO)
    private Long id;

    @TableField("ACCOUNT_ID")
    private Long accountId;

    @TableField("ROLE_ID")
    private Long roleId;

    @TableField("DOMAIN")
    private String domain;

    @TableField("APP_ID")
    private Long appId;


}
