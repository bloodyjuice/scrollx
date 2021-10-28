package devyatovski.yar.scrollx2.rest;


import com.fasterxml.jackson.annotation.JsonView;
import devyatovski.yar.scrollx2.domain.Like;
import devyatovski.yar.scrollx2.domain.Post;
import devyatovski.yar.scrollx2.domain.User;
import devyatovski.yar.scrollx2.domain.views.LikeView;
import devyatovski.yar.scrollx2.repo.LikeRepo;
import devyatovski.yar.scrollx2.repo.UserRepo;
import devyatovski.yar.scrollx2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/action")
public class ActionController {

    private final LikeRepo likeRepo;
    private final UserRepo userRepo;
    private final PostService postService;

    @Autowired
    public ActionController(LikeRepo likeRepo, UserRepo userRepo, PostService postService) {
        this.likeRepo = likeRepo;
        this.userRepo = userRepo;
        this.postService = postService;
    }

    @PostMapping("setLike/{postId}")
    @JsonView(LikeView.MainView.class)
    public Like setLike(@PathVariable Post postId, @RequestBody User user) {
        System.out.println(postId);
        System.out.println(user);
        return likeRepo.saveAndFlush(new Like(user, postId));
    }

    @PostMapping("resetLike/{postId}")
    public void resetLike(@PathVariable Post postId, @AuthenticationPrincipal User user) {
        postService.resetLike(postId, user);

    }
}
