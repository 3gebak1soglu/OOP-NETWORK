package aoopproject;

public class Post {
    private String content;
    private String postedUser;
    
    public Post(String content) {
        this.content = content;
        this.postedUser = "";
    }
    public Post(String content, String postedUser) {
        this.content = content;
        this.postedUser = postedUser;
    }
    

    public String getContent() {
        return content;
    }
    
    public String getPostedUser() {
        return postedUser;
    }
}
