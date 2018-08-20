package com.lw.controller.account;

import com.lw.data.dto.account.AccountDTO;
import com.lw.data.entity.LibResult;
import com.lw.data.entity.member.MemberDO;
import com.lw.data.enums.ResultStatusEnum;
import com.lw.data.query.member.MemberQuery;
import com.lw.service.account.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2018/6/29.
 */
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/findMembers" , method = RequestMethod.POST)
    @ResponseBody
    public LibResult toFindMembers(@RequestBody MemberQuery query){
        return LibResult.returnLibResult(ResultStatusEnum.SUCCESS
                ,memberService.findList(query));
    }

    @RequestMapping( path = "/MemberMsg")
    public ModelAndView toMemberMsg(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("MemberMsg");
        return mv;
    }

    @RequestMapping( path = "/delMemberById")
    @ResponseBody
    public LibResult delMemberById(@RequestBody MemberDO memberDO){
        return memberService.delMemberById(memberDO);
    }
}
