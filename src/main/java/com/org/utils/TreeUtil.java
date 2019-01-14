package com.org.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形工具类
 */
@Data
public class TreeUtil {

    @ApiModelProperty(value = "级数")
    private int layer;

    @ApiModelProperty(value = "Id")
    private String id;

    @ApiModelProperty(value = "菜单名")
    private String name;

    @ApiModelProperty(value = "父Id")
    private String pId;

    @ApiModelProperty(value = "是否开启 默认开启")
    private boolean open=true;

    @ApiModelProperty(value = "是否选择 checkbox状态可用 默认未选中")
    private boolean checked=false;

    @ApiModelProperty(value = "子菜单")
    private List<TreeUtil> children=new ArrayList<>();


}
