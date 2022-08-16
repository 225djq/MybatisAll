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
public interface EmpMapper2 {
    List<Emp> findByCondition(Emp emp);
    List<Emp> findByCondition2(Emp emp);
    int updateEmpByCondtion(Emp emp);
    int updateEmpByCondtion2(Emp emp);

    List<Emp> findByEmpnos1(int[] empos);
    List<Emp> findByEmpnos2(List<Integer> empos);
}
