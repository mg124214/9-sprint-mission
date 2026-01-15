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
    User getUser(String displayName); //이름 기반 조회를 대비

    //다건 조회
    List<User> getAlluser();

    //수정
    User updateUser(UUID userId, String displayName, String email, String phoneNumber);

    //삭제
    void deleteUser(UUID userId);


}
