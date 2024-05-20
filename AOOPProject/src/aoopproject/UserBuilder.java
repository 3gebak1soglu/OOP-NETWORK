package aoopproject;

import java.util.List;

public class UserBuilder {
    protected User user;
    
    public UserBuilder(){
        this.user = new User();
    }
    
    public UserBuilder withUsername(String username){
        this.user.setUsername(username);
        return this;
    }
    
    public UserBuilder withEmail(String email){
        this.user.setEmail(email);
        return this;
    }
    
    public UserBuilder withName(String name){
        this.user.setName(name);
        return this;
    }
    
    public UserBuilder withSurname(String surname){
        this.user.setSurname(surname);
        return this;
    }
    
    public UserBuilder withFriends(List<User> friends){
        this.user.setFriends(friends);
        return this;
    }
    
    public UserBuilder withGroups(List<Group> groups) {
        this.user.setGroups(groups);
        return this;
    }
    
    public User build(){
        return this.user;
    }
}
