package com.zhumian.groceryshop.aspect;

import com.zhumian.groceryshop.base.vo.BaseRequest;
import com.zhumian.groceryshop.bean.system.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BaseRequestAspect {


    @Pointcut("execution(* com.zhumian.groceryshop..controller..*.*(..)) &&  args(request, ..)")
    public void aspectMethod(BaseRequest request){}

    @Before("aspectMethod(request)")
    public void before(JoinPoint joinPoint, BaseRequest request){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("currentUser");
        if(user != null){
            request.setCurrentUserId(user.getId());
            request.setCurrentUserName(user.getName());
        }
    }
}
