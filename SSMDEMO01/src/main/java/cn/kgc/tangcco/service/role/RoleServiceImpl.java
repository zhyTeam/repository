package cn.kgc.tangcco.service.role;

import cn.kgc.tangcco.dao.role.RoleMapper;
import cn.kgc.tangcco.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("roleService")
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> roleList() {
        return roleMapper.roleList();
    }
}
