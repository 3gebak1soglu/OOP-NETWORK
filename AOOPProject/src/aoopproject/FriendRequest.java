package aoopproject;

public class FriendRequest {
    private String senderUsername;
    private String recipientUsername;

    // Constructor
    public FriendRequest(String senderUsername, String recipientUsername) {
        this.senderUsername = senderUsername;
        this.recipientUsername = recipientUsername;
    }

    // Getters and setters
    public String getSenderUsername() {
        return senderUsername;
    }

    public String getRecipientUsername() {
        return recipientUsername;
    }
}
