package com.seeyon.orgcenter.manage.role.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

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
@ApiModel(value="OrgRole对象", description="")
public class OrgRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID",type = IdType.AUTO)
    private Long id;

    @TableField("NAME")
    private String name;

    @TableField("CODE")
    private String code;

    @TableField("APP_ID")
    private Long appId;

    @TableField(value = "IS_DELETED",fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDeleted;

    @TableField(value = "IS_ENABLE",fill = FieldFill.INSERT)
    private Integer isEnable;

    @TableField(value = "CREATE_TIME",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "UPDATE_TIME",fill = FieldFill.UPDATE)
    private Date updateTime;

    @TableField("IS_GLOBAL")
    private Integer isGlobal;


}
