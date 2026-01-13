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
//1. 생성
    @Override
    public User create(String displayName, String email, String phoneNumber) {
        User user = new User(displayName, email, phoneNumber);
        data.add(user);
        return user;
    }
//2. 조회
    @Override
    public User findById(UUID userId) {
        for (User user : data) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean addUser(User user) {
       return data.add(user);

    }

    @Override
    public User getUser(String displayName) {
        for (User user : data) {
            if (user.getDisplayName().equals(displayName)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAlluser() {
        return data;
    }
//3. 수정
    @Override
    public User updateUser(UUID userId, String displayName, String email, String phoneNumber) {
        User user = findById(userId);

        if (user == null) return null;

        user.update(displayName, email, phoneNumber);
        return user;
    }

//4. 삭제
//Todo 삭제는 id 기준으로 구현하는 것이 맞음
//현재 인터페이스에는 파라미터가 없어서 보류

    @Override
    public boolean deleteUser(UUID userId) {
        for (User user : data){
            if (user.getId().equals(userId)) {
                return data.remove(user);
            }
        }
        return false;
    }
}
