package com.yxt.service;

import com.yxt.bean.User;
import com.yxt.utils.BusinessException;

public interface UserService {
    User register(User user) throws BusinessException;
    User login(String username, String password) throws  BusinessException;
}
