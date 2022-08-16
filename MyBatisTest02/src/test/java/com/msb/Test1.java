package com.msb;

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
    public void testFindAll(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = empMapper.findAll();
        emps.forEach(System.out::println);
    }

    @Test
    public void testFindEmpno(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.findByEmpno(7499);
        System.out.println(emp);
    }

    @Test
    public void testFindDeptnoAndSal(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = empMapper.findDeptAndSal(20,3000.0);
        emps.forEach(System.out::println);
    }

    @Test
    public void testFindDeptnoAndSal2(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("deptno",20);
        map.put("sal",3000.0);
        List<Emp> emps = empMapper.findDeptAndSal2(map);
        emps.forEach(System.out::println);
    }

    @Test
    public void testFindDeptnoAndSal3(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setDeptno(20);
        emp.setSal(3000.0);
        List<Emp> emps = empMapper.findDeptAndSal3(emp);
        emps.forEach(System.out::println);
    }

    @Test
    public void testFindDeptnoAndSal4(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp empa = new Emp();
        empa.setDeptno(20);
        Emp empb = new Emp();
        empb.setSal(3000.0);
        List<Emp> emps = empMapper.findDeptAndSal4(empa,empb);
        emps.forEach(System.out::println);
    }

    @Test
    public void testFindByEname(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);

        List<Emp> emps = empMapper.findByEname("a");
        emps.forEach(System.out::println);
    }

    @After
    public void release(){
        sqlSession.close();
    }
}
