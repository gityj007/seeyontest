package com.seeyon.orgcenter.entity;

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
@ApiModel(value="OrgAccount对象", description="")
public class OrgAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID",type = IdType.AUTO)
    private Integer id;

    @TableField("LOGIN_NAME")
    private String loginName;

    @TableField("CREDENTIAL_VALUE")
    private String credentialValue;

    @TableField("CLASS_NAME")
    private String className;

    @TableField("EXPIRATION_DATE")
    private Date expirationDate;

    @TableField(value = "IS_ENABLE",fill = FieldFill.INSERT)
    private Integer isEnable;

    @TableField(value = "CREATE_TIME",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "UPDATE_TIME",fill = FieldFill.INSERT)
    private Date updateTime;

    @TableField(value = "IS_DELETED",fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDeleted;


}
