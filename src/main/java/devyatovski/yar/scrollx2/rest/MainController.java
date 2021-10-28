package devyatovski.yar.scrollx2.rest;

import devyatovski.yar.scrollx2.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Controller("/")
public class MainController {

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal User user) {
        HashMap<Object, Object> data = new HashMap<>();
        if (user != null) {

//            User user = userService.getUserLdap(LdapUser);
//            List<UserTest> userTests = userTestRepos.findByUserOrderByIdDesc(user);
//            List<Test> testList = testSevice.testsForUser(user, userTests);



//            data.put("tests", testList);
            user.setComments(null);
            user.setPosts(null);
            data.put("profile", user);
//            data.put("userTests", userTests);

        }


        byte a = 127;
        a++;

        System.out.println(a);

        model.addAttribute("frontendData", data);
        return "index";
    }

}
