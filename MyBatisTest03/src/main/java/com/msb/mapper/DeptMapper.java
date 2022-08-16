package com.msb.mapper;

import com.msb.pojo.Dept;
import com.msb.pojo.Emp;

/**
 * @Auther: dengjq
 * @Date: 2022/8/14
 * @Description: com.msb.mapper
 * @version: 1.0
 */
public interface DeptMapper {
    /**
     * 根据部门编号查询部门信息及该部分的所有员工信息
     * @param deptno 要查询的部门编号
     * @return Dept对象,内部组合了一个Emp的List属性用于封装部门的所有员工信息
     */
    Dept findDeptJoinEmpByDeptno(int deptno);
}
