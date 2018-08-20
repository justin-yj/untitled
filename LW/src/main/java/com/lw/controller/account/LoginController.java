package com.lw.controller.account;

import com.lw.data.dto.account.AccountDTO;
import com.lw.data.entity.LibResult;
import com.lw.data.entity.account.AccountDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.lw.service.account.AccountService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/6/29.
 */
@Controller
public class LoginController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView toLogin(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    @ResponseBody
    public LibResult login(@RequestBody AccountDTO dto,HttpServletRequest request){
        return accountService.login(dto.getMobile(),dto.getPassword(),request);
    }

	@RequestMapping( path = "/index")
    public static ModelAndView toIndex(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("index");
        return mv;
    }



    @RequestMapping( path = "/UserRegistration")
    public ModelAndView toUserRegistration(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("UserRegistration");
        return mv;
    }

    @RequestMapping( path = "/registration")
    @ResponseBody
    public LibResult registration(@RequestBody AccountDO accountDO){
       return accountService.save(accountDO);
    }

    @RequestMapping( path = "/editMember")
    public ModelAndView toEditMember(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("editMember");
        return mv;
    }

    @RequestMapping( path = "/testLayer")
    public ModelAndView toTestLayer(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("testLayer");
        return mv;
    }

}
