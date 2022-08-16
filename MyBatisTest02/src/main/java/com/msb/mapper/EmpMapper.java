package com.msb.mapper;

import com.msb.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Auther: dengjq
 * @Date: 2022/8/14
 * @Description: com.msb.mapper
 * @version: 1.0
 */
public interface EmpMapper {
    /**
     * 该方法用于返回所有的员工信息
     * @return 返回一个封装Emp对象的list集合
     */
    List<Emp> findAll();

    /**
     * 根据员工编号查询单个员工信息
     * @param empno
     * @return 如果找到了返回Emp对象，如果没有返回null
     */
    Emp findByEmpno(int empno);

    /**
     * 根据员工编号和薪资查询员工信息
     * @param empno
     * @param sal
     * @return 多个对象的List集合
     */
    List<Emp> findDeptAndSal(int deptno,double sal);

    List<Emp> findDeptAndSal2(Map<String,Object> map);
    List<Emp> findDeptAndSal3(Emp emp);
    List<Emp> findDeptAndSal4(@Param("empa") Emp empa, @Param("empb") Emp empb);

    /**
     * 根据员工姓名返回员工信息
     * @param ename 员工姓名片段
     * @return 多个员工对象集合
     */
    List<Emp> findByEname(String ename);

    /**
     * 增加员工信息
     * @param emp 存储新增员工信息的Emp对象
     * @return 对数据库产生影响的行数
     */
    int addEmp(Emp emp);

    /**
     * 根据员工编号修改员工姓名的方法
     * @param empno 员工编号
     * @param ename 修改后新的员工信息
     * @return 对数据库产生影响的行数
     */
    int updateEnameByEmpno(@Param("empno")int empno,@Param("ename") String ename);

    /**
     * 根据员工编号删除员工信息
     * @param empno 要删除的员工信息
     * @return 对数据库产生影响的行数
     */
    int deleteByEmpno(int empno);

}
