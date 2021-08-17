package com.wang.dao;

import com.wang.pojo.User;
import com.wang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void test() {
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();

    }

    //    @Test
//    public void getUserById(){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        UserDao mapper = sqlSession.getMapper(UserDao.class);
//        User user = mapper.getUserById(1);
//        System.out.println("编号为1的用户："+user);
//
//        //关闭SqlSession
//        sqlSession.close();
//    }
//    @Test
//    public void getUserById2() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        UserDao mapper = sqlSession.getMapper(UserDao.class);
//
//
//        Map<String,Object> map=new HashMap<String, Object>();
//        map.put("id",1);
//        map.put("name","张三");
//        User user=mapper.getUserById2(map);
//        System.out.println("编号为1的用户：" + user);
//
//        //关闭SqlSession
//        sqlSession.close();
//    }


    @Test
    public void getUserLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserLike("李");
        for (User user : userList) {
            System.out.println(user);
        }
        //关闭SqlSession
        sqlSession.close();
    }
    //    @Test
//    public void addUser(){
//        SqlSession sqlSession=MybatisUtils.getSqlSession();
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        userDao.addUser(new User(4,"礼拜四","999999"));
//        sqlSession.commit();//提交事务
//        sqlSession.close();
//    }
//    @Test
//    public void addUser2() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("userid", 5);
//        map.put("userName", "发");
//        map.put("password", "888888");
//
//        userDao.addUser2(map);
//        sqlSession.commit();//提交事务
//        sqlSession.close();
//    }


//    @Test
//    public void updateUser(){
//        SqlSession sqlSession=MybatisUtils.getSqlSession();
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        userDao.updateUser(new User(4,"星期四","808080"));
//        sqlSession.commit();
//        sqlSession.close();
//    }
//    @Test
//    public void deleteUser(){
//        SqlSession sqlSession=MybatisUtils.getSqlSession();
//        UserDao userDao=sqlSession.getMapper(UserDao.class);
//        userDao.deleteUser(5);
//        sqlSession.commit();
//        sqlSession.close();
//    }
}

