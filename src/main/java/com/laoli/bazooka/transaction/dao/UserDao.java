package com.laoli.bazooka.transaction.dao;

import com.laoli.bazooka.transaction.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    Integer createUser(User user);
}
