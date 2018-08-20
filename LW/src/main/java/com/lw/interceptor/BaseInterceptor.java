package com.lw.interceptor;

import com.lw.config.Constant;
import com.lw.data.dto.account.AccountDTO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/7/5.
 */
public class BaseInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String URL=request.getContextPath();
        AccountDTO user=(AccountDTO)request.getSession().getAttribute(Constant.LOGIN_SESSION_KEY);
//        Session session= SecurityUtils.getSubject().getSession();
//        AccountDTO user=(AccountDTO)session.getAttribute(Constant.LOGIN_SESSION_KEY);
        if(user==null){
            //response.sendRedirect(request.getContextPath()+"");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
