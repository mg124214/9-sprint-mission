package service;

import entity.Channel;
import java.util.List;
import java.util.UUID;


public interface ChannelService {

    //생성
    Channel create(String name);
    //조회
    Channel findById(UUID channelId);
    List<Channel> findAll();
    //수정
    Channel update(UUID channelId, String name);
    //삭제
    void delete(UUID channelId);
}
