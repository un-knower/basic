package com.zhan.web.controller;

import com.zhan.web.entity.TopSeller;
import com.zhan.web.kylinmapper.KylinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author : Zhan
 * E-mail : kenger@163.com
 * Date   : 2017/10/16
 */
@Controller
public class KylinController {
    @Autowired
    private KylinMapper kylinMapper;

    @RequestMapping(value = "/topsellers",method = RequestMethod.GET)
    @ResponseBody
    public List<TopSeller> getTopSellers(double money){
        System.out.println(money);
        return kylinMapper.findTopSellers(money);
    }
}
