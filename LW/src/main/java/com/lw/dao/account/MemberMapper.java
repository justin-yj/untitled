package com.lw.dao.account;

import com.lw.data.dto.account.AccountDTO;
import com.lw.data.entity.member.MemberDO;
import com.lw.data.query.member.MemberQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 李宣宣 on 2018/7/12.
 */
@Mapper
public interface MemberMapper {

    List<AccountDTO> findList(MemberQuery query);

    /**
     * 根据手机号码获取会员信息
     * @param mobile
     * @return
     */
    AccountDTO getByMobile(String mobile);

    /**
     * 添加会员
     * @param memberDO
     * @return
     */
    int insert(MemberDO memberDO);

    /**
     * 删除会员：把会员的del_flag改为1
     * @param memberId
     * @return
     */
    int delMemberById(MemberDO memberDO);
}
