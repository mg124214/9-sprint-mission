package entity;

import org.w3c.dom.ls.LSOutput;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class Channel {
    private UUID id;
    private Long createdAt;
    private Long updatedAt;
    private String name;
    private final List<UUID> messageIds = new ArrayList<>();

    public Channel(String name) {
        this.id = UUID.randomUUID();
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = this.createdAt;
        this.name = name;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public Long getCreatedAt() { return createdAt; }
    public Long getUpdatedAt() { return updatedAt; }

    public void update(String name) {
        this.name = name;
        this.updatedAt = System.currentTimeMillis();
    }







    }
