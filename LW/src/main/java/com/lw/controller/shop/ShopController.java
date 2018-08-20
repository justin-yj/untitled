package com.lw.controller.shop;

import com.lw.data.dto.shop.ShopDTO;
import com.lw.service.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2018/6/29.
 */
@Controller
public class ShopController {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/findShops" , method = RequestMethod.POST)
    @ResponseBody
    public List<ShopDTO> toFindShops(@RequestBody ShopDTO dto, HttpServletRequest request){
        return shopService.findList(dto);
    }

    @RequestMapping( path = "/shop")
    public ModelAndView toShop(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("shop");
        return mv;
    }

    @RequestMapping( path = "/shopMsg")
    public ModelAndView toMemberMsg(ShopDTO dto){
        ModelAndView mv=new ModelAndView();
        List<ShopDTO> list = shopService.findList(dto);
        mv.addObject("shopMsg",shopService.findList(dto));
        mv.setViewName("shop");
        return mv;
    }

}
