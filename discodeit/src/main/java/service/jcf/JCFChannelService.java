package service.jcf;

import entity.Channel;
import entity.User;
import service.ChannelService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JCFChannelService implements ChannelService{
    private final List<Channel> data = new ArrayList<>();

    //생성
    @Override
    public Channel create(String name) {
        Channel channel = new Channel(name);
        data.add(channel);
        return channel;
    }
    //조회
    @Override
    public Channel findById(UUID channelId) {
        for (Channel channel : data) {
            if (channel.getId().equals(channelId)) {
                return channel;
            }
        }
        return null;
    }

    @Override
    public List<Channel> findAll() {
        return data;
    }

    //수정
    @Override
    public Channel update(UUID channelId, String name) {
        Channel channel = findById(channelId);

        if (channel == null) return null;

        channel.update(name);
        return channel;
    }

    //삭제
    @Override
    public void delete(UUID channelId) {
        boolean deleted = data.removeIf(channel -> channel.getId().equals(channelId));
        if (!deleted) {
            throw new IllegalArgumentException("삭제할 채널이 없습니다.");
        }
    }

}