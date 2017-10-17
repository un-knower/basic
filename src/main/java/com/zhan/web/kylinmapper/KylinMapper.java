package com.zhan.web.kylinmapper;

import com.zhan.web.entity.TopSeller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author : Zhan
 * E-mail : kenger@163.com
 * Date   : 2017/10/16
 */
@Mapper
public interface KylinMapper {
    @Select("select seller_id as seller,sum(price) as sumprise from " +
            "kylin_sales group by seller_id having sum(price) >= #{money} " +
            "order by sum(price) desc ")
    List<TopSeller> findTopSellers(@Param("money") double money);
}
