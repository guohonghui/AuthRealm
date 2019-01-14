package com.org.service;

import com.org.base.BaseService;
import com.org.entity.SysRoleMenu;

import java.util.List;

public interface RoleMenuService extends BaseService<SysRoleMenu,String>{

    List<SysRoleMenu> selectByCondition(SysRoleMenu sysRoleMenu);

    int  selectCountByCondition(SysRoleMenu sysRoleMenu);

    int deleteByPrimaryKey(SysRoleMenu sysRoleMenu);
}
