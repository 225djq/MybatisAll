package com.msb;

import com.msb.mapper.EmpMapper;
import com.msb.mapper.EmpMapper2;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: dengjq
 * @Date: 2022/8/13
 * @Description: com.msb.test
 * @version: 1.0
 */
public class Test4 {

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
    public void testAddEmp() throws ParseException {
        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
//        emp.setEname("SMITH");
//        emp.setEmpno(7521);
        emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("1981-04-02"));
        List<Emp> emps = mapper.findByCondition(emp);
        emps.forEach(System.out::println);
    }

    @Test
    public void testfindByCondition2() throws ParseException {
        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setEname("SMITH");
//        emp.setEmpno(7521);
//        emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("1981-04-02"));
        List<Emp> emps = mapper.findByCondition(emp);
        emps.forEach(System.out::println);
    }

    @Test
    public void testUpdateEmpByCondition() throws ParseException {
        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setEmpno(7521);
        emp.setEname("Tom");
        emp.setSal(2350.0);

        emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("1981-04-02"));
        mapper.updateEmpByCondtion(emp);

    }

    @Test
    public void testUpdateEmpByCondition2() throws ParseException {
        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setEmpno(7521);
        emp.setEname("Tom");
        emp.setSal(2350.0);
        emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("1981-04-02"));
        mapper.updateEmpByCondtion2(emp);
    }

    @Test
    public void testfindByEmpnos1() throws ParseException {
        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
        List<Emp> emps = mapper.findByEmpnos1(new int[]{7521,7839,7499});
        emps.forEach(System.out::println);
    }

    @Test
    public void testfindByEmpnos2() throws ParseException {
        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
        List<Integer> empno = new ArrayList<>();
        Collections.addAll(empno,7521,7839,7499);
        List<Emp> emps = mapper.findByEmpnos2(empno);
        emps.forEach(System.out::println);
    }


    @After
    public void release(){
        sqlSession.close();
    }
}
