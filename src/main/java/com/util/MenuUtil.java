package com.util;


import com.alibaba.fastjson.JSONObject;
import com.zms.pojo.resource.Resource;

import java.util.List;

public class MenuUtil {

    /**
     * 获取首页侧边导航栏以及子级菜单
     *
     * @param
     * @return
     * @author zms
     * @date 2017年12月27日下午3:37:40
     */
    public static String initMenu(List<Resource> menu, List<Resource> childrenMenu) {
        for (int index = 0; index < menu.size(); index++) {
            for (int childrenIndex = 0; childrenIndex < childrenMenu.size(); childrenIndex++) {
                if (menu.get(index).getId() == childrenMenu.get(childrenIndex).getParent_id()) {
                    menu.get(index).getChildren().add(childrenMenu.get(childrenIndex));
                }
            }
        }
        String json = JSONObject.toJSONString(menu);

        return json;
    }

    public static List<Resource> initTree(List<Resource> menu, List<Resource> childrenMenu, List<Resource> button) {
        for (int index = 0; index < menu.size(); index++) {
            for (int childrenIndex = 0; childrenIndex < childrenMenu.size(); childrenIndex++) {
                for (int buttonIndex = 0; buttonIndex < button.size(); buttonIndex++) {
                    if (childrenMenu.get(childrenIndex).getId() == button.get(buttonIndex).getParent_id()) {
                        childrenMenu.get(childrenIndex).getChildren().add(button.get(buttonIndex));
                    }
                }
                if (menu.get(index).getId() == childrenMenu.get(childrenIndex).getParent_id()) {
                    menu.get(index).getChildren().add(childrenMenu.get(childrenIndex));
                }
            }
        }

        return menu;
    }
}
