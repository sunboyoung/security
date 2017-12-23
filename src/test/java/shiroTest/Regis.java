package shiroTest;

import com.zms.pojo.user.User;
import com.zms.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-mvc.xml")
public class Regis {
    @Autowired
    private UserService userService;

    @Test
    public void test() {
        User user = new User();
        user.setUsername("zms");
        user.setPassword("123");
        userService.createUser(user);
    }
}
