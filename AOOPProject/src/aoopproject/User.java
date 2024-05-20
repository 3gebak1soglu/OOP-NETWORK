package aoopproject;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username = "";
    private String email = "";
    private String name = "";
    private String surname = "";
    private List<User> friends;
    private List<Group> groups;

    public User(){
        this.username = "";
        this.email = "";
        this.name = "";
        this.surname = "";
        this.friends = new ArrayList<>();
        this.groups = new ArrayList<>();
    }

    public void addFriend(User friend) {
        friends.add(friend);
    }
    
    public void removeFriend(User friend) {
        friends.remove(friend);
    }
    
    public void addGroup(Group group) {
        groups.add(group);
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<User> getFriends() {
        return friends;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
