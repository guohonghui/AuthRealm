package com.org.service;

import com.org.base.BaseService;
import com.org.entity.SysRoleUser;

public interface RoleUserService  extends BaseService<SysRoleUser,String>{

  int deleteByPrimaryKey(SysRoleUser sysRoleUser);

  int insert(SysRoleUser sysRoleUser);

  int selectCountByCondition(SysRoleUser sysRoleUser);

}
