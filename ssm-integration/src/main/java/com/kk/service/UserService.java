package com.kk.service;

import com.kk.entity.User;

import java.util.List;

public interface UserService {

    List<User> queryUserAll();

    User queryUserById(Integer id);

    Integer insertUser(User user);

    Integer updateUser(User user);

    Integer deleteUserById(Integer id);
}
