package devyatovski.yar.scrollx2.repo;

import devyatovski.yar.scrollx2.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}