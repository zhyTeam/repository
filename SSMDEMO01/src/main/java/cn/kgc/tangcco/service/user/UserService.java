package cn.kgc.tangcco.service.user;

import cn.kgc.tangcco.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //登录
    public User doLogin(String userCode, String userPassword);
    //遍历
    public List<User> userList(String queryname,Integer queryUserRole);
    //数量
    public Integer userNum(String queryname,Integer queryUserRole);
    //添加
    public Boolean addUser(User user);
}
