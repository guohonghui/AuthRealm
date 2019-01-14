package com.org.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class CurrentUser implements Serializable {

    private static final long serialVersionUID = 1997250457668660710L;

    @ApiModelProperty(value = "Id")
    private String id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "头像")
    private String photo;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "更新人")
    private String updateBy;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    @ApiModelProperty(value = "删除标志")
    private Byte delFlag;

    @ApiModelProperty(value = "菜单集合")
    private List<CurrentMenu> currentMenuList;

    @ApiModelProperty(value = "角色集合")
    private List<CurrentRole> currentRoleList;

    public CurrentUser(String id, String username, Integer age, String email, String photo,
        String realName) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.email = email;
        this.photo = photo;
        this.realName = realName;
    }
}