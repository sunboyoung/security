package shiroTest;

import com.zms.dao.resource.ResourceDao;
import com.zms.dao.user.UserDao;
import com.zms.pojo.resource.Resource;
import com.zms.pojo.user.User;
import com.zms.service.resource.ResourceService;
import com.zms.service.user.UserService;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application/application-test.xml"})
public class Regis {
    @Autowired
    private UserService userService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ResourceDao resourceDao;



    @Test
    public void test() {
        User user = new User();
        user.setUsername("ss");
        user.setPassword("123");
        userService.createUser(user);
    }

    @Test
    public void testtt() {

        Set<String> permissions = new HashSet<String>();
        permissions.add("menu:list");
        List<Resource> resources = resourceService.findMenus(permissions);
        System.out.println(resources.size());


    }
}
