package service;


import entity.User;
import memory.UserMemory;

public class UserService {

    private final UserMemory userMemory = new UserMemory();


    public User findByUsernameAndPassword(String username, String password) {
        return userMemory.findByUsernameAndPassword( username , password);
    }

    public boolean exists(String username) {
        return userMemory.exists( username );
    }

    public void save(User user) {
        userMemory.save( user );
    }
}
