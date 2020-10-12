package com.seeyon.orgcenter.manage.tree.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
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
 * @author gouyu
 * @since 2020-10-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="OrgTree对象", description="")
public class OrgTree implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @TableField("NAME")
    private String name;

    @TableField("CODE")
    private String code;

    @TableField("IS_GLOBAL")
    private Integer isGlobal;

    @TableField("IS_ENABLE")
    private Integer isEnable;

	@TableField(value = "IS_DELETED",fill = FieldFill.INSERT)
	@TableLogic
    private Integer isDeleted;

    @TableField("PARENT_ORGAN_ID")
    private Integer parentOrganId;

    @TableField("ORGAN_ID")
    private Integer organId;

    @TableField("LEVEL")
    private Integer level;

    @TableField("PATH")
    private String path;

	@TableField(value = "CREATE_TIME",fill = FieldFill.INSERT)
    private Date createTime;

	@TableField(value = "UPDATE_TIME",fill = FieldFill.UPDATE)
    private Date updateTime;

	@TableField(value = "CREATE_USER",fill = FieldFill.INSERT)
    private Integer createUser;


}
