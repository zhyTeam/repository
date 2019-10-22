package cn.kgc.tangcco.appinfosys.controller.developer;

import cn.kgc.tangcco.appinfosys.service.devuser.*;
import cn.kgc.tangcco.appinfosys.pojo.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;

@Controller
@RequestMapping("/devLogin")
public class DevLoginController {

    @Resource
    private DevUserService devUserService;
    /*
    * 去开发者登录页面
    * */
    @RequestMapping("/toLogin")
    public String toDevLogin(){
        return "devlogin";
    }

    /*
    * 开发者登录
    * */
    @RequestMapping(value = "dologin",method = RequestMethod.POST)
public String doLogin(String devCode, String devPassword, HttpSession session, HttpServletRequest request){
        try {
            DevUser devUser = devUserService.login(devCode, devPassword);
         if (devUser!=null){
             //说明登录成功,将用户储存到session作用域中
             session.setAttribute(Constants.DEV_USER_SESSION,devUser);
             return "developer/main";
         }else{//登录失败
             request.setAttribute("error","登录失败,用户名或密码错误");
         }

        }catch (Exception e){//登录失败
            e.printStackTrace();
            request.setAttribute("error","登录失败,用户名或密码错误");
            return "devlogin";
        }
}
/*退出*/
    @RequestMapping(value = "login",method = RequestMethod.GET)
public String loginOut(HttpSession session){
    session.removeAttribute(Constants.DEV_USER_SESSION);
    return "devlogin";
}

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String loginOut(HttpSession session){
        session.removeAttribute(Constants.DEV_USER_SESSION);
        return "../../index";

}
