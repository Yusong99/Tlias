package org.xys.tlias.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.xys.tlias.pojo.Emp;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    //获取总记录数
    @Select("select count(*) from emp")
    Long count();

    //获取当前页的结果列表
//    @Select("select * from emp")
    List<Emp> list();

    //获取当前页的结果列表
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    //批量删除
    void delete(List<Integer> ids);

    //新增员工
    //@Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
    //       "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime});")
    void insert(Emp emp);
}
