package com.kk.mapper;

import com.kk.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> queryUserAll();

    User queryUserById(Integer id);

    Integer insertUser(User user);

    Integer updateUser(User user);

    Integer deleteUserById(Integer id);

}
