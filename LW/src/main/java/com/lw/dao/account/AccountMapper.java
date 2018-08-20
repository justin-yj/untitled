package com.lw.dao.account;

import com.lw.data.dto.account.AccountDTO;
import com.lw.data.entity.account.AccountDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 王旗月 on 2018/6/30.
 */
@Mapper
public interface AccountMapper {

    List<AccountDTO> findList(AccountDTO dto);

    /**
     * 根据手机号码获取用户信息
     * @param mobile
     * @return
     */
    AccountDTO getByMobile(String mobile);

    int insert(AccountDO accountDO);
}
