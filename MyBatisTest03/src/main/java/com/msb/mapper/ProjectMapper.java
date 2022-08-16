package com.msb.mapper;

import com.msb.pojo.Emp;
import com.msb.pojo.Project;

/**
 * @Auther: dengjq
 * @Date: 2022/8/14
 * @Description: com.msb.mapper
 * @version: 1.0
 */
public interface ProjectMapper {
    /**
     * 根据项目编号查询一个项目信息及参与该项目的所欲员工信息
     * @param pid 项目编号
     * @return 所有信息封装的Project对象
     */
    Project findProjectJoinEmpsBypid(int pid);
}
