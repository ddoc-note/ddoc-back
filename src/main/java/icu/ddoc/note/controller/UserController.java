package icu.ddoc.note.controller;

import icu.ddoc.note.entity.User;
import icu.ddoc.note.service.api.UserService;
import icu.ddoc.note.util.Constant;
import icu.ddoc.note.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/{account}/{nickName}/{password}")
    public ResultEntity<String> register(@PathVariable("account") String account, @PathVariable("nickName") String nickName, @PathVariable("password") String password) {

        // 判断account是否存在
        User accountUser = userService.getUserByAccount(account);
        if (accountUser != null) {
            return ResultEntity.failed(Constant.ACCOUNT_IS_ALREADY_IN_USE);
        }

        User user = new User(null, account, nickName, password);

        userService.register(user);

        return ResultEntity.successWithoutData();
    }
}
