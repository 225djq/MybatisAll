package com.msb;

import com.msb.mapper.DeptMapper;
import com.msb.mapper.EmpMapper;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        sqlSession = factory.openSession(true);
    }

    @Test
    public void testAddDept(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept(null,"Java","北京");
        System.out.println(dept.getDeptno());
        deptMapper.addDept(dept);
        System.out.println(dept.getDeptno());
    }

    @Test
    public void testAddDept2(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept(null,"Java","北京");
        System.out.println(dept.getDeptno());
        deptMapper.addDept2(dept);
        System.out.println(dept.getDeptno());
    }

    @After
    public void release(){
        sqlSession.close();
    }
}
