package service.jcf;

import entity.User;
import service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JCFUserService implements UserService {

    private final List<User> data;

    public JCFUserService() {
        this.data = new ArrayList<>();
    }

    @Override
    public User create(String displayName, String email, String phoneNumber) {
        User user = new User(displayName, email, phoneNumber);
        return null;
    }

    @Override
    public User findById(UUID userId) {
        return null;
    }


    @Override
    public boolean addUser(User user) {
       return data.add(user);

    }

    @Override
    public User getUser(String displayName) {
        return null;
    }

    @Override
    public List<User> getAlluser() {
        return data;
    }

    @Override
    public User updateUser(String name, String email, String phonenumber) {
        return null;
    }

    @Override
    public boolean deleteUser() {
        return false;
    }
}
