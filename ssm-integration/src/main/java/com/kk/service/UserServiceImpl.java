package com.kk.service;

import com.kk.entity.User;
import com.kk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> queryUserAll() {
        return mapper.queryUserAll();
    }

    @Override
    public User queryUserById(Integer id) {
        return mapper.queryUserById(id);
    }

    @Override
    public Integer insertUser(User user) {
        return mapper.insertUser(user);
    }

    @Override
    public Integer updateUser(User user) {
        return mapper.updateUser(user);
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return mapper.deleteUserById(id);
    }
}
