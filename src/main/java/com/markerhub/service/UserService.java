package com.markerhub.service;

import com.markerhub.common.dto.UpdateDto;
import com.markerhub.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-09-16
 */
public interface UserService{

    /**
     * @param userName
     * @return
     */
    User getOne(String userName);

    /**
     *
     * @param id
     * @return
     */
    User getById(long id);


    /**
     * @param user
     */
    void insertOne(User user);


    /**
     * @param updateDto
     */
    void updateOne(UpdateDto updateDto);

    /**
     * @param user
     */
    void deleteOne(User user);
}
