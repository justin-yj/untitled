package com.lw.service.account;

import com.lw.config.Constant;
import com.lw.dao.account.AccountMapper;
import com.lw.data.dto.account.AccountDTO;
import com.lw.data.entity.account.AccountDO;
import com.lw.data.entity.LibResult;
import com.lw.utils.StringUtil;
import com.lw.utils.ValidateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 王旗月 on 2018/6/30.
 */
@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    public List<AccountDTO> findList(AccountDTO dto){
    return accountMapper.findList(dto);
  }


    public LibResult login(String mobile, String password,HttpServletRequest request){
        if(StringUtils.isBlank(mobile)
                ||StringUtils.isBlank(password)){
            return LibResult.returnError("手机号或者密码不能为空");
        }
        if(!ValidateUtil.isMobile(mobile)){
            return LibResult.returnError("手机号错误");
        }
        String pwd=StringUtil.getPassword(password);
        System.out.println(pwd);
        AccountDTO accountDTO=accountMapper.getByMobile(mobile);
        if(accountDTO==null){
            return LibResult.returnError("手机号未注册");
        }
        if(!pwd.equals(accountDTO.getPassword())){
            return LibResult.returnPwdError("密码错误");
        }
        accountDTO.setPassword(null);

        //Subject subject=SecurityUtils.getSubject();
        //subject.login();
        //Session session=subject.getSession();
        request.getSession().setAttribute(Constant.LOGIN_SESSION_KEY,accountDTO);
        return LibResult.returnSuccess();
    }

    public AccountDTO getByMobile(String mobile){
        return accountMapper.getByMobile(mobile);
    }

    public LibResult save(AccountDO accountDO){
        if(StringUtils.isEmpty(accountDO.getMobile())||StringUtils.isEmpty(accountDO.getPassword())){
            return LibResult.returnError("手机号密码不能为空");
        }
        if(accountDO.getPassword().length() < 6){
            return LibResult.returnError("密码不能少于6位");
        }
        if(!accountDO.getPassword().equals(accountDO.getConfirmPwd())){
            return LibResult.returnError("两次密码输入不一致");
        }
        AccountDTO account=accountMapper.getByMobile(accountDO.getMobile());
        if(account!=null){
            return LibResult.returnError("该手机号已注册");
        }
        if(!StringUtil.isMobileNO(accountDO.getMobile())){
            return LibResult.returnError("请填写正确的手机号");
        }
        accountDO.setPassword(StringUtil.getPassword(accountDO.getPassword()));
        int result= accountMapper.insert(accountDO);
        if(result!=1){
            throw new RuntimeException("添加失败");
        }
        return LibResult.returnSuccess("注册成功，请登录！");

    }
}
