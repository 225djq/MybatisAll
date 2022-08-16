package com.msb.mapper;

import com.msb.pojo.Emp;

/**
 * @Auther: dengjq
 * @Date: 2022/8/14
 * @Description: com.msb.mapper
 * @version: 1.0
 */
public interface EmpMapper {
    /**
     * 根据员工编号的所有信息并携带所在部门信息
     * @param empno 要查询员工的编号
     * @return 员工对象，结合Dept对象作为属性，对部门信息进行存储
     */
    Emp findByEmpno(int empno);
}
