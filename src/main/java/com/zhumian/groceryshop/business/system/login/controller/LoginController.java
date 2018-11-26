package com.zhumian.groceryshop.business.system.login.controller;

import com.zhumian.groceryshop.base.vo.BaseResponse;
import com.zhumian.groceryshop.business.system.login.req.LoginRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {


    /**
     * 登录
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    BaseResponse<Void> login(LoginRequest request){
        UsernamePasswordToken token = new UsernamePasswordToken(request.getAccount(), request.getPassword());
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()){
            token.setRememberMe(false);
            subject.login(token);
        }
        return new BaseResponse<>();
    }

    @RequestMapping(value = "/")
    public ModelAndView index(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/home")
    public ModelAndView home(){
        return new ModelAndView("home");
    }
}
