package shiroTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.util.MenuUtil;
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
import org.springframework.test.context.web.WebAppConfiguration;
import springfox.documentation.spring.web.json.Json;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
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

    @Test
    public void foreach() {
        Set<Integer> permissionids = userService.findPermissionIdByUserName("zms");
        List<Resource> resources = userService.findResourceByPermissionId(permissionids);

        JSONArray jsonArray = new JSONArray();
        for (Resource resource : resources
                ) {
            if (resource.getParent_id() == 0) {
                jsonArray.add(resource);
            } else {

            }

        }
        System.out.println(jsonArray);
    }

    @Test
    public void zms() {
        Set<Integer> permissionids = userService.findPermissionIdByUserName("zms");
        List<Resource> resources = userService.findResourceByPermissionId(permissionids);
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (Resource resource : resources
                ) {
            jsonArray.add(zhejiushiw(resource.getId()));

        }

        System.out.println(jsonArray);
    }

    public JSONObject zhejiushiw(Long parent_id) {
        List<Resource> resources = userService.findResourceByParentId(parent_id);
        JSONArray array = new JSONArray();
        for (Resource resource : resources
                ) {
            array.add(resource);
        }
        JSONObject object = new JSONObject();
        object.put("children", array);
        return object;
    }
}
