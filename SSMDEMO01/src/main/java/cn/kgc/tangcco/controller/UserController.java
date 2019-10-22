package cn.kgc.tangcco.controller;

import cn.kgc.tangcco.pojo.Role;
import cn.kgc.tangcco.pojo.User;
import cn.kgc.tangcco.service.role.RoleService;
import cn.kgc.tangcco.service.user.UserService;
import cn.kgc.tangcco.tools.Constants;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @RequestMapping(value = "/showRoleList")
    /*把数据相应到流内*/
    @ResponseBody
    public JSON showRoleList(){
        List<Role> roleList = roleService.roleList();
        return (JSON)JSON.toJSON(roleList);
    }
    @RequestMapping(value ="/addUser.html")
    public String addUser(@ModelAttribute("user")User user){
        return "useradd";
    }
    @RequestMapping(value ="/saveUser.html")
    public String saveUser(User user, HttpSession session){
        user.setCreatedBy(((User)session.getAttribute("userSession")).getId());
        user.setCreationDate(new Date());
        Boolean result = userService.addUser(user);
        if (result==true) {
            /*重定向*/
            return "redirect:/login/showUserList.html";
        } else {
            return "useradd";
        }
    }

}
