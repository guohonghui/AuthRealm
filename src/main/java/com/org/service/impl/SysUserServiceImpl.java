package com.org.service.impl;

import com.org.base.BaseMapper;
import com.org.base.impl.BaseServiceImpl;
import com.org.entity.SysRole;
import com.org.entity.SysRoleUser;
import com.org.entity.SysUser;
import com.org.mapper.SysRoleUserMapper;
import com.org.mapper.SysUserMapper;
import com.org.service.RoleService;
import com.org.service.SysUserService;
import com.org.util.Checkbox;
import com.org.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhuxiaomeng
 * @date 2017/12/4.
 * @email 154040976@qq.com
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser,String> implements SysUserService {

  @Autowired
  SysUserMapper sysUserMapper;

  @Autowired
  SysRoleUserMapper sysRoleUserMapper;
  @Autowired
  RoleService roleService;
  @Override
  public BaseMapper<SysUser, String> getMappser() {
    return sysUserMapper;
  }

  @Override
  public SysUser login(String username) {
    return sysUserMapper.login(username);
  }


  @Override
  public int deleteByPrimaryKey(String id) {
    return 0;
  }

  @Override
  public int insert(SysUser record) {
    return 0;
  }

  @Override
  public int insertSelective(SysUser record) {
    return 0;
  }

  @Override
  public SysUser selectByPrimaryKey(String id) {
    return sysUserMapper.selectByPrimaryKey(id);
  }

  @Override
  public int updateByPrimaryKeySelective(SysUser record) {
    return sysUserMapper.updateByPrimaryKeySelective(record);
  }

  @Override
  public int updateByPrimaryKey(SysUser record) {
    return sysUserMapper.updateByPrimaryKey(record);
  }

  @Override
  public List<SysRoleUser> selectByCondition(SysRoleUser sysRoleUser) {
    return sysRoleUserMapper.selectByCondition(sysRoleUser);
  }

  /**
   * 分页查询
   * @param
   * @return
   */
  @Override
  public List<SysUser> selectListByPage(SysUser sysUser) {
    return sysUserMapper.selectListByPage(sysUser);
  }

  @Override
  public int count() {
    return sysUserMapper.count();
  }

  @Override
  public int add(SysUser user) {
    //密码加密
  String pwd= Md5Util.getMD5(user.getPassword().trim(),user.getUsername().trim());
  user.setPassword(pwd);
    user.setCreateDate(new Date());
    return sysUserMapper.add(user);
  }

  @Override
  public int delById(String id) {
    return sysUserMapper.delById(id);

  }

  @Override
  public int checkUser(String username) {
    return sysUserMapper.checkUser(username);
  }

  @Override
  public List<Checkbox> getUserRoleByJson(String id){
    List<SysRole> roleList=roleService.selectListByPage(new SysRole());
    SysRoleUser sysRoleUser =new SysRoleUser();
    sysRoleUser.setUserId(id);
    List<SysRoleUser>  kList= selectByCondition(sysRoleUser);
    System.out.println(kList.size());
    List<Checkbox> checkboxList=new ArrayList<>();
    Checkbox checkbox=null;
    for(SysRole sysRole:roleList){
      checkbox=new Checkbox();
      checkbox.setId(sysRole.getId());
      checkbox.setName(sysRole.getRoleName());
      for(SysRoleUser sysRoleUser1 :kList){
        if(sysRoleUser1.getRoleId().equals(sysRole.getId())){
          checkbox.setCheck(true);
        }
      }
      checkboxList.add(checkbox);
    }
    return checkboxList;
  }
}
