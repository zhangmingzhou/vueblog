package com.markerhub.service.impl;

import com.markerhub.common.dto.UpdateDto;
import com.markerhub.common.exception.BlogError;
import com.markerhub.common.exception.BlogException;
import com.markerhub.entity.User;
import com.markerhub.mapper.UserMapper;
import com.markerhub.service.UserService;
import com.markerhub.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger("ConsoleLogger");

    @Autowired
    UserMapper userMapper;

    @Override
    public User getOne(String userName) {
        LogUtil.info(LOGGER,userName);
        User user = userMapper.getByUserName(userName);
        if (user == null){
            throw new BlogException(BlogError.UserNotFound);
        }
        return user;
    }

    @Override
    public void insertOne(User user) {

        LocalDateTime create = LocalDateTime.now();
        user.setCreated(create) ;
        user.setLastLogin(create);

        if(user.getAvatar() == null){
            user.setAvatar(null);
        }

        user.setStatus(0);

        userMapper.insertOne(user);
    }

    @Override
    public void updateOne(UpdateDto updateDto) {
        userMapper.updateOne(updateDto);
    }

    @Override
    public void deleteOne(User user) {
        userMapper.deleteOne(user);
    }

    @Override
    public User getById(Long id) {
        User user = userMapper.getById(id);
        if (user == null){
            throw new BlogException(BlogError.UserNotFound);
        }
        return user;
    }


}