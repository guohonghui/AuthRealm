package com.org.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CurrentMenu {

    @ApiModelProperty(value = "Id")
    private String id;

    @ApiModelProperty(value = "菜单名")
    private String name;

    @ApiModelProperty(value = "父Id")
    private String pId;

    @ApiModelProperty(value = "链接")
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

    public CurrentMenu(String id, String name, String pId, String url, Integer orderNum, String icon, String permission, Byte menuType, int num) {
        this.id = id;
        this.name = name;
        this.pId = pId;
        this.url = url;
        this.orderNum = orderNum;
        this.icon = icon;
        this.permission = permission;
        this.menuType = menuType;
        this.num = num;
    }
}
