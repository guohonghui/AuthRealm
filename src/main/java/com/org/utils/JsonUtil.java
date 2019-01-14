package com.org.utils;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ajax 回执
 */
@Data
public class JsonUtil {

  @ApiModelProperty(value = "默认成功")
  private boolean flag=true;

  @ApiModelProperty(value = "msg消息")
  private String msg;

  @ApiModelProperty(value = "状态对象")
  private JSONObject josnObj;

}
