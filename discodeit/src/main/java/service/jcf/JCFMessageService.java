package service.jcf;

import service.MessageService;
import entity.Message;
import java.util.*;
import service.UserService;
import service.ChannelService;



public class JCFMessageService implements MessageService {
    private final List<Message> data = new ArrayList<>();

    private final UserService userService; //의존성 투입(이 클래스는 UserService가 필요하다)
    private final ChannelService channelService; //의존성 투입(이 클래스는 ChannelService도 필요하다)


    //1.생성
    @Override
    public Message create(UUID channelId, UUID senderId, String content) {
        //의존성
        //1. 채널 존재 여부 확인
        if (channelService.findById(channelId) == null)
            throw new IllegalArgumentException("존재하지 않는 채널입니다.");

        //2. 유저 존재 여부 확인
        if (userService.findById(senderId) == null)
            throw new IllegalArgumentException("존재하지 않는 유저입니다.");

        //3.검증 통과 후 메세지 생성
        Message message = new Message(channelId, senderId, content);
        data.add(message);
        return message;
    }

    //2.조회
    @Override
    public Message findById(UUID messageId) {
        for (Message message : data) {
            if (message.getId().equals(messageId)) {
                return message;
            }
        }
        return null;
    }

    //3.수정
    @Override
    public Message updateMessage(UUID messageId, String content) {
        for (Message message : data) {
            if (message.getId().equals(messageId)) {
                message.updateContent(content);
                return message;
            }
        }
        return null;
    }
        //4. 삭제
        @Override
        public boolean delete(UUID messageId) {
            return data.removeIf(message -> message.getId().equals(messageId));
        }

    //의존성
    public JCFMessageService(UserService userService, ChannelService channelService) {
        this.userService = userService;
        this.channelService = channelService;
    }

}
