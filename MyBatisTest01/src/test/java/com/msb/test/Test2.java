package com.msb.test;

import com.msb.pojo.Dept;
import com.msb.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: dengjq
 * @Date: 2022/8/13
 * @Description: com.msb.test
 * @version: 1.0
 */
public class Test2 {

    private SqlSession sqlSession;

    @Before
    public void init(){
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory factory = ssfb.build(inputStream);
        sqlSession = factory.openSession();
    }

    @Test
    public void testFindOne(){
        //查询单个对象
        System.out.println("sqlSession查询单个对象：");
        Emp emp = sqlSession.selectOne("findOne");
        System.out.println(emp);
    }

    @Test
    public void testFindAll(){
        //查询多个对象的集合
        System.out.println("sqlSession查询对象List集合：");
        List<Emp> emps = sqlSession.selectList("EmpMapper.findAll");
        emps.forEach(System.out::println);
    }

    @Test
    public void testFindEmpMap(){
        //查询多个对象的Map集合
        System.out.println("sqlSession查询对象Map集合:");
        Map<Integer,Emp> emps = sqlSession.selectMap("findEmpMap","EMPNO");
        Set<Integer> empnos = emps.keySet();
        for (Integer i:empnos
             ) {
            System.out.println(i+" : "+emps.get(i));
        }
    }
    @After
    public void release(){
        sqlSession.close();
    }
}
