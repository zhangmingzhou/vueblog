package com.markerhub.mapper;

import com.markerhub.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-09-16
 */
public interface BlogMapper extends BaseMapper<Blog> {

    @Insert("insert into table ()  values (#{})")
    void insertBlog(Blog blog);
}
