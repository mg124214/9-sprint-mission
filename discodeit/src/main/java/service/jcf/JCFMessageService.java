package service.jcf;

import service.MessageService;
import entity.Message;
import java.util.*;

public class JCFMessageService implements MessageService {
    private final List<Message> data = new ArrayList<>();

    @Override
    public Message create(UUID channelId, UUID senderId, String content) {
        Message message = new Message(channelId, senderId, content);

        data.add(message);
        return message;
    }

    @Override
    public Message findById(UUID messageId) {
        for (Message message : data) {
            if (message.getId().equals(messageId)) {
                return message;
            }
        }
        return null;
    }

    @Override
    public boolean delete(UUID messageId) {
        return data.removeIf(message -> message.getId().equals(messageId));
    }
}
