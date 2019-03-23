package com.yxt.ui;

import com.yxt.utils.BusinessException;
import com.yxt.utils.UserIO;

public class WelcomClass extends BaseClass {
    public void start() {
        println(getString("info.welcome"));
        UserIO userIO = new UserIO();
        userIO.readUsers();
        boolean flag = true;
        while (flag) {
            println(getString("info.login.reg"));
            println(getString("info.select"));
            String select = input.nextLine();
            switch (select) {
                case "1":

                    try {
                        new LoginClass().login();
                        flag = false;
                        println(getString("login.success"));
                    } catch (BusinessException e) {
                        println(getString(e.getMessage()));

                    }

                    break;
                case "2":
                    try {
                        flag = false;
                        new RegisterClass().register();
                        println(getString("reg.success"));

                    } catch (BusinessException e) {
                        println(getString("reg.error"));
                    }
                    break;
                default:
                    println(getString("input.error"));
                    break;
            }
        }
    }
}
