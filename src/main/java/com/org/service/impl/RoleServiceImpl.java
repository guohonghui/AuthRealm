package com.org.service.impl;

import com.org.base.BaseMapper;
import com.org.base.impl.BaseServiceImpl;
import com.org.entity.SysRole;
import com.org.mapper.SysRoleMapper;
import com.org.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl extends BaseServiceImpl<SysRole,String> implements RoleService{

  @Autowired
  private SysRoleMapper roleMapper;

  @Override
  public BaseMapper<SysRole, String> getMappser() {
    return roleMapper;
  }

  @Override
  public int deleteByPrimaryKey(String id) {
    return roleMapper.deleteByPrimaryKey(id);
  }

  @Override
  public int insert(SysRole record) {
    return roleMapper.insert(record);
  }

  @Override
  public SysRole selectByPrimaryKey(String id) {
    return roleMapper.selectByPrimaryKey(id);
  }

  @Override
  public int updateByPrimaryKeySelective(SysRole record) {
    return roleMapper.updateByPrimaryKeySelective(record);
  }

  @Override
  public int updateByPrimaryKey(SysRole record) {
    return roleMapper.updateByPrimaryKey(record);
  }

  @Override
  public List<SysRole> selectListByPage(SysRole sysRole) {
    return roleMapper.selectListByPage(sysRole);
  }
}
