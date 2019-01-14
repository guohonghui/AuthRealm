package com.org.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页工具
 */
@Data
public class PageUtil <T>{

  @ApiModelProperty(value = "当前页")
  private int curPageNo=1;

  @ApiModelProperty(value = "总页数")
  private int pageCount;

  @ApiModelProperty(value = "每页大小 默认5")
  private int pageSize=5;

  @ApiModelProperty(value = "上一页")
  private int upPageNo;

  @ApiModelProperty(value = "下一页")
  private int nextPageNo;

  @ApiModelProperty(value = "开始页")
  private int startPage;

  private T t;

  public int getCurPageNo() {
    return curPageNo;
  }

  public void setCurPageNo(int curPageNo) {
    if(curPageNo<=0){
      this.curPageNo=1;
    }
    if(curPageNo!=1&&curPageNo>0){
      upPageNo=curPageNo-1;
    }
    nextPageNo=curPageNo+1;
    this.curPageNo = curPageNo;
    this.startPage=(curPageNo-1)*pageSize;
  }

  public int getPageCount() {
    return pageCount;
  }

  public void setPageCount(int pageCount) {
    if(pageCount%pageSize>0){
      this.pageCount=pageCount/pageSize+1;
    }else {
      this.pageCount = pageCount/pageSize;
    }
  }

}
