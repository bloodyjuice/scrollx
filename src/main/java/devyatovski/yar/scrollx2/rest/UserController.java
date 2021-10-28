package devyatovski.yar.scrollx2.rest;


import devyatovski.yar.scrollx2.domain.User;
import devyatovski.yar.scrollx2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("create")
    public User createUser(@RequestBody HashMap<String, String> userParams) {

        User user = new User(userParams.get("username"), userParams.get("password"));
        User newUser = userRepo.save(user);


        return newUser;
    }
}
