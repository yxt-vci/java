package com.yxt.ui;

import com.yxt.bean.User;
import com.yxt.service.UserService;
import com.yxt.service.impl.UserServiceImpl;
import com.yxt.utils.BusinessException;

public class RegisterClass extends BaseClass {
    public void register()throws BusinessException {
        println(getString("input.username"));
        String username = input.nextLine();
        println(getString("input.password"));
        String password = input.nextLine();
        User user = new User(username,password);
        UserService userService = new UserServiceImpl();
        userService.register(user);
    }
}
