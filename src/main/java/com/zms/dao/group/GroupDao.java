package com.zms.dao.group;

import java.util.Set;

/**
 * @Author:zms
 * @Description:用户组操作Dao
 * @Date:2018/4/12 16:33
 */
public interface GroupDao {
    /**
     * 根据用户id查询用户组id
     *
     * @param id
     * @return 用户组id
     */
    Set<Long> getGroupIdByUser(Long id);
}
