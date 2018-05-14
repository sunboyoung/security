package com.zms.controller.resource;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.util.MenuUtil;
import com.zms.controller.bind.annotation.CurrentUser;
import com.zms.pojo.resource.Resource;
import com.zms.pojo.user.User;
import com.zms.service.resource.ResourceService;
import com.zms.service.user.UserService;
import com.zms.to.responseBean.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.spring.web.json.Json;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;

/**
 * @Author zms
 * @CreateTime 2017年12月8日上午10:49:51
 * @Description 关于后台管理的初始化操作
 */
@Controller
@RequestMapping("menu")
public class ResourceController {

    @Autowired
    private UserService userService;
    @Autowired
    private ResourceService resourceService;

    /**
     * 获取导航栏
     *
     * @param user
     * @return String
     * @author zms
     * @date 2017年12月27日下午3:51:30
     */
    @RequestMapping(value = "initMenu", method = RequestMethod.POST)
    @ResponseBody
    public String initMenu(@CurrentUser User user) throws UnsupportedEncodingException {
        System.out.println("进来了");
        //根据用户名获取资源权限id
        Set<Integer> permissionIds = userService.findPermissionIdByUserName(user.getUsername());
        //根据资源权限id获取资源
        List<Resource> resourcesList = userService.findResourceByPermissionId(permissionIds);
        JSONArray currentTree = new JSONArray();
        JSONArray treeNode = new JSONArray();
        JSONObject tree = new JSONObject();
        for (Resource resource : resourcesList) {
            currentTree = findChildrenResource(resource.getId());
            tree = toNode(resource);
            tree.put("children", currentTree);
            treeNode.add(tree);
        }
        /*
        //根据用户名查找用户权限
        Set<String> permissions = userService.findPermissions("zms");
        //根据用户权限查找顶级菜单
        List<Resource> resources = resourceService.findMenus(permissions);
        //根据用户权限查找子级菜单
        List<Resource> childrenResource = resourceService.findChildrenMenu(permissions);
        String menu = MenuUtil.initMenu(resources, childrenResource);
        return menu;*/
        System.out.println(treeNode.toString());
        return treeNode.toString();
    }

    /**
     * @Author:zms
     * @Description:根据父id查询子资源
     * @Date:2018/4/12 19:20
     */
    public JSONArray findChildrenResource(Long pid) {
        JSONArray tree = new JSONArray();
        List<Resource> resourceList = resourceService.findChildrenResource(pid);
        for (Resource resource : resourceList) {
            JSONArray children = findChildrenResource(resource.getId());
            JSONObject node = toNode(resource);
            if (children != null && children.size() > 0) {
                node.put("children", children);
            }
            tree.add(node);
        }
        return tree;
    }

    /**
     * @Author:zms
     * @Description:将节点转换为Json格式
     * @Date:2018/4/12 19:20
     */
    public JSONObject toNode(Resource resource) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", resource.getId());
        jsonObject.put("title", resource.getTitle());
        jsonObject.put("icon", resource.getIcon());
        jsonObject.put("url", resource.getUrl());
        return jsonObject;
    }

    /**
     * @Author:zms
     * @Description:初始化树形结构
     * @Date:2018/4/12 19:21
     */
    @RequestMapping(value = "initTree", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean initTree(@CurrentUser User user) throws UnsupportedEncodingException {
        /*
        Set<String> permissions = userService.findPermissions("zms");
        List<Resource> menu = resourceService.findMenus(permissions);
        List<Resource> childrenMenu = resourceService.findChildrenMenu(permissions);
        List<Resource> button = resourceService.findChildrenButton(permissions);
        List<Resource> result = MenuUtil.initTree(menu, childrenMenu, button);
        String json = JSONObject.toJSONString(result);
        System.out.println(json);*/
        return new ResponseBean(ResponseBean.SUCCESS, "哟西");
    }
}