package com.wuxin.test01;

/**
 * @author Tanoty
 * @version 1.0
 * @date 2021/3/9 10:32
 */

import com.wuxin.dao.IUserDao;
import com.wuxin.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Test01 {

    private IUserDao userDao;
    private SqlSession session;
    private InputStream in;

    @Test
    public void TestTY() throws Exception{
        List<User> users = userDao.findTYAll();
        for(User user : users){
            System.out.println(user);
        }
    }
    /**
     * 查询指定idTY
     * */
    @Test
    public void testfindTYOne(){
        User user = userDao.findTYOne(4);
        System.out.println(user);
    }
    /**
     * 删除指定id用户TY
     * */
    @Test
    public void testdeleteTYOne() throws Exception {
        userDao.deleteTYOne(9);
        session.commit();
    }

    /**
     * 增加数据
     */
    @Test
    public void testinsertTYOne() throws Exception {
        userDao.insertTYOne(new User("碧落", new Date(), "女", "湖北"));//        User user = new User();
        TestTY();
//        user.setUsername("田野");
//        user.setBirthday(new Date());
//        user.setSex("nan");
//        user.setAddress("hubei");
//        userDao.insertTYOne(user);
//        session.commit();
//        TestTY();
    }

    @Test
    public void updateTY() throws Exception {

        userDao.updateTYOne(new User(4,"小田",new Date(),"男","武信"));
        session.commit();
        TestTY();

//      User user = userDao.findTYOne(4);
//        user.setUsername("修改名字");
//        user.setBirthday(new Date());
//        user.setSex("女");
//        user.setAddress("修改地址");
//        userDao.updateTYOne(user);
//        session.commit();
//        TestTY();
    }


    @Before
    public void init() throws Exception {
        //1.读取配置文件
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
         session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
         userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void end() throws Exception {
        session.close();
        in.close();
    }

}
