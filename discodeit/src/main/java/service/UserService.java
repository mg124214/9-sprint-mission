package service;

import entity.User;
import java.util.List;

public interface  UserService {
    //생성
    boolean addUser (User user);

    //조회
    User getUser(String displayName);

    //전체 조회
    List<User> getAlluser();

    //수정
    User updateUser(String name, String email, String phonenumber);

    //박민군 -> 전체목록에서 검색 -> User 객체를 가져오고
    // -> 가져온 User안에 필드인 id를 조회해서 리스트에서 검색한다음 삭제하도록 진행

    //삭제
    boolean deleteUser();
}
