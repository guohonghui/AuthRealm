package com.org.utils;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 查询返回json格式依照ui默认属性名称
 */
public class ReType implements Serializable{

  private static final long serialVersionUID = 3709999572802980030L;

  @ApiModelProperty(value = "状态")
  public int code=0;

  @ApiModelProperty(value = "状态信息")
  public String msg="";

  @ApiModelProperty(value = "数据总数")
  public long count;

  @ApiModelProperty(value = "泛型集合")
  public List<?> data;

  public ReType(long count, List<?> data) {
    this.count = count;
    this.data = data;
  }
}
