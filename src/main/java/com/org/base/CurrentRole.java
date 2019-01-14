package com.org.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CurrentRole {

    @ApiModelProperty(value = "Id")
    private String id;

    @ApiModelProperty(value = "角色名")
    private String roleName;

    @ApiModelProperty(value = "备注")
    private String remark;

    public CurrentRole(String id, String roleName, String remark) {
        this.id = id;
        this.roleName = roleName;
        this.remark = remark;
    }
}
