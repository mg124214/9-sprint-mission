package service;

import entity.User;
import java.util.List;
import java.util.UUID;

public interface  UserService {
    //생성
    User create(String displayName, String email, String phoneNumber);

    User findById(UUID userId);

    boolean addUser(User user);

    //단건 조회
    User getUser(String displayName);

    //다건 조회
    List<User> getAlluser();

    //수정
    User updateUser(String name, String email, String phonenumber);

    //삭제
    boolean deleteUser();

}
