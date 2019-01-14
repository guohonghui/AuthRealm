package com.org.mapper;

import com.org.base.BaseMapper;
import com.org.entity.SysRoleMenu;

import java.util.List;

public interface SysRoleMenuMapper  extends BaseMapper<SysRoleMenu,String>{

    int deleteByPrimaryKey(SysRoleMenu key);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    List<SysRoleMenu> selectByCondition(SysRoleMenu sysRoleMenu);

   int  selectCountByCondition(SysRoleMenu sysRoleMenu);
}