package com.zhumian.groceryshop.config.shiro;


import com.zhumian.groceryshop.bean.system.User;
import com.zhumian.groceryshop.business.system.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String account = (String)token.getPrincipal();
        String password =  new String((char[])token.getCredentials());

        User select = new User();
        select.setAccount(account);
        User user = userService.getOne(select);
        if(user == null){
            throw new UnknownAccountException();
        }
        if(!Objects.equals(user.getAccount(), account)){
            throw new IncorrectCredentialsException();
        }

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("currentUser",user);

        return new SimpleAuthenticationInfo(account, password, getName());
    }


}
