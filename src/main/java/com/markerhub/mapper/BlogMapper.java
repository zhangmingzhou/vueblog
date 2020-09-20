package com.markerhub.mapper;

import com.markerhub.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-09-16
 */
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

    @Select("select * from m_blog where id = #{id}")
    Blog getById(Long id);

    @Insert("insert into m_blog (user_id,title,description,content,status,created) " +
            "values (#{userId,jdbcType = BIGINT}," +
            "#{title}," +
            "#{description}," +
            "#{content}," +
            "#{status,jdbcType = INTEGER}," +
            "#{created,jdbcType = DATE}" +
            ")")
    void insertOne(Blog blog);

    @Delete("delete from m_blog where id = #{id}")
    void deleteOne(Long id);
}
