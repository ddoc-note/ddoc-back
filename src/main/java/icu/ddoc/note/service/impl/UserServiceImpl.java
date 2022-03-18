package icu.ddoc.note.service.impl;

import icu.ddoc.note.entity.User;
import icu.ddoc.note.mapper.UserMapper;
import icu.ddoc.note.service.api.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
