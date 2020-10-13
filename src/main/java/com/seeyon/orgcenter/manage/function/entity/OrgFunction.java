package com.seeyon.orgcenter.manage.function.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *	菜单对象类
 * </p>
 *
 * @author gouyu
 * @since 2020-10-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="OrgFunction对象", description="")
public class OrgFunction implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value="ID",type = IdType.AUTO)
    private Long id;

    @TableField("APP_ID")
    private Long appId;

    @TableField("NAME")
    private String name;

    @TableField("CODE")
    private String code;

    @TableField("URL")
    private String url;

    @TableField("TYPE")
    private Integer type;

    @TableField("PARENT_FUN_ID")
    private Long parentFunId;

    @TableField(value = "CREATE_TIME",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "UPDATE_TIME",fill = FieldFill.UPDATE)
    private Date updateTime;

    @TableField("ICON")
    private String icon;

    @TableField("PATH")
    private String path;

    @TableField("IS_SHOW")
    private Integer isShow;

    @TableField("IS_CHECK")
    private Integer isCheck;

    @TableField("IS_CONTROL")
    private Integer isControl;

    @TableField("SHORTCUT")
    private Integer shortcut;

    @TableField("SHORTCUT_ICON")
    private String shortcutIcon;

    @TableField("LEVEL")
    private Integer level;

    @TableField("IS_DELETED")
    @TableLogic
    private Integer isDeleted;


}
