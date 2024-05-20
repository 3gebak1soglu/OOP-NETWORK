package aoopproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GroupManager {
    private static final String GROUPS_PATH = "database/groups/";
    private static final String USERS_PATH = "database/users/";
    
    private static boolean groupIDTaken(String groupID){
        try {
            Path directoryPath = Paths.get(GROUPS_PATH.concat(groupID));
            
            if (!Files.exists(directoryPath)) {
                Files.createDirectory(directoryPath);
                return false;
            }
            else {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public static void createGroup(String groupID, String groupTitle, String currentUsername) {
        boolean groupFound = groupIDTaken(groupID);
        
        if (!groupFound) {
            try {
                File members = new File(GROUPS_PATH.concat(groupID).concat("/members.txt"));
                members.createNewFile();
                
                File wall = new File(GROUPS_PATH.concat(groupID).concat("/wall.txt"));
                wall.createNewFile();
                
                File title = new File(GROUPS_PATH.concat(groupID).concat("/title.txt"));
                title.createNewFile();
                
                joinGroup(currentUsername, groupID);
                
                JOptionPane.showMessageDialog(null, "Group '" + groupTitle + "' has been created!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            try (BufferedWriter titleWriter = new BufferedWriter(new FileWriter(GROUPS_PATH.concat(groupID).concat("/title.txt"),true))){
                titleWriter.write(groupTitle + System.lineSeparator());
            
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Group ID already taken!");
        }
    }
    
    public static void joinGroup(String username, String groupID) {
        try (BufferedWriter memberWriter = new BufferedWriter(new FileWriter(GROUPS_PATH.concat(groupID).concat("/members.txt"), true))){
            memberWriter.write(username + System.lineSeparator());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedWriter userWriter = new BufferedWriter(new FileWriter(USERS_PATH.concat(username).concat("/groups.txt"), true))){
            userWriter.write(groupID + System.lineSeparator());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<User> getGroupMembers(String groupID) {
        List<User> members = new ArrayList<>();
        try (BufferedReader memberReader = new BufferedReader(new FileReader(GROUPS_PATH.concat(groupID).concat("/members.txt")))){
            String line;
            
            while((line = memberReader.readLine()) != null) {
                User user = UserManager.getUserInfoFromFile(line);
                members.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return members;
    }
    
    public static void postOnGroup(Post post, String groupID) {
        try (BufferedWriter postWriter = new BufferedWriter(new FileWriter(GROUPS_PATH.concat(groupID).concat("/wall.txt"), true))) {
            postWriter.write(post.getContent() + System.lineSeparator() + post.getPostedUser() + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Post> getGroupPosts(String groupID) {
        List<Post> posts = new ArrayList<>();
        try (BufferedReader postReader = new BufferedReader(new FileReader(GROUPS_PATH.concat(groupID).concat("/wall.txt")))){
            String line;
            while((line = postReader.readLine()) != null) {
                Post post = new Post(line, postReader.readLine());
                posts.add(post);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts;
    }
    
    public static List<Group> getAllGroupsFromFile() {
        List<Group> groups = new ArrayList<>();
        
        try {
            File directory = new File(GROUPS_PATH);
            String contents[] = directory.list();
            
            for (String content : contents) {
                Group group = getGroupInfo(content);
                groups.add(group);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return groups;
    }
    
    public static List<String> getGroupsOfUser(String username) {
        List<String> userGroups = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_PATH.concat(username).concat("/groups.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                userGroups.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userGroups;
    }
    
    public static Group getGroupInfo(String groupID) {
        List<User> members = new ArrayList<>();
        List<Post> posts = new ArrayList<>();
        String title = "";
        
        try (BufferedReader memberReader = new BufferedReader(new FileReader(GROUPS_PATH.concat(groupID).concat("/members.txt")))){
            String line;
            while ((line = memberReader.readLine()) != null) {
                members.add(UserManager.getUserInfoFromFile(line));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedReader wallReader = new BufferedReader(new FileReader(GROUPS_PATH.concat(groupID).concat("/wall.txt")))){
            String line;
            while ((line = wallReader.readLine()) != null) {
                String content = line;
                String postedUser = wallReader.readLine();
                Post post = new Post(content, postedUser);
                posts.add(post);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedReader titleReader = new BufferedReader(new FileReader(GROUPS_PATH.concat(groupID).concat("/title.txt")))){
            title = titleReader.readLine();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Group group = new Group(groupID, title);
        group.setMembers(members);
        group.setPosts(posts);
        return group;
    }
}
