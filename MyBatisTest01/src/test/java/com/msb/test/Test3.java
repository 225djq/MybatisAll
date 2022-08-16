package com.msb.test;

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
import java.util.Set;

/**
 * @Auther: dengjq
 * @Date: 2022/8/13
 * @Description: com.msb.test
 * @version: 1.0
 */
public class Test3 {

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
        //单个数据类型作为参数
        Emp emp = sqlSession.selectOne("findByEmpno",7499);
        System.out.println(emp);
    }
    @Test
    public void testFindMap(){
        //测试Map集合作为参数
        Map<String,Object> args = new HashMap<>();
        args.put("deptno",20);
        args.put("sal",1500.0);

        List<Emp> emps = sqlSession.selectList("findEmpByDeptnoAndSal",args);
        emps.forEach(System.out::println);
    }
    @Test
    public void testEmpMap(){
        //测试Emp类作为参数
        Emp arg = new Emp();
        arg.setDeptno(10);
        arg.setSal(2000.0);

        List<Emp> emps = sqlSession.selectList("findEmpByDeptnoAndSal2",arg);
        emps.forEach(System.out::println);
    }
    @After
    public void release(){
        sqlSession.close();
    }
}
