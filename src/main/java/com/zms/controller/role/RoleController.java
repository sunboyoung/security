package com.zms.controller.role;

import com.zms.pojo.role.Role;
import com.zms.service.role.RoleService;
import com.zms.to.responseBean.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "getRoleList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean getRoleList() {
        List<Role> result = roleService.getRoleList();
        return new ResponseBean(ResponseBean.SUCCESS, "获取角色列表成功", result);
    }

}
