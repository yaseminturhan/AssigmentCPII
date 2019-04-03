package services;

import model.User;

import java.util.List;

public abstract class UserServices {

    abstract User loginUser(User user);
    abstract boolean logoutUser(String username);
    abstract void registerUser(User user);
    abstract List<String> listUser();
    

}
