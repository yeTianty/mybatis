package com.wuxin.dao;

/**
 * @author Tanoty
 * @version 1.0
 * @date 2021/3/9 10:32
 */

import com.wuxin.domain.User;

import java.util.Date;
import java.util.List;


public interface IUserDao {

    /**
     * 查询所有操作
     * @return
     */
    List<User> findTYAll();
    /**
     * 查询指定id
     *
     */
    User findTYOne(int i);

    /**
     * 删除指定id
     */
    User deleteTYOne(int i);

    /**
     * 增加数据
     */
    void insertTYOne(User user);

    /**
     * 更改数据
     */
    int updateTYOne(User user);
}
