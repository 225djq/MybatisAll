package com.msb;

import com.msb.mapper.DeptMapper;
import com.msb.pojo.Dept;
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

/**
 * @Auther: dengjq
 * @Date: 2022/8/13
 * @Description: com.msb.test
 * @version: 1.0
 */
public class Test1 {

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
        sqlSession = factory.openSession(true);
    }


    @Test
    public void testfindByDeptno(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.findByDeptno(20);
//        System.out.println(dept);
    }

    @Test
    public void testDept(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
//        deptMapper.findInsert(new Dept(null,"总部","北京"));
        deptMapper.findUpdate(new Dept(43,"后勤","北京文教园"));
        deptMapper.findDelete(43);
//        System.out.println(dept);
    }

    @After
    public void release(){
        sqlSession.close();
    }
}
