package aoopproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static final String USERS_PATH = "database/users/";
    
    public static User getUserInfoFromFile(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_PATH.concat(username).concat("/info.txt")))) {
            reader.readLine();
            String name = reader.readLine();
            String surname = reader.readLine();
            String email = reader.readLine();
            
            User user = new UserBuilder()
                    .withUsername(username)
                    .withName(name)
                    .withSurname(surname)
                    .withEmail(email)
                    .build();
            
            return user;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }
    
    public static List<User> getAllUsersFromFile(String currentUsername) {
        List<User> users = new ArrayList<>();
        
        try {
            File directory = new File(USERS_PATH);
            String contents[] = directory.list();
            
            for (String content : contents) {
                if (!content.equals(currentUsername)) {
                    BufferedReader reader = new BufferedReader(new FileReader(USERS_PATH.concat(content).concat("/info.txt")));
                    reader.readLine();
                    User user = new UserBuilder()
                            .withUsername(content)
                            .withName(reader.readLine())
                            .withSurname(reader.readLine())
                            .build();
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.toString());;
        }
        return users;
    }
}
