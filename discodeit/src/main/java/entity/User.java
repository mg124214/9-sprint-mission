package entity;

import java.util.UUID;

public class User {
    private UUID id;
    private String displayName;
    private String email;
    private String phoneNumber;
    private Long createdAt;
    private Long updatedAt;

    public User(String displayName, String email, String phoneNumber) {
        this.id = UUID.randomUUID();
        this.displayName = displayName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        long now = System.currentTimeMillis();
        this.createdAt = now;
        this.updatedAt = now;
    }

    public UUID getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    /*public User update(String displayName, String email, String phoneNumber){
      return
    }*/
    //Todo update 메서드 추가


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
