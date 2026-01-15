package service;

import entity.Message;
import java.util.UUID;

public interface MessageService {

    //생성
    Message create(UUID channelId, UUID senderId, String content);

    //조회
    Message findById(UUID messageId);

    //수정
    Message updateMessage(UUID messageId, String content);

    //삭제
    boolean delete(UUID messageId);

}
