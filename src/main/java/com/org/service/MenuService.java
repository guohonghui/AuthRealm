package com.org.service;

import com.alibaba.fastjson.JSONArray;
import com.org.base.BaseService;
import com.org.entity.SysMenu;

import java.util.List;

public interface MenuService extends BaseService<SysMenu,String> {

  List<SysMenu> getMenuNotSuper();

  @Override
  int insert(SysMenu menu);

  @Override
  SysMenu selectByPrimaryKey(String id);

  List<SysMenu> getMenuChildren(String id);

  JSONArray getMenuJson(String roleId);

  JSONArray getMenuJsonList();

  List<SysMenu> getMenuChildrenAll(String id);

  JSONArray getTreeUtil(String roleId);

  List<SysMenu> getUserMenu(String id);

  JSONArray getMenuJsonByUser(List<SysMenu> menuList);
}
