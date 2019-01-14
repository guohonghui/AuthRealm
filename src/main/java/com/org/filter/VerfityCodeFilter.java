package com.org.filter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 验证码拦截
 */
@Data
public class VerfityCodeFilter extends AccessControlFilter{

    @ApiModelProperty(value = "是否开启验证码验证   默认true")
    private boolean verfitiCode = true;

    @ApiModelProperty(value = "前台提交的验证码name")
    private String jcaptchaParam = "code";

    @ApiModelProperty(value = "验证失败后setAttribute key")
    private String failureKeyAttribute = "shiroLoginFailure";

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object o) throws Exception {
        request.setAttribute("verfitiCode", verfitiCode);//暂时未用到非验证码
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        //2、判断验证码是否禁用 或不是表单提交
        if (verfitiCode == false || !"post".equalsIgnoreCase(httpRequest.getMethod())) {
            return true;
        }
        //表单提交，校验验证码的正确性
        String storedCode = getSubject(request, response).getSession().getAttribute("_code").toString();
        String currentCode = httpRequest.getParameter(jcaptchaParam);

        return StringUtils.equalsIgnoreCase(storedCode, currentCode);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        servletRequest.setAttribute(failureKeyAttribute, "code.error");
        return true;
    }

}
