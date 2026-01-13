package service;

import entity.Message;
import java.util.UUID;

public interface MessageService {

    Message create(UUID channelId, UUID senderId, String content);

    Message findById(UUID messageId);

    boolean delete(UUID messageId);


}
