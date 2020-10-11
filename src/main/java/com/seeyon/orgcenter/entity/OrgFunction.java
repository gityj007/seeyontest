package com.seeyon.orgcenter.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
 * @since 2020-10-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="OrgFunction对象", description="")
public class OrgFunction implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private Integer id;

    @TableField("APP_ID")
    private Integer appId;

    @TableField("NAME")
    private String name;

    @TableField("CODE")
    private String code;

    @TableField("URL")
    private String url;

    @TableField("TYPE")
    private Integer type;

    @TableField("PARENT_FUN_ID")
    private Integer parentFunId;

    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

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
    private Integer isDeleted;


}
