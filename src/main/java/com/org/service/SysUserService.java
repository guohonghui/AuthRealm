package com.org.service;


import com.org.base.BaseService;
import com.org.entity.SysRoleUser;
import com.org.entity.SysUser;
import com.org.utils.Checkbox;

import java.util.List;

public interface SysUserService extends BaseService<SysUser,String> {

  SysUser login(String username);

  @Override
  SysUser selectByPrimaryKey(String id);

  /**
   * 分页查询
   * @param
   * @return
   */
  List<SysUser> selectListByPage(SysUser sysUser);

  int count();

  /**
   * 新增
   * @param user
   * @return
   */
  int add(SysUser user);

  /**
   * 删除
   * @param id
   * @return
   */
  int delById(String id);

  int checkUser(String username);


  int updateByPrimaryKey(SysUser sysUser);

  List<SysRoleUser> selectByCondition(SysRoleUser sysRoleUser);

  List<Checkbox> getUserRoleByJson(String id);

}
