package shiroTest;

import com.zms.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application/application-test.xml"})
public class PermissionTest {

    @Autowired
    private UserService userService;

    @Test
    public void tt() {
        Set<String> roles = userService.findPermissions("zms");
        for (String role : roles
                ) {
            System.out.println(role);
        }
    }
}
