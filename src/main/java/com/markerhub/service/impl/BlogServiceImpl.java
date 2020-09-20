package com.markerhub.service.impl;

import com.markerhub.common.exception.BlogError;
import com.markerhub.common.exception.BlogException;
import com.markerhub.entity.Blog;
import com.markerhub.entity.User;
import com.markerhub.mapper.BlogMapper;
import com.markerhub.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-09-16
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    UserService userService;

    @Override
    public Blog getById(Long id) {
        Blog blog = blogMapper.getById(id);
        if(blog==null)
            throw new BlogException(BlogError.BlogNotFound);
        return blog;
    }

    @Override
    public void insertOne(Blog blog) {
        User user = userService.getById(blog.getUserId());
        if(user==null){
            throw new BlogException(BlogError.UserNotFound);
        }
        if(blog.getTitle()==null)
            throw new BlogException(BlogError.BlogWithoutTitle);
        if(blog.getContent()==null)
            throw new BlogException(BlogError.BlogWithoutContent);
        LocalDateTime create = LocalDateTime.now();
        blog.setCreated(create);
        blog.setStatus(0);
        blogMapper.insertOne(blog);
    }

    @Override
    public void deleteOne(Long id){
        if(getById(id)==null)
            throw new BlogException(BlogError.BlogNotFound);
        blogMapper.deleteOne(id);
    }
}
