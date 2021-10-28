package devyatovski.yar.scrollx2.rest;


import com.fasterxml.jackson.annotation.JsonView;
import devyatovski.yar.scrollx2.domain.Post;
import devyatovski.yar.scrollx2.domain.User;
import devyatovski.yar.scrollx2.domain.views.PostView;
import devyatovski.yar.scrollx2.repo.PostRepository;
import devyatovski.yar.scrollx2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final PostRepository postRepository;
    private final PostService postService;

    @Autowired
    public NewsController(PostRepository postRepository, PostService postService) {
        this.postRepository = postRepository;
        this.postService = postService;
    }

    @GetMapping("getAll")
    @JsonView(PostView.Information.class)
    public List<Post> getNews(@AuthenticationPrincipal User user) {
        List<Post> postList = postRepository.findAll();
        if (user != null) postService.isLiked(postList, user);

        return postList;
    }
}
