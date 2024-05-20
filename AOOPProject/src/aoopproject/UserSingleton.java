package aoopproject;

public class UserSingleton {
    private User currentUser;
    private static UserSingleton instance = null;
    
    private UserSingleton(){
        currentUser = new User();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    
    public void addFriend(User friend) {
        this.currentUser.addFriend(friend);
    }
    
    public void removeFriend(User friend) {
        this.currentUser.removeFriend(friend);
    }
    
    public void addGroup(Group group) {
        this.currentUser.addGroup(group);
    }
    
    public static UserSingleton getInstance() {
        if (instance == null) {
            instance = new UserSingleton();
        }
        return instance;
    }
}
