package icu.ddoc.note.service.impl;

import icu.ddoc.note.entity.User;
import icu.ddoc.note.entity.UserExample;
import icu.ddoc.note.mapper.UserMapper;
import icu.ddoc.note.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User getUserByAccount(String account) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(account);
        List<User> users = userMapper.selectByExample(example);
        if (users.size() == 0) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public void register(User user) {
        userMapper.insertSelective(user);
    }
}
