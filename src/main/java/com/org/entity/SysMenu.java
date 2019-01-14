package com.org.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class SysMenu implements Serializable {

    private static final long serialVersionUID = -560397834107370163L;

    @ApiModelProperty(value = "Id")
    private String id;

    @ApiModelProperty(value = "菜单名")
    private String name;

    @ApiModelProperty(value = "父Id")
    private String pId;

    @ApiModelProperty(value = "url")
    private String url;

    @ApiModelProperty(value = "排序")
    private Integer orderNum;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "更新人")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    @ApiModelProperty(value = "权限标识")
    private String permission;

    @ApiModelProperty(value = "菜单类型")
    private Byte menuType;

    @ApiModelProperty(value = "菜单排序id 填充菜单展示id")
    private int num;

    @ApiModelProperty(value = "角色集合")
    private List<SysRole> roleList;

    @ApiModelProperty(value = "子菜单")
    private List<SysMenu> children=new ArrayList<>();

    public void addChild(SysMenu sysMenu){
        children.add(sysMenu);
    }
}