package cn.kgc.tangcco.service.user;

import cn.kgc.tangcco.dao.user.UserMapper;
import cn.kgc.tangcco.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User doLogin(String userCode, String userPassword) {
        return userMapper.doLogin(userCode,userPassword);
    }

    @Override
    public List<User> userList(String queryname,Integer queryUserRole) {
        return userMapper.userList(queryname,queryUserRole);
    }

    @Override
    public Integer userNum(String queryname, Integer queryUserRole) {
        return userMapper.userNum(queryname,queryUserRole);
    }

    @Override
    public Boolean addUser(User user) {
        Integer result = userMapper.addUser(user);
        Boolean bool = false;
        if (result!=0) {
            bool = true;
            return bool;
        }
        return bool;
    }
}
