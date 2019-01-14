package com.org.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysLog implements Serializable {

    private static final long serialVersionUID = -7734130437507868754L;

    @ApiModelProperty(value = "Id")
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "ip")
    private String ip;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "text")
    private String text;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


}