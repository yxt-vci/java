package com.yxt.ui;

import com.yxt.bean.User;
import com.yxt.service.UserService;
import com.yxt.service.impl.UserServiceImpl;
import com.yxt.utils.BusinessException;

public class LoginClass extends BaseClass {
    public void login() throws BusinessException {
        println(getString("input.username"));
        String username = input.nextLine();
        println(getString("input.password"));
        String password = input.nextLine();
        UserService userService = new UserServiceImpl();
        User user = userService.login(username, password);

        if (user != null) {
            currUser = user;
        } else {
            throw new BusinessException("login.error");
        }

    }
}
