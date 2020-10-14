package com.seeyon.orgcenter.manage.function.entity;

import io.swagger.annotations.ApiModel;

import java.util.Date;

@ApiModel("fun")
public class OrgFunction {
    private Long id;

    private Long appId;

    private String name;

    private String code;


    private String url;


    private Integer type;


    private Long parentFunId;

    private Date createTime;


    private Date updateTime;


    private String icon;


    private String path;

    private Integer isShow;


    private Integer isCheck;


    private Integer isControl;


    private Integer shortcut;


    private String shortcutIcon;

    private Integer level;

    private Integer isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    public Long getParentFunId() {
        return parentFunId;
    }

    public void setParentFunId(Long parentFunId) {
        this.parentFunId = parentFunId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getPath() {
        return path;
    }


    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public Integer getIsControl() {
        return isControl;
    }

    public void setIsControl(Integer isControl) {
        this.isControl = isControl;
    }

    public Integer getShortcut() {
        return shortcut;
    }

    public void setShortcut(Integer shortcut) {
        this.shortcut = shortcut;
    }

    public String getShortcutIcon() {
        return shortcutIcon;
    }

    public void setShortcutIcon(String shortcutIcon) {
        this.shortcutIcon = shortcutIcon == null ? null : shortcutIcon.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
