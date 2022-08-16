package com.msb;

import com.msb.mapper.DeptMapper;
import com.msb.mapper.EmpMapper;
import com.msb.mapper.ProjectMapper;
import com.msb.pojo.Dept;
import com.msb.pojo.Emp;
import com.msb.pojo.Project;
import com.msb.pojo.ProjectRecord;
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
    public void testOneToOne(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.findEmpJoinDeptByEmpno(7499);
        System.out.println(emp);
    }
    @Test
    public void testOneToMany(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.findDeptJoinEmpByDeptno(20);
        System.out.println(dept);
        List<Emp> empList = dept.getEmpList();
        empList.forEach(System.out::println);
    }
    @Test
    public void testManyToMany(){
        ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
        Project project = mapper.findProjectJoinEmpsBypid(2);
        System.out.println(project.getPid());
        System.out.println(project.getName());
        System.out.println(project.getMoney());

        List<ProjectRecord> projectRecords = project.getProjectRecords();
        projectRecords.forEach(System.out::println);
    }

    @After
    public void release(){
        sqlSession.close();
    }
}
