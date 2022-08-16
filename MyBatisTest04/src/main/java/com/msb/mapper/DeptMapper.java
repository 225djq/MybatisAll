package com.msb.mapper;

import com.msb.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * @Auther: dengjq
 * @Date: 2022/8/14
 * @Description: com.msb.mapper
 * @version: 1.0
 */
public interface DeptMapper {
    Dept findByDeptno(int deptno);

    @Insert("insert into dept values (DEFAULT,#{dname},#{loc})")
    int findInsert(Dept dept);

    @Update("update dept set dname = #{dname},loc = #{loc} where deptno = #{deptno}")
    int findUpdate(Dept dept);

    @Delete("delete from dept where deptno = #{deptno}")
    int findDelete(int dept);
}
