package com.zms.controller.menu;

import com.alibaba.fastjson.JSONObject;
import com.zms.pojo.menu.ChildrenMenu;
import com.zms.pojo.menu.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("menu")
public class MenuController {
    @RequestMapping(value = "initMenu", method = RequestMethod.POST)
    @ResponseBody
    public String initMenu(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        Menu menu = new Menu();
        long number = 1l;
        menu.setId(number);
        menu.setTitle("区域管理");
        menu.setDescription("这是父节点");
        menu.setSpread(Boolean.FALSE);
        menu.setIcon("fa-stop-circle");
        ChildrenMenu childrenMenu = new ChildrenMenu();
        childrenMenu.setId(1L);
        childrenMenu.setTitle("会员管理");
        childrenMenu.setIcon("fa-stop-circle");
        childrenMenu.setSpread(Boolean.FALSE);
        childrenMenu.setDescription("这是子节点");
        childrenMenu.setUrl("login.jsp");
        List<Menu> list = new ArrayList<Menu>();
        List<ChildrenMenu> list2 = new ArrayList<ChildrenMenu>();
        list.add(menu);
        list2.add(childrenMenu);
        list.get(0).setChildren(list2);
        String json = JSONObject.toJSONString(list);
        System.out.println(json);
        return json;
    }
}
