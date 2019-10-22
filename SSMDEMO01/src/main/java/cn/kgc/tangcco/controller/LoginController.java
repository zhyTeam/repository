package cn.kgc.tangcco.controller;

import cn.kgc.tangcco.pojo.Role;
import cn.kgc.tangcco.pojo.User;
import cn.kgc.tangcco.service.role.RoleService;
import cn.kgc.tangcco.service.user.UserService;
import cn.kgc.tangcco.tools.Constants;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    @RequestMapping(value = "/doLogin.html",method = RequestMethod.POST)
    public String doLogin(String userCode, String userPassword, HttpSession session){
        userService = (UserService) ac.getBean("userService");
        User user = userService.doLogin(userCode,userPassword);
        if (user!=null) {
            session.setAttribute("userSession",user);
            return "frame";
        }
        return "../../login";
    }
    @RequestMapping(value = "/showUserList.html")
    public String pageUserList(@RequestParam(required = false)String queryname, @RequestParam(required = false)Integer queryUserRole, HttpSession session, String pageIndex, Model model){
        Integer allNum = userService.userNum(queryname,queryUserRole);
        int currentPageNo=1;
        if (pageIndex!=null){
            currentPageNo=Integer.valueOf(pageIndex);
        }
        int totalPageCount=allNum/Constants.pageSize;
        if (allNum%Constants.pageSize!=0) {
            totalPageCount = totalPageCount + 1;
        }
        roleService = (RoleService) ac.getBean("roleService");
        List<Role> roleList = roleService.roleList();
        userService = (UserService) ac.getBean("userService");
        PageHelper.startPage(currentPageNo,Constants.pageSize);
        List<User> userList = userService.userList(queryname,queryUserRole);
        session.setAttribute("roleList",roleList);
        session.setAttribute("userList",userList);
        session.setAttribute("totalCount",allNum);//总记录数
        session.setAttribute("totalPageCount",totalPageCount);//总页数
        session.setAttribute("currentPageNo",currentPageNo);//当前页数
        return "userlist";
    }
}
