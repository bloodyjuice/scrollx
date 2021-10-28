package devyatovski.yar.scrollx2.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import devyatovski.yar.scrollx2.domain.views.EntityView;
import devyatovski.yar.scrollx2.domain.views.LikeView;
import devyatovski.yar.scrollx2.domain.views.PostView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "likes")
@Getter
@Setter
public class Like {
    @Id
    @GeneratedValue
    @JsonView(LikeView.Information.class)
    private Long id;
    @JsonView(LikeView.Information.class)
    private ReactionType reactionType;

    @OneToOne
    @JsonView({LikeView.Information.class})
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
//    @JsonView(LikeView.Information.class)
    @JsonIgnore
    private Post post;

    public ReactionType getReactionType() {
        return reactionType;
    }

    public void setReactionType(ReactionType reactionType) {
        this.reactionType = reactionType;
    }

    public Like() {
    }

    public Like(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public Like(ReactionType reactionType, User user, Post post) {
        this.reactionType = reactionType;
        this.user = user;
        this.post = post;
    }

}
