package com.org.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 复选框类
 */
@Data
public class Checkbox {

  @ApiModelProperty(value = "Id")
  private String id;

  @ApiModelProperty(value = "菜单名字")
  private String name;

  @ApiModelProperty(value = "默认未选择")
  private boolean check=false;

}
