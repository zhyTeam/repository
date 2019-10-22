package cn.kgc.tangcco.dao.user;

import cn.kgc.tangcco.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //登录
    public User doLogin(@Param("code") String userCode,@Param("password")  String userPassword);
    //遍历
    public List<User> userList(@Param("queryname") String queryname,@Param("queryUserRole") Integer queryUserRole);
    //数量
    public Integer userNum(@Param("queryname") String queryname,@Param("queryUserRole") Integer queryUserRole);
    //添加
    public Integer addUser(User user);
}
