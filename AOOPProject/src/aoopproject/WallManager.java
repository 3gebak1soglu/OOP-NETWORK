package aoopproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WallManager {
    private static final String USERS_PATH = "database/users/";
    
    public static List<Post> readPostsFromFile(String username) {
        List<Post> posts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_PATH.concat(username).concat("/wall.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Post post = new Post(line);
                posts.add(post);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts;
    }
    
    public static void writePostToFile(String username, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_PATH.concat(username).concat("/wall.txt"), true))) {
            writer.write(content + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
