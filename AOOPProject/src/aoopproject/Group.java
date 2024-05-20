package aoopproject;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<User> members;
    private List<Post> posts;
    private String groupID;
    private String groupTitle;

    public Group(String groupID, String groupTitle) {
        this.groupID = groupID;
        this.groupTitle = groupTitle;
        this.members = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void addPost(Post post) {
        posts.add(post);
    }
    
    public void addMember(User user) {
        members.add(user);
    }
    
    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    
    @Override
    public String toString() {
        return groupTitle;
    }
    
}
