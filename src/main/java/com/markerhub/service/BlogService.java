package com.markerhub.service;

import com.markerhub.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-09-16
 */
public interface BlogService extends IService<Blog> {

    /**
     * @param id
     * @return
     */
    Blog getById(Long id);

    /**
     * @param blog
     */
    void insertOne(Blog blog);

    /**
     * @param id
     */
    void deleteOne(Long id);
}
