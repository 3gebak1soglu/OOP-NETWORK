package aoopproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FriendManager {
    private static final String USERS_PATH = "database/users/";
    
    public static List<String> readFriendsFromFile(String username) {
        List<String> userFriends = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_PATH.concat(username).concat("/friends.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                userFriends.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userFriends;
    }
    
    public static void addFriendship(String user1, String user2) {
        addFriend(user1, user2);
        addFriend(user2, user1);
    }
    
    private static void addFriend(String username, String friendUsername) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_PATH.concat(username).concat("/friends.txt"), true))) {
            writer.write(friendUsername + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void removeFriendship(String user1, String user2) {
        removeFriend(user1, user2);
        removeFriend(user2, user1);
    }
    
    private static void removeFriend(String username, String friendUsername) {
        List<String> friends = readFriendsFromFile(username);
        friends.removeIf(friend -> friend.equals(friendUsername));
        rewriteFriendsToFile(friends, username); 
    }
    
    private static void rewriteFriendsToFile(List<String> friends, String username){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_PATH.concat(username).concat("/friends.txt")))) {
            for (String friend : friends) {
                writer.write(friend + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
