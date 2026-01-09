import entity.User;
import service.UserService;
import service.jcf.JCFUserService;

public class JavaApplication {
    public static void main(String[] args) {
        User user = new User("박민군", "bmingun@gmail.com", "010-1234-5678");
        UserService userService = new JCFUserService();

        userService.addUser(user);

        System.out.println("인원 추가 완료 : " + userService.getAlluser());

        //userService.getAlluser();



    }
}
