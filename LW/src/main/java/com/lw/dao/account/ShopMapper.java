package com.lw.dao.account;

import com.lw.data.dto.shop.ShopDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 李宣宣 on 2018/7/12.
 */
@Mapper
public interface ShopMapper {

    List<ShopDTO> findList(ShopDTO dto);

    /**
     * 根据手机号码获取会员信息
     * @param mobile
     * @return
     */
    ShopDTO getByMobile(String mobile);

}
