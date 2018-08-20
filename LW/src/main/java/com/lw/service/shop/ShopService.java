package com.lw.service.shop;

import com.lw.dao.account.ShopMapper;
import com.lw.data.dto.shop.ShopDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 李宣宣 on 2018/7/12.
 */
@Service
public class ShopService {

    @Autowired
    ShopMapper shopMapper;

    public List<ShopDTO> findList(ShopDTO dto){
    return shopMapper.findList(dto);
  }

}
