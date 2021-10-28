package devyatovski.yar.scrollx2.repo;

import devyatovski.yar.scrollx2.domain.Like;
import devyatovski.yar.scrollx2.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepo extends JpaRepository<Like, Long> {

}
