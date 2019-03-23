package com.yxt.utils;

import com.yxt.bean.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserIO {
    private static List<User> users = new ArrayList<>();
    private static final String USER_FILE = "user.obj";
    //写入用户
    public boolean writeUsers() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(USER_FILE));
            out.writeObject(users);
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean readUsers(){
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(USER_FILE));
            users = (List<User>)in.readObject();
            in.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void add(User user){
        user.setId(users.size()+1);
        users.add(user);
    }

    public User findByUsernameAndPassword(String username,String password){
        for(User u:users){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }
}


