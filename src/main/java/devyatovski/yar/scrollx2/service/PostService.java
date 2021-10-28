package devyatovski.yar.scrollx2.service;

import devyatovski.yar.scrollx2.domain.Like;
import devyatovski.yar.scrollx2.domain.Post;
import devyatovski.yar.scrollx2.domain.User;
import devyatovski.yar.scrollx2.repo.LikeRepo;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final LikeRepo likeRepo;

    @Autowired
    public PostService(LikeRepo likeRepo) {
        this.likeRepo = likeRepo;
    }

    public void isLiked(List<Post> posts, User user) {
        for (Post post : posts) {
            for (Like like : post.getLikes()) {
                post.setLiked(like.getUser().getUsername().equals(user.getUsername()));
            }
        }
    }

    public void resetLike(Post post, User user) {
        for (Like like: post.getLikes()) {
            if (like.getUser().equals(user)) {
                likeRepo.delete(like);
            }
        }
    }
}
