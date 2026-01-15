package service.jcf;

import service.MessageService;
import entity.Message;
import java.util.*;


public class JCFMessageService implements MessageService {
    private final List<Message> data = new ArrayList<>();

    //1.생성
    @Override
    public Message create(UUID channelId, UUID senderId, String content) {
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

    }
