package com.markerhub.mapper;

import com.markerhub.common.dto.UpdateDto;
import com.markerhub.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-09-16
 */
@Mapper
public interface UserMapper {

    /**
     * @param userName
     * @return
     */
    @Select("select * from m_user where username=#{userName}")
    User getByUserName(String userName);

    /**
     * @param id
     * @return
     */
    @Select("select * from m_user where id=#{id}")
    User getById(long id);

    @Insert("insert into m_user (username, avatar, email, password, status, created, last_login) values (#{username},#{avatar}," +
            "#{email},"+
            "#{password}," +
            "#{status, jdbcType=INTEGER}," +
            "#{created, jdbcType=DATE}," +
            "#{lastLogin, jdbcType=DATE})")
    void insertOne(User user);

    @Update("update m_user set " +
            "username = #{username}," +
            "password = #{password}," +
            "email = #{email}," +
            "avatar = #{avatar}," +
            "status = #{status,jdbcType=INTEGER}" +
            " where id = #{id}")
    void updateOne(UpdateDto updateDto);

    @Delete("delete from m_user where id = #{id}")
    void deleteOne(User user);
}
