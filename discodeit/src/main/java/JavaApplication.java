import entity.Channel;
import entity.User;
import service.ChannelService;
import service.UserService;
import service.jcf.JCFUserService;
import entity.Message;
import service.MessageService;
import service.jcf.JCFMessageService;
import java.util.UUID;
import java.util.List;
import service.jcf.JCFChannelService;


// User
public class JavaApplication {
    static void userCRUDTest(UserService userService) {
        System.out.println("\n===============================");
        System.out.println("User 기능 테스트");
        System.out.println("===============================\n");

        //1.생성
        User user1 = userService.create("박민군", "bmingun@gmail.com", "010-1234-5678");
        User user2 = userService.create("림혜민", "hyemin@gmail.com", "010-2344-5618");
        User user3 = userService.create("이용일", "dyddlf@gmail.com", "010-2144-8668");
        User user4 = userService.create("최건위", "rjsdnl@gmail.com", "010-9364-1864");
        User user5 = userService.create("윤성준", "tjdwns@gmail.com", "010-2056-1742");
        System.out.println("인원 추가 완료 : " + userService.getAlluser());

        //2.조회
        User foundUser = userService.findById(user1.getId());
        System.out.println("단건 조회 : " + foundUser);
        List<User> foundUsers = userService.getAlluser();
        System.out.println("유저 조회(다건): " + foundUsers.size());

        //3.수정
        User updatedUser = userService.updateUser(user2.getId(), "임혜민", "dkljfalk@gmail.com", "010-1234-5678");
        System.out.println("유저 수정: " + String.join("/", updatedUser.getDisplayName(), updatedUser.getEmail(), updatedUser.getPhoneNumber()));

        //4.삭제
        List<User> foundUsersAfterDelete = userService.getAlluser();
        try {
            userService.deleteUser(user3.getId());
            System.out.println("유저 삭제 성공");

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        // 삭제 후 전체 유저 수
        System.out.println("삭제 후 전체 유저 수 : " + foundUsersAfterDelete.size());


        //삭제 실패 확인
        UUID fakeId = UUID.randomUUID(); // 절대 존재하지 않는 id

        try {
            userService.deleteUser(fakeId);
            System.out.println("삭제 성공(이게 뜨면 이상함)");
        } catch (IllegalArgumentException e) {
            System.out.println("[삭제 실패 확인] " + e.getMessage());
        }


        //5.이름 중복 테스트 (throw)
        try {
            userService.create("박민군", "bmingun@gmail.com", "010-1234-5678");
            userService.create("박민군", "bmingun@gmail.com", "010-2222-2222"); // 중복
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        System.out.println("전체 유저 수 : " + userService.getAlluser().size());

        //6.Stream API를 통해 JCF의 데이터 조회
        userService.create("김민규", "lyi@nate.com", "010-1234-5678");
        userService.create("조용준", "ysj@naver.com", "010-9101-1121");
        userService.getAlluser()
                .stream()
                .filter(u -> u.getEmail().contains("nate"))
                .forEach(System.out::println);
    }

    // Message
    static void messageCRUDTest(MessageService messageService, UUID channelId, UUID senderId) {
        System.out.println("\n===============================");
        System.out.println("Message 기능 테스트");
        System.out.println("===============================\n");

        //1.생성
        Message message = messageService.create(channelId, senderId, "안녕하세요!!");
        System.out.println("메시지 생성: " + message.getId());

        //2.조회
        Message found = messageService.findById(message.getId());
        System.out.println("메시지 조회: " + found.getContent());

        //3.조회
        Message updated = messageService.updateMessage(message.getId(), "안녕?");
        System.out.println("메시지 수정: " + updated.getContent());

        //4.삭제
        boolean deleted = messageService.delete(message.getId());
        System.out.println("메시지 삭제 성공?: " + deleted);

        //5.삭제 후 조회
        System.out.println("삭제 후 조회: " + messageService.findById(message.getId()));
    }

    //Channel
    static void channelCRUDTest(ChannelService channelService) {
        System.out.println("\n===============================");
        System.out.println("Channel 기능 테스트");
        System.out.println("===============================\n");
        // 생성
        Channel channel = channelService.create("공지");
        System.out.println("채널 생성: " + channel.getId());

        // 조회
        Channel foundChannel = channelService.findById(channel.getId());
        System.out.println("채널 조회(단건): " + foundChannel.getId());
        List<Channel> foundChannels = channelService.findAll();
        System.out.println("채널 조회(다건): " + foundChannels.size());

        // 수정
        Channel updatedChannel = channelService.update(channel.getId(), "공지사항");
        System.out.println("채널 수정: " + updatedChannel.getName());

        // 삭제
        channelService.delete(channel.getId());
        List<Channel> foundChannelsAfterDelete = channelService.findAll();
        System.out.println("채널 삭제: " + foundChannelsAfterDelete.size());
    }
    public static void main(String[] args) {
        // 서비스 초기화
        UserService userService = new JCFUserService();
        ChannelService channelService = new JCFChannelService();
        MessageService messageService = new JCFMessageService(userService, channelService); //의존성 주입

        User testUser = userService.create("박서연", "psy@naver.com", "010-0642-4142");
        Channel testChannel = channelService.create("메시지테스트채널");
        System.out.println("메시지 테스트 유저 생성: " + testUser.getDisplayName());
        System.out.println("메시지 테스트 채널 생성: " + testChannel.getName());
        System.out.println("\n[예외 테스트]");
        try {
            messageService.create(UUID.randomUUID(), testUser.getId(), "실패해야 함");
        } catch (IllegalArgumentException e) {
            System.out.println("예외 확인: " + e.getMessage());
        }



        messageCRUDTest(messageService, testChannel.getId(), testUser.getId());

        // 테스트
        userCRUDTest(userService);
        channelCRUDTest(channelService);
        //messageCRUDTest(messageService, channelId, senderId);
    }

}


