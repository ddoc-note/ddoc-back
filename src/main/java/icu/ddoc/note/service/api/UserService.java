package icu.ddoc.note.service.api;

import icu.ddoc.note.entity.User;

public interface UserService {

    User getUserById(Integer id);

    void register(User user);

    User getUserByAccount(String account);
}
