package com.org.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SysRoleMenu implements Serializable {

    private static final long serialVersionUID = -6803284444106433417L;

    @ApiModelProperty(value = "角色Id")
    private String roleId;

    @ApiModelProperty(value = "菜单Id")
    private String menuId;

}