package devyatovski.yar.scrollx2.repo;

import devyatovski.yar.scrollx2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
