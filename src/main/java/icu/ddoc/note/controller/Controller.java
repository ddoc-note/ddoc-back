package icu.ddoc.note.controller;

import icu.ddoc.note.entity.User;
import icu.ddoc.note.service.api.UserService;
import icu.ddoc.note.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResultEntity<User> getUser(@PathVariable("id") Integer id) {

        User user = userService.getUserById(id);

        return ResultEntity.successWithData(user);
    }

}
