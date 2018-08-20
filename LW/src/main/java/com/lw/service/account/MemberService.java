package com.lw.service.account;

import com.lw.dao.account.MemberMapper;
import com.lw.data.dto.account.AccountDTO;
import com.lw.data.entity.LibResult;
import com.lw.data.entity.member.MemberDO;
import com.lw.data.query.member.MemberQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 李宣宣 on 2018/7/12.
 */
@Service
public class MemberService {

    @Autowired
    MemberMapper memberMapper;

    public List<AccountDTO> findList(MemberQuery query){
        return memberMapper.findList(query);
    }




    public AccountDTO getByMobile(String mobile){
        return memberMapper.getByMobile(mobile);
    }


    public LibResult delMemberById(MemberDO memberDo){
       int result =  memberMapper.delMemberById(memberDo);
        if(result!=1){
            throw new RuntimeException("添加失败");
        }
        return LibResult.returnSuccess("已删除！");
    }
}
