package devyatovski.yar.scrollx2.domain;

import com.fasterxml.jackson.annotation.JsonView;
import devyatovski.yar.scrollx2.domain.views.EntityView;
import devyatovski.yar.scrollx2.domain.views.PostView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "pst")
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JsonView({PostView.MainView.class})
    private Long id;
    @JsonView(PostView.Information.class)
    private String title;
    @JsonView(PostView.Information.class)
    private String description;
    @JsonView(PostView.Information.class)
    private String picture;

    public boolean isLiked(User user) {
        return (this.likes.stream().anyMatch(like -> like.getUser() == user));
    }

    public void setLiked(boolean liked, User user) {
        this.liked = (this.likes.stream().anyMatch(like -> like.getUser() == user));
    }

    @Transient
    @JsonView(PostView.Information.class)
    private boolean liked;


//    @JsonView(PostView.Information.class)
//    public List<Like> getFirstLikers() {
//        if (likes.size() > 3) {
//            return likes.subList(0, 3);
//        }
//        return likes;
//    }

//    @JsonView(PostView.Information.class)
//    public boolean getLikedByUser(@AuthenticationPrincipal User user) {
//        return likes.stream().anyMatch(like -> like.getUser() == user);
//    }

//    @JsonView(PostView.Information.class)
//    public Integer getTotalLikes() {
//        return likes.size();
//    }


//    @Transient
//    private boolean wasLiked(User user) {
//        return (this.likes.stream().anyMatch(like -> like.getUser() == user));
//    };


    @OneToMany(mappedBy = "post")
    @JsonView(PostView.class)
    private List<Comments> comments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonView(PostView.Information.class)
    private User author;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post")
    @JsonView(PostView.Information.class)
    private List<Like> likes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public Post() {
    }

    public Post(String title, String description, String picture, List<Comments> comments, User author, List<Like> likes) {
        this.title = title;
        this.description = description;
        this.picture = picture;
        this.comments = comments;
        this.author = author;
        this.likes = likes;
        this.liked = isLiked();
    }
}
