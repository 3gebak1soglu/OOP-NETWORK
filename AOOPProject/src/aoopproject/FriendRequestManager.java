package aoopproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FriendRequestManager {
    private static final String FRIEND_REQUEST_PATH = "database/friend_requests.txt";
    
    public static void sendFriendRequest(String sender, String recipient) {
        FriendRequest request = new FriendRequest(sender, recipient);
        writeFriendRequestToFile(request);
    }
    
    public static void acceptFriendRequest(String sender, String recipient) {
        removeFriendRequest(sender, recipient);
        FriendManager.addFriendship(sender, recipient);
    }
    
    public static void rejectFriendRequest(String sender, String recipient) {
        removeFriendRequest(sender, recipient);
    }
    
    public static List<String> getPendingFriendRequests(String currentUsername) {
        List<FriendRequest> allFriendRequests = readFriendRequestsFromFile();
        List<String> friendRequests = new ArrayList<>();
        for (FriendRequest request : allFriendRequests) {
            if (request.getRecipientUsername().equals(currentUsername)) {
                friendRequests.add(request.getSenderUsername());
            }
        }
        return friendRequests;
    }
    
    public static List<String> getSendingFriendRequests(String currentUsername) {
        List<FriendRequest> allFriendRequests = readFriendRequestsFromFile();
        List<String> friendRequests = new ArrayList<>();
        for (FriendRequest request : allFriendRequests) {
            if (request.getSenderUsername().equals(currentUsername)) {
                friendRequests.add(request.getRecipientUsername());
            }
        }
        return friendRequests;
    }
    
    
    private static void writeFriendRequestToFile(FriendRequest request) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FRIEND_REQUEST_PATH, true))) {
            writer.write(request.getSenderUsername() + "," + request.getRecipientUsername() + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void removeFriendRequest(String sender, String recipient) {
        List<FriendRequest> requests = readFriendRequestsFromFile();
        requests.removeIf(request -> request.getSenderUsername().equals(recipient) && request.getRecipientUsername().equals(sender));
        rewriteFriendRequestsToFile(requests); 
    }
    
    private static List<FriendRequest> readFriendRequestsFromFile() {
        List<FriendRequest> requests = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FRIEND_REQUEST_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String sender = parts[0];
                String recipient = parts[1];
                requests.add(new FriendRequest(sender, recipient));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return requests;
    }
    
    private static void rewriteFriendRequestsToFile(List<FriendRequest> requests) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FRIEND_REQUEST_PATH))) {
            for (FriendRequest request : requests) {
                writer.write(request.getSenderUsername() + "," + request.getRecipientUsername() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}