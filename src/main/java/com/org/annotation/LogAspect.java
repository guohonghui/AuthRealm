package com.org.annotation;

import com.org.base.CurrentUser;
import com.org.utils.ShiroUtil;
import com.org.entity.SysLog;
import com.org.mapper.SysLogMapper;
import com.org.utils.IpUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 为增删改添加监控
 */
@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysLogMapper logMapper;

    @Pointcut("@annotation(com.org.annotation.Log)")
    private void pointcut() {

    }

    @After("pointcut()")
    public void insertLogSuccess(JoinPoint jp){
        addLog(jp,getDesc(jp));
    }

    private void addLog(JoinPoint jp,String text){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        CurrentUser currentUser=ShiroUtil.getCurrentUse();
        String ip=IpUtil.getIp(request);
        Log.LOG_TYPE type=getType(jp);
        SysLog log=new SysLog();
        log.setIp(ip);
        log.setCreateTime(new Date());
        log.setType(type.toString());
        log.setText(text);
        if(currentUser!=null){
            log.setUserName(currentUser.getUsername());
            logMapper.insert(log);
        }
    }

    /**
     * 记录异常
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value="pointcut()",throwing="e")
    public void afterException(JoinPoint joinPoint,Exception e){
        System.out.print(e.getMessage());
        addLog(joinPoint,getDesc(joinPoint)+e.getMessage());
    }


    private String getDesc(JoinPoint joinPoint){
        MethodSignature methodName = (MethodSignature)joinPoint.getSignature();
        Method method = methodName.getMethod();
        return method.getAnnotation(Log.class).desc();
    }

    private Log.LOG_TYPE getType(JoinPoint joinPoint){
        MethodSignature methodName = (MethodSignature)joinPoint.getSignature();
        Method method = methodName.getMethod();
        return method.getAnnotation(Log.class).type();
    }
}

