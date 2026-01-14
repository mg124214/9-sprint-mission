import entity.User;
import service.UserService;
import service.jcf.JCFUserService;

import java.util.List;


public class JavaApplication {
    public static void main(String[] args) {
        UserService userService = new JCFUserService();

        //1.생성
        User user = userService.create("박민군", "bmingun@gmail.com", "010-1234-5678");
        System.out.println("인원 추가 완료 : " + userService.getAlluser());

        //2.조회
        User foundUser = userService.findById(user.getId());
        System.out.println("단건 조회 : " + foundUser);
        List<User> foundUsers = userService.getAlluser();
        System.out.println("유저 조회(다건): " + foundUsers.size());

        //3.수정
        User updatedUser = userService.updateUser(user.getId(), null, null, "010-1234-5678");
        System.out.println("유저 수정: " + String.join("/", updatedUser.getDisplayName(), updatedUser.getEmail(), updatedUser.getPhoneNumber()));

        //4.삭제
        userService.deleteUser(user.getId());
        List<User> foundUsersAfterDelete = userService.getAlluser();
        System.out.println("유저 삭제: " + foundUsersAfterDelete.size());

        //5.이름 중복 테스트 (throw)
        try {
            userService.create("박민군", "bmingun@gmail.com", "010-1234-5678");
            userService.create("박민군", "bmingun@gmail.com", "010-2222-2222"); // 중복
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        System.out.println("전체 유저 수 : " + userService.getAlluser().size());

        //6.Stream API를 통해 JCF의 데이터 조회
        userService.create("이용일", "lyi@nate.com", "010-1234-5678");
        userService.create("윤성준", "ysj@naver.com", "010-9101-1121");
        userService.getAlluser()
                .stream()
                .filter(u -> u.getEmail().contains("nate"))
                .forEach(System.out::println);


    }
}

