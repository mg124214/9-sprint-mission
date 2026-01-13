package entity;

import java.util.UUID;


public class Message {
    private UUID id;
    private UUID channelId;
    private Long createdAt;
    private Long updatedAt;
    private String content;
    private UUID senderId;

    public Message(){
        this.id = UUID.randomUUID();
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = this.createdAt;
    }

    public Message(UUID channelId, UUID senderId, String content) {
        this.id = UUID.randomUUID();
        this.channelId = channelId;
        this.senderId = senderId;
        this.content = content;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = this.createdAt;
    }

    public Message(String content) {
        this.id = UUID.randomUUID();
        this.content = content;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = this.createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void updateContent(String content) {
        this.content = content;
        this.updatedAt = System.currentTimeMillis();
    }



    }
