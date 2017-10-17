package com.zhan.web.dbmapper;

import com.zhan.web.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Author : Zhan
 * E-mail : kenger@163.com
 * Date   : 2017/10/16
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM User;")
    List<User> getAllUser();

    @Select("SELECT * FROM User WHERE id = #{id}")
    User getOneUser(@Param("id") Integer id);

    @Insert("INSERT INTO User (id,name,age) " +
            "VALUES( #{id}, #{name}, #{age})")
    int insertOneUser(User User);

    @Update("UPDATE User SET name = #{name},age = #{age} " +
            "WHERE id = #{id}")
    int updateOneUser(User User);

    @Delete("DELETE FROM USER WHERE id = #{id}")
    int deleteById(@Param("id") int id);
}
